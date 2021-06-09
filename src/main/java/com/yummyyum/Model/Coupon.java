package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "coupon")
@Getter
@Setter
@AllArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "coupon_name", unique = true)
    private String couponName;

    @Column(name = "percentage_discount")
    private Float percentageDiscount;

    @Column(name = "fixed_amount_discount")
    private Float fixedAmountDiscount;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "activation_date")
    private Date activationDate;

    @Column(name = "decativation_date")
    private Date deactivationDate;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "coupon_id")
    private List<Payment> payments;

    public Coupon() {
    }

    public Coupon(String couponName, Float percentageDiscount, Float fixedAmountDiscount,
                  Boolean isActive, Date activationDate, Date deactivationDate) {
        this.couponName = couponName;
        this.percentageDiscount = percentageDiscount;
        this.fixedAmountDiscount = fixedAmountDiscount;
        this.isActive = isActive;
        this.activationDate = activationDate;
        this.deactivationDate = deactivationDate;
    }

}
