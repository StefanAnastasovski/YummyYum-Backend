package com.yummyyum.Services.History.SubscriptionHistory;

import com.yummyyum.Model.History.SubscriptionHistory;

import java.util.List;

public interface SubscriptionHistoryService {

    List<SubscriptionHistory> getAllSubscriptionHistoryHistoriesByUsername(String username);

    SubscriptionHistory createNewSubscriptionHistoryHistory(String subscriptionPlan, int numberOfWeeklyMeals,
                                                            int servingsPerMeal, String subscriptionType,
                                                            String weeklyDeliveryDay, String weeklyDeliveryTime,
                                                            String username);

}
