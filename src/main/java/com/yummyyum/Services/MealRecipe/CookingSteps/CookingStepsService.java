package com.yummyyum.Services.MealRecipe.CookingSteps;

import com.yummyyum.Model.MealRecipe.CookingSteps;

import java.util.List;
import java.util.Optional;

public interface CookingStepsService {

    List<CookingSteps> getAllCookingSteps();

    List<CookingSteps> getCookingStepsByMealName(String mealName);

    CookingSteps createNewCookingSteps(Integer stepNumber, String stepTitle,
                        String stepDescription, String mealName);

}
