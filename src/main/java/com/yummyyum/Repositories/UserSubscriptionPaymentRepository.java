package com.yummyyum.Repositories;

import com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship.UserSubscriptionPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserSubscriptionPaymentRepository extends JpaRepository<UserSubscriptionPayment, Long> {

    @Query(value = "SELECT  * FROM user_subscription_payment as usp JOIN user as u on u.id = usp.user_id " +
            "WHERE u.username = :username",
            nativeQuery = true)
    List<UserSubscriptionPayment> getUserSubscriptionPaymentByUsername(String username);

    @Query(value = "SELECT  * FROM user_subscription_payment as usp " +
            "JOIN subscription as s on s.id = usp.subscription_id JOIN subscription_plan as sp on sp.id = s.id" +
            " WHERE sp.name = :subscriptionPlan",
            nativeQuery = true)
    List<UserSubscriptionPayment> getUserSubscriptionPaymentBySubscriptionPlan(String subscriptionPlan);

    @Query(value = "SELECT * FROM user_subscription_payment as usp " +
            "JOIN payment as p on p.id = usp.payment_id " +
            " WHERE p.payment_number_id = :paymentNumberId",
            nativeQuery = true)
    Optional<UserSubscriptionPayment> getUserSubscriptionPaymentByPaymentId(String paymentNumberId);


}
