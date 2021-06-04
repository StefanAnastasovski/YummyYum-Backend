package com.yummyyum.Repositories;

import com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship.UserOrderInfoPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserOrderInfoPaymentRepository extends JpaRepository<UserOrderInfoPayment, Long> {

    @Query(value = "SELECT uop.* FROM user_order_payment as uop " +
            "JOIN user as u on u.id = uop.user_id " +
            "JOIN payment as p on p.id = uop.payment_id " +
            "JOIN order_info as oi on oi.id = uop.order_info_id" +
            " WHERE u.username = :username AND oi.order_date LIKE %:orderDate%",
            nativeQuery = true)
    List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameAndOrderDate(String username, String orderDate);

    @Query(value = "SELECT uop.* FROM user_order_payment as uop " +
            "JOIN user as u on u.id = uop.user_id " +
            "JOIN payment as p on p.id = uop.payment_id " +
            "JOIN order_info as oi on oi.id = uop.order_info_id" +
            " WHERE u.username = :username AND DATE_FORMAT(oi.order_date,'%Y-%m-%d') BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<UserOrderInfoPayment> getUserOrderInfoPaymentByUsernameBetweenDates(String username, String startDate, String endDate);

    @Query(value = "SELECT uop.* FROM user_order_payment as uop " +
            "JOIN user as u on u.id = uop.user_id " +
            "JOIN payment as p on p.id = uop.payment_id " +
            "JOIN order_info as oi on oi.id = uop.order_info_id" +
            " WHERE oi.order_date LIKE %:orderDate%",
            nativeQuery = true)
    List<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderDate(String orderDate);

    @Query(value = "SELECT uop.* FROM user_order_payment as uop " +
            "JOIN user as u on u.id = uop.user_id " +
            "JOIN payment as p on p.id = uop.payment_id " +
            "JOIN order_info as oi on oi.id = uop.order_info_id" +
            " WHERE DATE_FORMAT(oi.order_date,'%Y-%m-%d') BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<UserOrderInfoPayment> getUserOrderInfoPaymentBetweenDates(String startDate, String endDate);

    @Query(value = "SELECT uop.* FROM user_order_payment as uop " +
            "JOIN user as u on u.id = uop.user_id " +
            "JOIN payment as p on p.id = uop.payment_id " +
            "JOIN order_info as oi on oi.id = uop.order_info_id" +
            " WHERE oi.order_id LIKE %:orderId%",
            nativeQuery = true)
    Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByOrderId(String orderId);

    @Query(value = "SELECT uop.* FROM user_order_payment as uop " +
            "JOIN user as u on u.id = uop.user_id " +
            "JOIN payment as p on p.id = uop.payment_id " +
            "JOIN order_info as oi on oi.id = uop.order_info_id" +
            " WHERE p.payment_number_id = :paymentId",
            nativeQuery = true)
    Optional<UserOrderInfoPayment> getUserOrderInfoPaymentByPaymentId(String paymentId);


}
