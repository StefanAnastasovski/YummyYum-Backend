package com.yummyyum.Controllers;

import com.yummyyum.Model.Payment;
import com.yummyyum.Services.Payment.PaymentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/payment/name/{name}")
    public List<Payment> getPaymentsByName(@PathVariable("name") String name) {
        return paymentService.getPaymentsByName(name);
    }

    @GetMapping("/payment/date/{date}")
    public List<Payment> getPaymentsByDate(@PathVariable("date")
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") String date) {
        return paymentService.getPaymentsByDate(date);
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Payment createNewPayment(@RequestBody Payment payment,
                                    HttpServletResponse response,
                                    UriComponentsBuilder builder) {

        Payment payment1 = paymentService.createPayment(payment.getNameOnCard(),
                payment.getCardNumber(), payment.getExpirationDateMonth(),
                payment.getExpirationDateYear(), payment.getSecurityCode());
        response.setHeader("Location", builder.path("/api/payment/" + payment.getId()).
                buildAndExpand(payment.getId()).toUriString());

        return payment1;
    }

}
