package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.OrderInfo;
import com.yummyyum.Model.OrderMeals;
import com.yummyyum.Model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserOrderInfoPaymentDTO {

    //user
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String address;

    @NotNull
    private String zipCode;

    //payment
    @NotNull
    private Payment payment;

    //order info
    @NotNull
    private OrderInfo orderInfo;

    //order meals
    @NotNull
    private List<OrderMeals> orderMeals;

    public UserOrderInfoPaymentDTO() {
    }


}
