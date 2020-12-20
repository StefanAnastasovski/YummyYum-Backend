package com.yummyyum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "meal")
@Getter
@Setter
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "meal_name")
    private String mealName;

    @Column(name = "meal_description")
    private String mealDescription;

    @Column(name = "meal_time_tag")
    private String mealTimeTag;

    @Column(name = "meal_ingredient_tag")
    private String mealIngredientTag;

    @Column
    private Double price;

    public Meal() {

    }

    public Meal(String mealName, String mealDescription, String mealTimeTag, String mealIngredientTag, Double price) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealTimeTag = mealTimeTag;
        this.mealIngredientTag = mealIngredientTag;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealDescription='" + mealDescription + '\'' +
                ", mealTimeTag='" + mealTimeTag + '\'' +
                ", mealIngredientTag='" + mealIngredientTag + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return id != null ? id.equals(meal.id) : meal.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
