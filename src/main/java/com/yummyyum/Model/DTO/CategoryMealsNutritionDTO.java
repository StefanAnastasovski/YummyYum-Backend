package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryMealsNutritionDTO {

    @NotNull
    private String category;

    @NotNull
    private List<MealImageCategoryCustomizeOptionNutritionDTO> meals;

    public CategoryMealsNutritionDTO() {
    }

    public CategoryMealsNutritionDTO(String category, List<MealImageCategoryCustomizeOptionNutritionDTO> meals) {
        this.category = category;
        this.meals = meals;
    }

}
