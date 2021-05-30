package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "order_info")
@Getter
@Setter
@AllArgsConstructor
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id")
    private String OrderId;

    @Column(name = "meal_number")
    private int mealNumber;

    @Column(name = "serving_number")
    private int servingNumber;

    @Column(name = "subtotal")
    private float subtotal;

    @Column(name = "shipping_cost")
    private float shippingCost;

    @Column(name = "total")
    private float total;

    @Column(name = "order_date")
    private Date orderDate;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "order_info_id")
    private List<OrderMeals> orderMeals;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public OrderInfo() {
    }

    public OrderInfo(String orderId, int mealNumber, int servingNumber, float subtotal,
                     float shippingCost, float total, Date orderDate) {
        OrderId = orderId;
        this.mealNumber = mealNumber;
        this.servingNumber = servingNumber;
        this.subtotal = subtotal;
        this.shippingCost = shippingCost;
        this.total = total;
        this.orderDate = orderDate;
    }
}
