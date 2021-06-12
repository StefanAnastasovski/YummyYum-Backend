package com.yummyyum.Model.DTO;


import com.sun.istack.NotNull;
import com.yummyyum.Model.Subscription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSubscriptionPaymentDTO {

    //user
    @NotNull
    private String username;

    //payment
    @NotNull
    private String cardNumber;

    @NotNull
    private Float totalAmount;

    //delivery address
    @NotNull
    private String address;

    @NotNull
    private String zipCode;

    //subscription
    @NotNull
    private SubscriptionDTO subscription;

    //subscription plan
    @NotNull
    private String subscriptionPlan;

}
