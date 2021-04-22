package com.yummyyum.Services.Meal;

import com.yummyyum.Model.DTO.MealExampleDTO;
import com.yummyyum.Model.DTO.RecipeComponents.MealCustomizeOptionDTO;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.MealRecipe.*;

import java.util.List;
import java.util.Optional;

public interface MealService {

    List<Meal> getAllMeals();

    Optional<Meal> getMealByMealName(String mealName);

    List<Meal> getMealsByMealCategory(String category);

    Meal createNewMeal(String mealName, String mealDescription,
                       String mealTimeTag, String mealIngredientTag,
                       Double price, MealCategory mealCategory);

    MealExampleDTO createMeal(String mealName, String mealDescription, String mealTimeTag,
                              String mealIngredientTag, Double price,
                              MealCategory mealCategory, MealOverview mealOverview,
                              MealChef mealChef, MealBox mealBox, MealBoxNutrition mealBoxNutrition,
                              RecipeSteps recipeSteps, RecipeInstructions recipeInstructions,
                              CookingSteps cookingSteps, List<MealCustomizeOptionDTO> mealCustomizeOptions);
}
