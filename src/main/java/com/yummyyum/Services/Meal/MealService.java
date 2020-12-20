package com.yummyyum.Services.Meal;

import com.yummyyum.Model.Meal;

import java.util.List;
import java.util.Optional;

public interface MealService {

    List<Meal> getAllMeals();

    Optional<Meal> getMealByMealName(String mealName);

    Meal createNewMeal(String mealName, String mealDescription,
                       String mealTimeTag, String mealIngredientTag,
                       Double price);
}
