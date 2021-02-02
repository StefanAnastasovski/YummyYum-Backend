package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealBoxDTO {

    @NotNull
    private Integer serveQuantity;

    @NotNull
    private String mealIngredients;

    public MealBoxDTO() {
    }

    public MealBoxDTO(Integer serveQuantity, String mealIngredients) {
        this.serveQuantity = serveQuantity;
        this.mealIngredients = mealIngredients;
    }
}
