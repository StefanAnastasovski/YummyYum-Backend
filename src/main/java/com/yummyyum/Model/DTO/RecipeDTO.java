package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.DTO.RecipeComponents.*;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.MealRecipe.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RecipeDTO {

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
    private String mealCategory;

    @NotNull
    private MealOverviewDTO mealOverview;

    @NotNull
    private MealChefDTO mealChef;

    @NotNull
    private MealBoxDTO mealBox;

    @NotNull
    private MealBoxNutritionDTO mealBoxNutrition;

    @NotNull
    private CookingStepsDTO cookingSteps;

    @NotNull
    private RecipeStepsDTO recipeSteps;

    @NotNull
    private RecipeInstructionsDTO recipeInstructions;

    public RecipeDTO() {
    }

    public RecipeDTO(String mealName, String mealDescription,
                     String mealTimeTag, String mealIngredientTag,
                     Double price, String mealCategory,
                     MealOverviewDTO mealOverview, MealChefDTO mealChef,
                     MealBoxDTO mealBox, MealBoxNutritionDTO mealBoxNutrition,
                     CookingStepsDTO cookingSteps, RecipeStepsDTO recipeSteps,
                     RecipeInstructionsDTO recipeInstructions) {
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
        this.cookingSteps = cookingSteps;
        this.recipeSteps = recipeSteps;
        this.recipeInstructions = recipeInstructions;
    }
}
