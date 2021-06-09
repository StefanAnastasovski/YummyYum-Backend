package com.yummyyum.Repositories.History;

import com.yummyyum.Model.History.ShippingAddressHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingAddressHistoryRepository extends JpaRepository<ShippingAddressHistory, Long> {
    @Query(value = "SELECT * FROM shipping_address_history as sah JOIN user as u on u.id = sah.user_id WHERE u.username = :username",
            nativeQuery = true)
    List<ShippingAddressHistory> getShippingAddressHistoriesByUsername(String username);
}
