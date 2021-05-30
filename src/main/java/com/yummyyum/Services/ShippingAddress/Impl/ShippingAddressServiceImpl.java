package com.yummyyum.Services.ShippingAddress.Impl;

import com.yummyyum.Model.ShippingAddress;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.ShippingAddressRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.ShippingAddress.ShippingAddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final ShippingAddressRepository shippingAddressRepository;
    private final UserRepository userRepository;

    public ShippingAddressServiceImpl(ShippingAddressRepository shippingAddressRepository, UserRepository userRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressRepository.findAll();
    }

    @Override
    public Optional<ShippingAddress> getShippingAddressByUsername(String username) {
        return shippingAddressRepository.getShippingAddressByUsername(username);
    }

    @Override
    public ShippingAddress createShippingAddress(String address, String zipCode, String username) {

        Optional<ShippingAddress> oldShippingAddress = shippingAddressRepository.getShippingAddressByUsername(username);
        Optional<User> user = userRepository.getUserByUsername(username);

        ShippingAddress shippingAddress = new ShippingAddress();

        if (oldShippingAddress.isPresent()) {
            shippingAddress.setAddress(address);
            shippingAddress.setZipCode(zipCode);
            shippingAddress.setId(oldShippingAddress.get().getId());
        } else {
            shippingAddress = new ShippingAddress(address, zipCode);
        }

        shippingAddress.setUser(user.get());

        return shippingAddressRepository.save(shippingAddress);
    }

    @Override
    public ShippingAddress updateShippingAddress(String newAddress, String newZipCode, String username) {

        Optional<ShippingAddress> shippingAddress = shippingAddressRepository.getShippingAddressByUsername(username);
        Optional<User> user = userRepository.getUserByUsername(username);

        ShippingAddress oldShippingAddress = null;

        if (shippingAddress.isPresent())
            oldShippingAddress = shippingAddress.get();

        ShippingAddress newShippingAddress = new ShippingAddress(newAddress, newZipCode);
        newShippingAddress.setUser(user.get());

        newShippingAddress.setId(oldShippingAddress.getId());

        return shippingAddressRepository.saveAndFlush(newShippingAddress);
    }

}
