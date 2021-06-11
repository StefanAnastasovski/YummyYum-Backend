package com.yummyyum.Model.History;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yummyyum.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "subscription_history")
@Getter
@Setter
@AllArgsConstructor
public class SubscriptionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subscription_plan")
    private String subscriptionPlan;

    @Column(name = "number_of_weekly_meals")
    private int numberOfWeeklyMeals;

    @Column(name = "servings_per_meal")
    private int servingsPerMeal;

    @Column(name = "subscription_type")
    private String subscriptionType;

    @Column(name = "weekly_delivery_day")
    private String weeklyDeliveryDay;

    @Column(name = "weekly_delivery_time")
    private String weeklyDeliveryTime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "inactive_date")
    private Date inactiveDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SubscriptionHistory() {
    }

    public SubscriptionHistory(String subscriptionPlan, int numberOfWeeklyMeals, int servingsPerMeal,
                               String subscriptionType, String weeklyDeliveryDay,
                               String weeklyDeliveryTime, Boolean isActive, Date inactiveDate) {
        this.subscriptionPlan = subscriptionPlan;
        this.numberOfWeeklyMeals = numberOfWeeklyMeals;
        this.servingsPerMeal = servingsPerMeal;
        this.subscriptionType = subscriptionType;
        this.weeklyDeliveryDay = weeklyDeliveryDay;
        this.weeklyDeliveryTime = weeklyDeliveryTime;
        this.isActive = isActive;
        this.inactiveDate = inactiveDate;
    }
}
