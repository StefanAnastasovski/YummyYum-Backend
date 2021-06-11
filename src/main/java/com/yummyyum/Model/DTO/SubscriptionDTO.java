package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDTO {

    @NotNull
    private String name;

    @NotNull
    private Boolean isActive;

    @NotNull
    private int numberOfWeeklyMeals;

    @NotNull
    private int servingsPerMeal;

    @NotNull
    private String subscriptionType;

    @NotNull
    private String weeklyDeliveryDay;

    @NotNull
    private String weeklyDeliveryTime;

    @NotNull
    private Boolean isCanceled;

    @NotNull
    private LocalDate activationDate;

    private LocalDate canceledDate;

    public SubscriptionDTO() {
    }

}
