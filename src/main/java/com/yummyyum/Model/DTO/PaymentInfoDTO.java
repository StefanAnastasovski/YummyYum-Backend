package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentInfoDTO {

    @NotNull
    private String cardNumber;

    @NotNull
    private Float totalAmount;

    @NotNull
    private String address;

    @NotNull
    private String zipCode;

    @NotNull
    private String username;

    @NotNull
    private String orderInfoId;

    private String paymentNumberId;

    public PaymentInfoDTO() {
    }

}
