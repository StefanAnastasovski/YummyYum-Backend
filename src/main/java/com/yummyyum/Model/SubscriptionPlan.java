package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "subscription_plan")
@Getter
@Setter
@AllArgsConstructor
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "subscription_plan_id")
    private List<Subscription> subscriptions;

    public SubscriptionPlan() {
    }

    public SubscriptionPlan(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

}
