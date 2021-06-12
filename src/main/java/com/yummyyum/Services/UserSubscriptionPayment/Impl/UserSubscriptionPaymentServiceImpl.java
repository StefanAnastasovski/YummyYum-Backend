package com.yummyyum.Services.UserSubscriptionPayment.Impl;

import com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship.UserSubscriptionPayment;
import com.yummyyum.Repositories.UserSubscriptionPaymentRepository;
import com.yummyyum.Services.UserSubscriptionPayment.UserSubscriptionPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSubscriptionPaymentServiceImpl implements UserSubscriptionPaymentService {

    private final UserSubscriptionPaymentRepository userSubscriptionPaymentRepository;

    public UserSubscriptionPaymentServiceImpl(UserSubscriptionPaymentRepository userSubscriptionPaymentRepository) {
        this.userSubscriptionPaymentRepository = userSubscriptionPaymentRepository;
    }

    @Override
    public List<UserSubscriptionPayment> getUserSubscriptionPaymentByUsername(String username) {
        return userSubscriptionPaymentRepository.getUserSubscriptionPaymentByUsername(username);
    }

    @Override
    public List<UserSubscriptionPayment> getUserSubscriptionPaymentBySubscriptionPlan(String subscriptionPlan) {
        return userSubscriptionPaymentRepository.getUserSubscriptionPaymentBySubscriptionPlan(subscriptionPlan);
    }

    @Override
    public Optional<UserSubscriptionPayment> getUserSubscriptionPaymentByPaymentId(String paymentNumberId) {
        return userSubscriptionPaymentRepository.getUserSubscriptionPaymentByPaymentId(paymentNumberId);
    }

}
