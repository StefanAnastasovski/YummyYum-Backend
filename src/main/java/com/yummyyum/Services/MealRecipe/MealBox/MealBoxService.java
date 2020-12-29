package com.yummyyum.Services.MealRecipe.MealBox;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealBox;

import java.util.List;
import java.util.Optional;

public interface MealBoxService {

    List<MealBox> getAllMealBoxes();

    Optional<MealBox> findMealBoxByMealName(String mealName);

    MealBox createNewMealBox(Integer serveQuantity, String mealIngredients, Meal meal);

}
