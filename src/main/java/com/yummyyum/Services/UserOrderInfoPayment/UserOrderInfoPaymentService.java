package com.yummyyum.Services.UserOrderInfoPayment;

import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;

import java.util.List;
import java.util.Optional;

public interface UserOrderInfoPaymentService {

    List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameAndOrderDate(String username, String orderDate);

    List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameBetweenDates(String username, String startDate, String endDate);

    List<UserOrderInfoPayment> getUserOrderInfoPaymentByBetweenDates(String startDate, String endDate);

    List<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderDate(String orderDate);

    List<UserOrderInfoPayment> getUserOrderInfoPaymentBetweenDates(String startDate, String endDate);

    Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderId(String orderId);

    Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByPaymentId(String paymentNumberId);
}
