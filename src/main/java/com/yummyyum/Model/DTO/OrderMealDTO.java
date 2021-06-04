package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderMealDTO {

    @NotNull
    private String mealName;

    @NotNull
    private String menuName;

    @NotNull
    private int servings;

    @NotNull
    private String customizeIt;

    @NotNull
    private float price;

    @NotNull
    private String deliveryDate;

    @NotNull
    private String deliveryTime;

    public OrderMealDTO() {
    }

}
