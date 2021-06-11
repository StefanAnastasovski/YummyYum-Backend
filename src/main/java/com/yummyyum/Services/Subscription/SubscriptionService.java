package com.yummyyum.Services.Subscription;

import com.yummyyum.Model.DTO.SubscriptionDTO;
import com.yummyyum.Model.Subscription;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAllSubscriptions();

    SubscriptionDTO getSubscriptionBySubscriptionPlanName(String subscriptionPlanName);

    Long getSubscriptionIdBySubscriptionPlanName(String subscriptionPlanName);

    List<Subscription> getAllSubscriptionsByIsCanceled(Boolean isCanceled);

    List<Subscription> getAllSubscriptionsByActivationDate(LocalDate activationDate);

    List<Subscription> getAllSubscriptionsByCanceledDate(LocalDate canceledDate);

    Subscription createNewSubscription(int numberOfWeeklyMeals, int servingsPerMeal,
                                       String subscriptionType, String weeklyDeliveryDay,
                                       String weeklyDeliveryTime, Boolean isCanceled, LocalDate activationDate,
                                       LocalDate canceledDate, String subscriptionPlanName);

    Subscription updateSubscription(int numberOfWeeklyMeals, int servingsPerMeal,
                                    String subscriptionType, String weeklyDeliveryDay,
                                    String weeklyDeliveryTime, Boolean isCanceled,
                                    LocalDate activationDate, LocalDate canceledDate, String subscriptionPlanName);

}
