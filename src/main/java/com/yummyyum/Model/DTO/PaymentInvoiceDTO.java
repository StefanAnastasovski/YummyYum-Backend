package com.yummyyum.Model.DTO;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PaymentInvoiceDTO {

    @NotNull
    private String paymentNumberID;

    @NotNull
    private String cardNumber;

    @NotNull
    private Date paymentDate;

    @NotNull
    private Float totalAmount;

    public PaymentInvoiceDTO() {
    }

}
