package com.yummyyum.Model.EmbeddedIDs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
public class UserOrderInfoPaymentId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_info_id")
    private Long orderInfoId;

    @Column(name = "payment_id")
    private Long paymentId;

    public UserOrderInfoPaymentId() {
    }

}

