package com.yummyyum.Services.UserSubscriptionPayment;

import com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship.UserSubscriptionPayment;

import java.util.List;
import java.util.Optional;

public interface UserSubscriptionPaymentService {

    List<UserSubscriptionPayment> getUserSubscriptionPaymentByUsername(String username);

    List<UserSubscriptionPayment> getUserSubscriptionPaymentBySubscriptionPlan(String subscriptionPlan);

    Optional<UserSubscriptionPayment> getUserSubscriptionPaymentByPaymentId(String paymentNumberId);

}
