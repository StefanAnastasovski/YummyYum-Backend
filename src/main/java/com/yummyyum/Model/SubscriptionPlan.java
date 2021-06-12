package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "subscription_plan")
@Getter
@Setter
@AllArgsConstructor
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(name = "number_of_weekly_meals_limit")
    private int numberOfWeeklyMealsLimit;

    @Column(name = "servings_per_meal_limit")
    private int servingsPerMealLimit;

    @Column(name = "weekly_delivery_day")
    private int weeklyDeliveryDayLimit;

    @Column(name = "is_active")
    private Boolean isActive;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "subscription_plan_id")
    private List<Subscription> subscriptions;

    public SubscriptionPlan() {
    }

    public SubscriptionPlan(String name, int numberOfWeeklyMealsLimit,
                            int servingsPerMealLimit, int weeklyDeliveryDayLimit, Boolean isActive) {
        this.name = name;
        this.numberOfWeeklyMealsLimit = numberOfWeeklyMealsLimit;
        this.servingsPerMealLimit = servingsPerMealLimit;
        this.weeklyDeliveryDayLimit = weeklyDeliveryDayLimit;
        this.isActive = isActive;
    }

}
