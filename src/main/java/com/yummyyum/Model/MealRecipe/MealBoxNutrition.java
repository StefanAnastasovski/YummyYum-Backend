package com.yummyyum.Model.MealRecipe;

import com.yummyyum.Model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "meal_nutrition")
@Getter
@Setter
@AllArgsConstructor
public class MealBoxNutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer calories;

    @Column
    private Integer protein;

    @Column
    private Integer carbohydrates;

    @Column
    private Integer fat;

    @OneToOne
    @JoinColumn(name = "meal_box_nutrition_id", referencedColumnName = "id")
    private Meal meal;

    public MealBoxNutrition() {

    }

    public MealBoxNutrition(Integer calories, Integer protein,
                            Integer carbohydrates, Integer fat) {
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "MealBoxNutrition{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                ", fat=" + fat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealBoxNutrition mealBoxNutrition = (MealBoxNutrition) o;

        return id != null ? id.equals(mealBoxNutrition.id) : mealBoxNutrition.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

