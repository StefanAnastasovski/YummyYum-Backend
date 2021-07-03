package com.yummyyum.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "order_meals")
@Getter
@Setter
@AllArgsConstructor
public class OrderMeals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "meal_name")
    private String mealName;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "servings")
    private int servings;

    @Column(name = "customize_it")
    private String customizeIt;

    @Column(name = "price")
    private float price;

    @Column(name = "delivery_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Column(name = "is_subscription")
    private Boolean isSubscription;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_info_id")
    private OrderInfo orderInfo;


    public OrderMeals() {
    }

    public OrderMeals(String mealName, String menuName, int servings,
                      String customizeIt, float price, LocalDate deliveryDate, String deliveryTime, Boolean isSubscription) {
        this.mealName = mealName;
        this.menuName = menuName;
        this.servings = servings;
        this.customizeIt = customizeIt;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.isSubscription = isSubscription;
    }

}
