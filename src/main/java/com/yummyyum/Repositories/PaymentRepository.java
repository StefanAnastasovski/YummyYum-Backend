package com.yummyyum.Repositories;

import com.yummyyum.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT * FROM payment as p WHERE p.payment_date LIKE %:date%",
            nativeQuery = true)
    List<Payment> getALlPaymentsByPaymentDate(String date);

    @Query(value = "SELECT * FROM payment as p WHERE p.payment_number_id = :paymentNumberId",
            nativeQuery = true)
    Optional<Payment> getPaymentByPaymentNumberID(@Param("paymentNumberId") String paymentNumberId);



}

