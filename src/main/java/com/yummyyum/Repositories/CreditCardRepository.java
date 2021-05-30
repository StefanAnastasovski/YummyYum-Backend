package com.yummyyum.Repositories;

import com.yummyyum.Model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    @Query(value = "SELECT * FROM credit_card as cc WHERE cc.name_on_card = :name",
            nativeQuery = true)
    List<CreditCard> getCreditCardByName(String name);

    @Query(value = "SELECT * FROM credit_card as cc WHERE cc.card_number = :cardNumber",
            nativeQuery = true)
    Optional<CreditCard> getCreditCardByCardNumber(String cardNumber);

    @Query(value = "SELECT * FROM credit_card as cc JOIN user u on cc.user_id = u.id WHERE u.username = :username ;",
            nativeQuery = true)
    Optional<CreditCard> getCreditCardByUsername(String username);

//
//    @Query(value = "SELECT * FROM payment as p WHERE p.payment_date LIKE %:date%",
//            nativeQuery = true)
//    List<CreditCard> getCreditCardByDate(String date);


}
