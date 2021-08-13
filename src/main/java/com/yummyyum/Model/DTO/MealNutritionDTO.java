package com.yummyyum.Model.DTO;


import com.sun.istack.NotNull;
import com.yummyyum.Model.DTO.RecipeComponents.MealCustomizeOptionDTO;
import com.yummyyum.Model.Image;
import com.yummyyum.Model.MealCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealNutritionDTO {

    @NotNull
    private String mealName;

    @NotNull
    private String mealDescription;

    @NotNull
    private String mealTimeTag;

    @NotNull
    private String mealIngredientTag;

    @NotNull
    private Double price;

    @NotNull
    private MealCategory mealCategory;

    @NotNull
    private Image image;

    @NotNull
    private List<MealCustomizeOptionDTO> mealCustomizeOptions;

    @NotNull
    private Integer calories;

    @NotNull
    private Integer protein;

    @NotNull
    private Integer carbohydrates;

    @NotNull
    private Integer fat;


    public MealNutritionDTO() {
    }

    public MealNutritionDTO(String mealName, String mealDescription,
                            String mealTimeTag, String mealIngredientTag,
                            Double price, MealCategory mealCategory,
                            List<MealCustomizeOptionDTO> mealCustomizeOptions) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealTimeTag = mealTimeTag;
        this.mealIngredientTag = mealIngredientTag;
        this.price = price;
        this.mealCategory = mealCategory;
        this.mealCustomizeOptions = mealCustomizeOptions;
    }

}
