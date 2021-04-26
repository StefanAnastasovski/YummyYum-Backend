package com.yummyyum.Repositories;

import com.yummyyum.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT * FROM payment as p WHERE p.name_on_card = :name",
            nativeQuery = true)
    List<Payment> getPaymentsByName(String name);

    @Query(value = "SELECT * FROM payment as p WHERE p.payment_date LIKE %:date%",
            nativeQuery = true)
    List<Payment> getPaymentsByDate(String date);



}
