package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.DTO.RecipeComponents.MealBoxNutritionDTO;
import com.yummyyum.Model.DTO.RecipeComponents.MealCustomizeOptionDTO;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.MealRecipe.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealExampleDTO {


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
    private MealOverview mealOverview;

    @NotNull
    private MealChef mealChef;

    @NotNull
    private MealBox mealBox;

    @NotNull
    private MealBoxNutritionDTO mealBoxNutrition;


    @NotNull
    private RecipeSteps recipeSteps;

    @NotNull
    private RecipeInstructions recipeInstructions;

    @NotNull
    private CookingSteps cookingSteps;

    @NotNull
    private List<MealCustomizeOptionDTO> mealCustomizeOptions;

    public MealExampleDTO() {
    }

    public MealExampleDTO(String mealName, String mealDescription, String mealTimeTag,
                          String mealIngredientTag, Double price, MealCategory mealCategory,
                          MealOverview mealOverview, MealChef mealChef, MealBox mealBox,
                          MealBoxNutritionDTO mealBoxNutrition, RecipeSteps recipeSteps,
                          RecipeInstructions recipeInstructions, CookingSteps cookingSteps,
                          List<MealCustomizeOptionDTO> mealCustomizeOptions) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealTimeTag = mealTimeTag;
        this.mealIngredientTag = mealIngredientTag;
        this.price = price;
        this.mealCategory = mealCategory;
        this.mealOverview = mealOverview;
        this.mealChef = mealChef;
        this.mealBox = mealBox;
        this.mealBoxNutrition = mealBoxNutrition;
        this.recipeSteps = recipeSteps;
        this.recipeInstructions = recipeInstructions;
        this.cookingSteps = cookingSteps;
        this.mealCustomizeOptions = mealCustomizeOptions;
    }
}