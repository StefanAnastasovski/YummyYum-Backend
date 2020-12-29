package com.yummyyum.Services.MealRecipe.MealBoxNutrition;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealBoxNutrition;

import java.util.List;
import java.util.Optional;

public interface MealBoxNutritionService {

    List<MealBoxNutrition> getAllMealBoxNutritions();

    Optional<MealBoxNutrition> findMealBoxNutritionByMealName(String mealName);

    MealBoxNutrition createNewMealBoxNutrition(Integer calories, Integer protein,
                            Integer carbohydrates, Integer fat, Meal meal);

}
