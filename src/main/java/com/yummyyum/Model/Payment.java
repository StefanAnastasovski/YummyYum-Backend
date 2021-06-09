package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "payment")
@Getter
@Setter
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "payment_number_id")
    private String paymentNumberID;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "total_amount")
    private Float totalAmount;

    @JsonIgnore
    @OneToOne(mappedBy = "payment")
    private DeliveryAddress deliveryAddress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    public Payment() {
    }

    public Payment(String paymentNumberID, String cardNumber, Date paymentDate, Float totalAmount) {
        this.paymentNumberID = paymentNumberID;
        this.cardNumber = cardNumber;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
    }
}
