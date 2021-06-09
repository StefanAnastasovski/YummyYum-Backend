package com.yummyyum.Services.History.SubscriptionHistory.Impl;

import com.yummyyum.Model.History.SubscriptionHistory;
import com.yummyyum.Model.User;
import com.yummyyum.Repositories.History.SubscriptionHistoryRepository;
import com.yummyyum.Repositories.UserRepository;
import com.yummyyum.Services.History.SubscriptionHistory.SubscriptionHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionHistoryServiceImpl implements SubscriptionHistoryService {

    private final SubscriptionHistoryRepository subscriptionHistoryRepository;
    private final UserRepository userRepository;

    public SubscriptionHistoryServiceImpl(SubscriptionHistoryRepository subscriptionHistoryRepository,
                                          UserRepository userRepository) {
        this.subscriptionHistoryRepository = subscriptionHistoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<SubscriptionHistory> getAllSubscriptionHistoryHistoriesByUsername(String username) {
        return subscriptionHistoryRepository.getSubscriptionHistoriesByUsername(username);
    }

    @Override
    public SubscriptionHistory createNewSubscriptionHistoryHistory(String subscriptionPlan, int numberOfWeeklyMeals,
                                                                   int servingsPerMeal, String subscriptionType,
                                                                   String weeklyDeliveryDay, String weeklyDeliveryTime,
                                                                   String username) {

        SubscriptionHistory subscriptionHistory = new SubscriptionHistory(subscriptionPlan, numberOfWeeklyMeals, servingsPerMeal,
                subscriptionType, weeklyDeliveryDay,
                weeklyDeliveryTime, false, new Date());
        Optional<User> user = userRepository.getUserByUsername(username);

        subscriptionHistory.setUser(user.get());

        return subscriptionHistoryRepository.save(subscriptionHistory);
    }
}
