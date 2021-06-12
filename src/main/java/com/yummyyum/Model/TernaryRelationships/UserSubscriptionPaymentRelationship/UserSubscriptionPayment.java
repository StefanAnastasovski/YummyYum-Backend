package com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship;

import com.yummyyum.Model.EmbeddedIDs.UserSubscriptionPaymentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "user_subscription_payment")
@Getter
@Setter
@AllArgsConstructor
public class UserSubscriptionPayment {

    @EmbeddedId
    private UserSubscriptionPaymentId id;

    public UserSubscriptionPayment() {
    }

}
