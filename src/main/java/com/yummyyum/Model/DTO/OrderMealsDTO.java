package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.OrderMeals;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderMealsDTO {

    @NotNull
    List<OrderMeals> orderMeals;

    public OrderMealsDTO() {
    }

    public OrderMealsDTO(List<OrderMeals> orderMeals) {
        this.orderMeals = orderMeals;
    }

}
