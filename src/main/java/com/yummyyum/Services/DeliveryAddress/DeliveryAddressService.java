package com.yummyyum.Services.DeliveryAddress;

import com.yummyyum.Model.DeliveryAddress;

import java.util.Optional;

public interface DeliveryAddressService {

    Optional<DeliveryAddress> getDeliveryAddressByCardNumberId(String cardNumberId);

    DeliveryAddress createNewDeliveryAddress(String address, String zipCode, String cardNumberId);

}
