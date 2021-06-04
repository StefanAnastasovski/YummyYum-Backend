package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class OrderInfoDTO {

    @NotNull
    private String OrderId;

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

    public OrderInfoDTO() {
    }

}
