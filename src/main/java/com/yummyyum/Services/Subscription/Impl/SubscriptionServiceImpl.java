package com.yummyyum.Services.Subscription.Impl;

import com.yummyyum.Model.DTO.SubscriptionDTO;
import com.yummyyum.Model.Subscription;
import com.yummyyum.Model.SubscriptionPlan;
import com.yummyyum.Repositories.SubscriptionPlanRepository;
import com.yummyyum.Repositories.SubscriptionRepository;
import com.yummyyum.Services.Subscription.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   SubscriptionPlanRepository subscriptionPlanRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public SubscriptionDTO getSubscriptionBySubscriptionPlanName(String subscriptionPlanName) {
        Optional<Subscription> subscription =
                subscriptionRepository.getSubscriptionBySubscriptionPlanName(subscriptionPlanName);
        Optional<SubscriptionPlan> subscriptionPlan =
                subscriptionPlanRepository.getSubscriptionPlanByName(subscriptionPlanName);

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setName(subscriptionPlan.get().getName());
        subscriptionDTO.setIsActive(subscriptionPlan.get().getIsActive());
        subscriptionDTO.setNumberOfWeeklyMeals(subscription.get().getNumberOfWeeklyMeals());
        subscriptionDTO.setServingsPerMeal(subscription.get().getServingsPerMeal());
        subscriptionDTO.setSubscriptionType(subscription.get().getSubscriptionType());
        subscriptionDTO.setWeeklyDeliveryDay(subscription.get().getWeeklyDeliveryDay());
        subscriptionDTO.setWeeklyDeliveryTime(subscription.get().getWeeklyDeliveryTime());
        subscriptionDTO.setActivationDate(subscription.get().getActivationDate());
        subscriptionDTO.setCanceledDate(subscription.get().getCanceledDate());

        return subscriptionDTO;
    }

    @Override
    public Long getSubscriptionIdBySubscriptionPlanName(String subscriptionPlanName) {
        return subscriptionRepository.getSubscriptionIdBySubscriptionPlanName(subscriptionPlanName);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByIsCanceled(Boolean isCanceled) {
        return subscriptionRepository.getAllSubscriptionsByIsCanceled(isCanceled);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByActivationDate(LocalDate activationDate) {
        return subscriptionRepository.getAllSubscriptionsByActivationDate(activationDate);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCanceledDate(LocalDate canceledDate) {
        return subscriptionRepository.getAllSubscriptionsByCanceledDate(canceledDate);
    }

    @Override
    public Subscription createNewSubscription(int numberOfWeeklyMeals, int servingsPerMeal, String subscriptionType,
                                              String weeklyDeliveryDay, String weeklyDeliveryTime, Boolean isCanceled,
                                              LocalDate activationDate, LocalDate canceledDate, String subscriptionPlanName) {

        Subscription subscription = new Subscription(
                numberOfWeeklyMeals, servingsPerMeal, subscriptionType, weeklyDeliveryDay,
                weeklyDeliveryTime, isCanceled, activationDate, canceledDate);
        Optional<SubscriptionPlan> subscriptionPlan =
                subscriptionPlanRepository.getSubscriptionPlanByName(subscriptionPlanName);
        subscription.setSubscriptionPlan(subscriptionPlan.get());

        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(int numberOfWeeklyMeals, int servingsPerMeal, String subscriptionType,
                                           String weeklyDeliveryDay, String weeklyDeliveryTime, Boolean isCanceled,
                                           LocalDate activationDate, LocalDate canceledDate, String subscriptionPlanName) {

        Optional<Subscription> subscriptionObj =
                subscriptionRepository.getSubscriptionBySubscriptionPlanName(subscriptionPlanName);

        Subscription subscription = new Subscription();

        if (subscriptionObj.isPresent()) {
            SubscriptionObject(numberOfWeeklyMeals, servingsPerMeal, subscriptionType,
                    weeklyDeliveryDay, weeklyDeliveryTime, isCanceled,
                    activationDate, canceledDate, subscription);
            Long id = subscriptionRepository.getSubscriptionIdBySubscriptionPlanName(subscriptionPlanName);
            subscription.setId(id);
        } else {
            SubscriptionObject(numberOfWeeklyMeals, servingsPerMeal, subscriptionType,
                    weeklyDeliveryDay, weeklyDeliveryTime, isCanceled,
                    activationDate, canceledDate, subscription);
        }

        Optional<SubscriptionPlan> subscriptionPlan =
                subscriptionPlanRepository.getSubscriptionPlanByName(subscriptionPlanName);
        subscription.setSubscriptionPlan(subscriptionPlan.get());

        return subscriptionRepository.saveAndFlush(subscription);
    }

    private void SubscriptionObject(int numberOfWeeklyMeals, int servingsPerMeal,
                                    String subscriptionType, String weeklyDeliveryDay,
                                    String weeklyDeliveryTime, Boolean isCanceled, LocalDate activationDate,
                                    LocalDate canceledDate, Subscription subscription) {
        subscription.setNumberOfWeeklyMeals(numberOfWeeklyMeals);
        subscription.setServingsPerMeal(servingsPerMeal);
        subscription.setSubscriptionType(subscriptionType);
        subscription.setWeeklyDeliveryDay(weeklyDeliveryDay);
        subscription.setWeeklyDeliveryTime(weeklyDeliveryTime);
        subscription.setIsCanceled(isCanceled);
        subscription.setActivationDate(activationDate);
        subscription.setCanceledDate(canceledDate);
    }

}
