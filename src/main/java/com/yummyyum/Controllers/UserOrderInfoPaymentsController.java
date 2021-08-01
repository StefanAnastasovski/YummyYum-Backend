package com.yummyyum.Controllers;

import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import com.yummyyum.Services.UserOrderInfoPayment.UserOrderInfoPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class UserOrderInfoPaymentsController {

    private final UserOrderInfoPaymentService userOrderInfoPaymentService;

    public UserOrderInfoPaymentsController(UserOrderInfoPaymentService userOrderInfoPaymentService) {
        this.userOrderInfoPaymentService = userOrderInfoPaymentService;
    }

    @GetMapping("/order-invoice/username={username}/order-date={orderDate}")
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameAndOrderDate(@PathVariable("username") String username,
                                                                                    @PathVariable("orderDate") String orderDate) {
        return userOrderInfoPaymentService.getUserOrderInfoPaymentByUsernameAndOrderDate(username, orderDate);
    }

    @GetMapping("/order-invoice/username={username}/start-date={startDate}&end-date={endDate}")
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameBetweenDates(@PathVariable("username") String username,
                                                                                    @PathVariable("startDate") String startDate,
                                                                                    @PathVariable("endDate") String endDate) {
        return userOrderInfoPaymentService.getUserOrderInfoPaymentByUsernameBetweenDates(username, startDate, endDate);
    }

    @GetMapping("/order-invoice/order-date={orderDate}")
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderDate(@PathVariable("orderDate") String orderDate) {
        return userOrderInfoPaymentService.getUserOrderInfoPaymentByOrderDate(orderDate);
    }

    @GetMapping("/order-invoice/start-date={startDate}&end-date={endDate}")
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentBetweenDates(@PathVariable("startDate") String startDate,
                                                                          @PathVariable("endDate") String endDate) {
        return userOrderInfoPaymentService.getUserOrderInfoPaymentBetweenDates(startDate, endDate);
    }

    @GetMapping("/order-invoice/order-number={orderId}")
    public Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderId(@PathVariable("orderId") String orderId) {
        return userOrderInfoPaymentService.getUserOrderInfoPaymentByOrderId(orderId);
    }

    @GetMapping("/order-invoice/payment-number={paymentId}")
    public Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByPaymentId(@PathVariable("paymentId") String paymentId) {
        return userOrderInfoPaymentService.getUserOrderInfoPaymentByPaymentId(paymentId);
    }

    @PostMapping("/order-invoice/username={username}/orderId={orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserOrderInfoPayment createNewUserOrderInfoPayment(
            @PathVariable("username") String username,
            @PathVariable("orderId") String orderId,
            HttpServletResponse response,
            UriComponentsBuilder builder) {


        return userOrderInfoPaymentService.createNewUserOrderInfoPayment(username, orderId);
    }

}

