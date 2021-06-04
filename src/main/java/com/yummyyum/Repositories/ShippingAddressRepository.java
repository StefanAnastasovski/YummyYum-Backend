package com.yummyyum.Repositories;

import com.yummyyum.Model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {

    @Query(value = "SELECT * FROM shipping_address as sa JOIN user u on sa.user_id = u.id WHERE u.username = :username",
            nativeQuery = true)
    Optional<ShippingAddress> getShippingAddressByUsername(String username);

}
