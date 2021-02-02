package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealBoxNutritionDTO {

    @NotNull
    private Integer calories;

    @NotNull
    private Integer protein;

    @NotNull
    private Integer carbohydrates;

    @NotNull
    private Integer fat;

    public MealBoxNutritionDTO() {
    }

    public MealBoxNutritionDTO(Integer calories, Integer protein, Integer carbohydrates, Integer fat) {
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

}
