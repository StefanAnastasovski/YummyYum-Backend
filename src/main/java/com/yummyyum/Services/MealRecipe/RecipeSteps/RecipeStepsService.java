package com.yummyyum.Services.MealRecipe.RecipeSteps;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.RecipeSteps;

import java.util.List;
import java.util.Optional;

public interface RecipeStepsService {

    List<RecipeSteps> getAllRecipeSteps();

    Optional<RecipeSteps> findRecipeStepsByMealName(String mealName);

    RecipeSteps createNewRecipeSteps(String mealUtensilsRow1, String mealUtensilsRow2, Meal meal);

}
