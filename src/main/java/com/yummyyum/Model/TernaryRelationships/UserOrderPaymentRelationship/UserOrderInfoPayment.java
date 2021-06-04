package com.yummyyum.Model.TernaryRelationships.UserOrderPaymentRelationship;

import com.yummyyum.Model.EmbeddedIDs.UserOrderInfoPaymentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "user_order_payment")
@Getter
@Setter
@AllArgsConstructor
public class UserOrderInfoPayment {

    @EmbeddedId
    private UserOrderInfoPaymentId id;

    public UserOrderInfoPayment() {
    }

}
