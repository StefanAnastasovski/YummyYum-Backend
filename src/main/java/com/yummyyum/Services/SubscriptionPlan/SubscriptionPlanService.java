package com.yummyyum.Services.SubscriptionPlan;

import com.yummyyum.Model.SubscriptionPlan;

import java.util.List;
import java.util.Optional;

public interface SubscriptionPlanService {

    List<SubscriptionPlan> getAllSubscriptionPlans();

    Optional<SubscriptionPlan> getSubscriptionPlanByName(String name);

    List<SubscriptionPlan> getAllSubscriptionPlansByIsActive(Boolean isActive);

    SubscriptionPlan createNewSubscriptionPlan(String name, int numberOfWeeklyMealsLimit,
                            int servingsPerMealLimit, int weeklyDeliveryDayLimit, Boolean isActive);

    SubscriptionPlan updateSubscriptionPlan(String name, int numberOfWeeklyMealsLimit,
                            int servingsPerMealLimit, int weeklyDeliveryDayLimit, Boolean isActive, String oldName);

}
