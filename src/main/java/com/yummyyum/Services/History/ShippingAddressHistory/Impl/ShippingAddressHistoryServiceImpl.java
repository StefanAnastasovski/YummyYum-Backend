package com.yummyyum.Services.History.ShippingAddressHistory.Impl;

import com.yummyyum.Model.History.ShippingAddressHistory;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.History.ShippingAddressHistoryRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.History.ShippingAddressHistory.ShippingAddressHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressHistoryServiceImpl implements ShippingAddressHistoryService {

    private final ShippingAddressHistoryRepository shippingAddressHistoryRepository;
    private final UserRepository userRepository;

    public ShippingAddressHistoryServiceImpl(ShippingAddressHistoryRepository shippingAddressHistoryRepository,
                                             UserRepository userRepository) {
        this.shippingAddressHistoryRepository = shippingAddressHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ShippingAddressHistory> getAllShippingAddressHistoriesByUsername(String username) {
        return shippingAddressHistoryRepository.getShippingAddressHistoriesByUsername(username);
    }

    @Override
    public ShippingAddressHistory createNewShippingAddressHistory(String address, String zipCode, String username) {
        ShippingAddressHistory shippingAddressHistory = new ShippingAddressHistory(address, zipCode, new Date());
        Optional<User> user = userRepository.getUserByUsername(username);

        shippingAddressHistory.setUser(user.get());

        return shippingAddressHistoryRepository.save(shippingAddressHistory);
    }
}
