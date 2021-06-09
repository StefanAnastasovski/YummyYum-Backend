package com.yummyyum.Model.History;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yummyyum.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "shipping_address_history")
@Getter
@Setter
@AllArgsConstructor
public class ShippingAddressHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String address;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="inactive_date")
    private Date inactiveDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ShippingAddressHistory() {
    }

    public ShippingAddressHistory(String address, String zipCode, Date inactiveDate) {
        this.address = address;
        this.zipCode = zipCode;
        this.inactiveDate = inactiveDate;
    }
}
