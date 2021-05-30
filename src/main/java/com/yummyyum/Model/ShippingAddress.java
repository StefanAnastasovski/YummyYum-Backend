package com.yummyyum.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "shipping_address")
@Getter
@Setter
@AllArgsConstructor
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String address;

    @Column
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public ShippingAddress() {
    }

    public ShippingAddress(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }

}
