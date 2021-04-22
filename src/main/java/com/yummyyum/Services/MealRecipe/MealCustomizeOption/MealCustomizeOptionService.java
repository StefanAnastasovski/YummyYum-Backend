package com.yummyyum.Services.MealRecipe.MealCustomizeOption;

import com.yummyyum.Model.DTO.RecipeComponents.CustomizeOptionsDTO;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealCustomizeOption;

import java.util.List;

public interface MealCustomizeOptionService {

    List<MealCustomizeOption> getAllMealCustomizeOptionsByMeal(String mealName);

    List<MealCustomizeOption> createNewMealCustomizeOption(List<MealCustomizeOption> mealCustomizeOptions, String mealName);

}
