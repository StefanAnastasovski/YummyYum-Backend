package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.PaymentInfoDTO;
import com.yummyyum.Model.Payment;
import com.yummyyum.Services.Payment.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments/paymentId={paymentNumberId}")
    public Optional<Payment> getPaymentByPaymentNumberID(@PathVariable("paymentNumberId") String paymentNumberId) {
        return paymentService.getPaymentByPaymentNumberID(paymentNumberId);
    }

    @GetMapping("/payments/date={date}")
    public List<Payment> getAllPaymentsByPaymentDate(@PathVariable("date") String date) {
        return paymentService.getAllPaymentsByPaymentDate(date);
    }

    @GetMapping("/payments/username={username}")
    public Optional<Payment> getPaymentByUsername(@PathVariable("username") String username) {
        return null;
    }

    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PaymentInfoDTO createNewPayment(@RequestBody PaymentInfoDTO payment,
                                           HttpServletResponse response,
                                           UriComponentsBuilder builder) {

        String paymentID;
        boolean isExist = false;
        LocalDateTime newDate = LocalDateTime.now();

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
//        // this will convert any number sequence into 6 character.
        String code = String.format("%06d", number);

        String stringTest1 = String.valueOf(newDate.getYear());
        String stringTest2 = String.valueOf(newDate.getMonthValue());
        String stringTest3 = String.valueOf(newDate.getDayOfMonth());

        paymentID = stringTest1 + stringTest2 + stringTest3 + code;

        Optional<Payment> paymentValues = paymentService.getPaymentByPaymentNumberID(paymentID);
        if (!paymentValues.isEmpty()) {
            isExist = true;
        }

        while (isExist) {
            number = rnd.nextInt(999999);
            code = String.format("%06d", number);
            paymentID = stringTest1 + stringTest2 + stringTest3 + code;
            Optional<Payment> paymentValues2 = paymentService.getPaymentByPaymentNumberID(paymentID);
            if (paymentValues2.isEmpty()) {
                isExist = false;
            }
        }

        return paymentService.createNewPayment(paymentID, payment.getCardNumber(),
                new Date(), payment.getTotalAmount(), payment.getAddress(), payment.getZipCode(),
                payment.getUsername(), payment.getOrderInfoId());
    }

}
