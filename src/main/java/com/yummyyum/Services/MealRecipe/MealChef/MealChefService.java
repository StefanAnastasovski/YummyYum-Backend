package com.yummyyum.Services.MealRecipe.MealChef;

import com.yummyyum.Model.MealRecipe.MealChef;

import java.util.List;
import java.util.Optional;

public interface MealChefService {

    List<MealChef> getAllMealChefs();

    Optional<MealChef> getMealChefByMealName(String mealName);

    MealChef createNewMealChef(String fullName, String chefMealDescription, String mealName);
}
