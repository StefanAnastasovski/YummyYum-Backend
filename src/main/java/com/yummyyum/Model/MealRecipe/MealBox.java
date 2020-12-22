package com.yummyyum.Model.MealRecipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="meal_box")
@Getter
@Setter
@AllArgsConstructor
public class MealBox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="serve_quantity")
    private Integer serveQuantity;

    @Column(name="meal_ingredients")
    @Lob
    private String mealIngredients;

    @Column(name="meal_name_fk")
    private String mealName;

    public MealBox() {

    }

    public MealBox(Integer serveQuantity, String mealIngredients, String mealName) {
        this.serveQuantity = serveQuantity;
        this.mealIngredients = mealIngredients;
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "MealBox{" +
                "serveQuantity=" + serveQuantity +
                ", mealIngredients='" + mealIngredients + '\'' +
                ", mealName='" + mealName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealBox mealBox = (MealBox) o;

        return id != null ? id.equals(mealBox.id) : mealBox.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

