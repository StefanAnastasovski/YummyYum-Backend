package com.yummyyum.Controllers;

import com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship.UserSubscriptionPayment;
import com.yummyyum.Services.UserSubscriptionPayment.UserSubscriptionPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class UserSubscriptionPaymentController {

    private final UserSubscriptionPaymentService userSubscriptionPaymentService;

    public UserSubscriptionPaymentController(UserSubscriptionPaymentService userSubscriptionPaymentService) {
        this.userSubscriptionPaymentService = userSubscriptionPaymentService;
    }

    @GetMapping("/subscription-invoice/username={username}")
    public List<UserSubscriptionPayment> getUserSubscriptionPaymentByUsername(
            @PathVariable("username") String username){
        return userSubscriptionPaymentService.getUserSubscriptionPaymentByUsername(username);
    }

    @GetMapping("/subscription-invoice/subscription-plan={subscriptionPlanName}")
    public List<UserSubscriptionPayment> getUserSubscriptionPaymentBySubscriptionPlan(
            @PathVariable("subscriptionPlanName") String subscriptionPlanName) {
        return userSubscriptionPaymentService.getUserSubscriptionPaymentBySubscriptionPlan(subscriptionPlanName);
    }

    @GetMapping("/subscription-invoice/payment-number={paymentNumberId}")
    public Optional<UserSubscriptionPayment> getUserSubscriptionPaymentByPaymentId(
            @PathVariable("paymentNumberId") String paymentNumberId) {
        return userSubscriptionPaymentService.getUserSubscriptionPaymentByPaymentId(paymentNumberId);
    }

}
