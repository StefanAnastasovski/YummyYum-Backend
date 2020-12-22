package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.CookingSteps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CookingStepsRepository extends JpaRepository<CookingSteps, Long> {
    Optional<CookingSteps> getCookingStepsByMealName(String mealName);
}
