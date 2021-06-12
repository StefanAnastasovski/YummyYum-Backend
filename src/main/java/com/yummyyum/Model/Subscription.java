package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "subscription")
@Getter
@Setter
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Column(name = "is_canceled")
    private Boolean isCanceled;

    @Column(name = "activation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate activationDate;

    @Column(name = "canceled_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate canceledDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subscription_plan_id")
    private SubscriptionPlan subscriptionPlan;

    public Subscription() {
    }

    public Subscription(int numberOfWeeklyMeals, int servingsPerMeal,
                        String subscriptionType, String weeklyDeliveryDay,
                        String weeklyDeliveryTime, Boolean isCanceled,
                        LocalDate activationDate, LocalDate canceledDate) {
        this.numberOfWeeklyMeals = numberOfWeeklyMeals;
        this.servingsPerMeal = servingsPerMeal;
        this.subscriptionType = subscriptionType;
        this.weeklyDeliveryDay = weeklyDeliveryDay;
        this.weeklyDeliveryTime = weeklyDeliveryTime;
        this.isCanceled = isCanceled;
        this.activationDate = activationDate;
        this.canceledDate = canceledDate;
    }

}
