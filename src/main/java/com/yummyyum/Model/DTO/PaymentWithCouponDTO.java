package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentWithCouponDTO {

    @NotNull
    private String cardNumber;

    @NotNull
    private Float totalAmount;

    @NotNull
    private String username;

    private String paymentNumberId;

    private String couponName;

    @NotNull
    private String address;

    @NotNull
    private String zipCode;

    public PaymentWithCouponDTO() {
    }

}
