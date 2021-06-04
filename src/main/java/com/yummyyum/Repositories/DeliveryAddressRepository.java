package com.yummyyum.Repositories;

import com.yummyyum.Model.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

    @Query(value = "SELECT * FROM delivery_address as da " +
            "JOIN payment p on p.id = da.payment_id" +
            " WHERE p.payment_number_id=:cardNumberId",
            nativeQuery = true)
    Optional<DeliveryAddress> getDeliveryAddressByCardNumberId(String cardNumberId);

}