package com.yummyyum.Services.UserOrderInfoPayment.Impl;

import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import com.yummyyum.Repositories.UserOrderInfoPaymentRepository;
import com.yummyyum.Services.UserOrderInfoPayment.UserOrderInfoPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrderInfoPaymentServiceImpl implements UserOrderInfoPaymentService {

    private final UserOrderInfoPaymentRepository userOrderInfoPaymentRepository;

    public UserOrderInfoPaymentServiceImpl(UserOrderInfoPaymentRepository userOrderInfoPaymentRepository) {
        this.userOrderInfoPaymentRepository = userOrderInfoPaymentRepository;
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameAndOrderDate(String username, String orderDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByUsernameAndOrderDate(username, orderDate);
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameBetweenDates(String username,
                                                                                    String startDate, String endDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByUsernameBetweenDates(username, startDate, endDate);
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByBetweenDates(String startDate, String endDate) {
        return null;
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderDate(String orderDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByOrderDate(orderDate);
    }

    @Override
    public List<UserOrderInfoPayment> getUserOrderInfoPaymentBetweenDates(String startDate, String endDate) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentBetweenDates(startDate, endDate);
    }

    @Override

    public Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderId(String orderId) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByOrderId(orderId);
    }

    @Override
    public Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByPaymentId(String paymentNumberId) {
        return userOrderInfoPaymentRepository.getUserOrderInfoPaymentByPaymentId(paymentNumberId);
    }

}
