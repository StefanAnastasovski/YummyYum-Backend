package com.yummyyum.Services.ShippingAddress;

import com.yummyyum.Model.ShippingAddress;

import java.util.List;
import java.util.Optional;

public interface ShippingAddressService {

    List<ShippingAddress> getAllShippingAddresses();

    Optional<ShippingAddress> getShippingAddressByUsername(String username);

    ShippingAddress createShippingAddress(String address, String zipCode, String username);

    ShippingAddress updateShippingAddress(String newAddress, String newZipCode, String username);

}
