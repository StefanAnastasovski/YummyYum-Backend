package com.yummyyum.Repositories;

import com.yummyyum.Model.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {

    Optional<SubscriptionPlan> getSubscriptionPlanByName(String name);

    List<SubscriptionPlan> getAllSubscriptionPlansByIsActive(Boolean isActive);

}
