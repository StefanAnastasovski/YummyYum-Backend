package com.yummyyum.Services.History.ShippingAddressHistory;

import com.yummyyum.Model.History.ShippingAddressHistory;

import java.util.List;

public interface ShippingAddressHistoryService {

    List<ShippingAddressHistory> getAllShippingAddressHistoriesByUsername(String username);

    ShippingAddressHistory createNewShippingAddressHistory(String address, String zipCode, String username);

}
