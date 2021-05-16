package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.OrderMeals;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderInfoMeals {

    @NotNull
    private String orderId;

    @NotNull
    private int mealNumber;

    @NotNull
    private int servingNumber;

    @NotNull
    private float subtotal;

    @NotNull
    private float shippingCost;

    @NotNull
    private float total;

    @NotNull
    private Date orderDate;

    @NotNull
    private List<OrderMeals> orderMeals;


    public OrderInfoMeals() {
    }

    public OrderInfoMeals(String orderId, int mealNumber, int servingNumber,
                          float subtotal, float shippingCost, float total,
                          Date orderDate, List<OrderMeals> orderMeals) {
        this.orderId = orderId;
        this.mealNumber = mealNumber;
        this.servingNumber = servingNumber;
        this.subtotal = subtotal;
        this.shippingCost = shippingCost;
        this.total = total;
        this.orderDate = orderDate;
        this.orderMeals = orderMeals;
    }

}
