package com.yummyyum.Services.DeliveryAddress.Impl;

import com.yummyyum.Model.ShippingAddress;
import com.yummyyum.Services.ShippingAddress.ShippingAddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryAddressServiceImpl implements ShippingAddressService {

    @Override
    public List<ShippingAddress> getAllShippingAddresses() {
        return null;
    }

    @Override
    public Optional<ShippingAddress> getShippingAddressByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public ShippingAddress createShippingAddress(String address, String zipCode, String username) {
        return null;
    }

    @Override
    public ShippingAddress updateShippingAddress(String newAddress, String newZipCode, String username) {
        return null;
    }
}
