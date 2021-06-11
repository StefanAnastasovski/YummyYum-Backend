package com.yummyyum.Services.SubscriptionPlan.Impl;

import com.yummyyum.Model.SubscriptionPlan;
import com.yummyyum.Repositories.SubscriptionPlanRepository;
import com.yummyyum.Services.SubscriptionPlan.SubscriptionPlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    private final SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlanServiceImpl(SubscriptionPlanRepository subscriptionPlanRepository) {
        this.subscriptionPlanRepository = subscriptionPlanRepository;
    }

    @Override
    public List<SubscriptionPlan> getAllSubscriptionPlans() {
        return subscriptionPlanRepository.findAll();
    }

    @Override
    public Optional<SubscriptionPlan> getSubscriptionPlanByName(String name) {
        return subscriptionPlanRepository.getSubscriptionPlanByName(name);
    }

    @Override
    public List<SubscriptionPlan> getAllSubscriptionPlansByIsActive(Boolean isActive) {
        return subscriptionPlanRepository.getAllSubscriptionPlansByIsActive(isActive);
    }

    @Override
    public SubscriptionPlan createNewSubscriptionPlan(String name, Boolean isActive) {

        SubscriptionPlan subscriptionPlan = new SubscriptionPlan(name, isActive);

        return subscriptionPlanRepository.save(subscriptionPlan);

    }

    @Override
    public SubscriptionPlan updateSubscriptionPlan(String newName, Boolean isActive, String oldName) {
        Optional<SubscriptionPlan> subscriptionPlan = subscriptionPlanRepository.getSubscriptionPlanByName(oldName);
        SubscriptionPlan newSubscriptionPlan = new SubscriptionPlan();
        if (subscriptionPlan.isPresent()) {
            newSubscriptionPlan.setName(newName);
            newSubscriptionPlan.setIsActive(isActive);
            newSubscriptionPlan.setId(subscriptionPlan.get().getId());
        } else {
            newSubscriptionPlan.setName(newName);
            newSubscriptionPlan.setIsActive(isActive);
        }


        return subscriptionPlanRepository.saveAndFlush(newSubscriptionPlan);
    }
}
