package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.CookingSteps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CookingStepsRepository extends JpaRepository<CookingSteps, Long> {
    List<CookingSteps> getCookingStepsByMealName(String mealName);
}
