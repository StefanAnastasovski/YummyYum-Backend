package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.RecipeSteps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeStepsRepository extends JpaRepository<RecipeSteps, Long> {
    Optional<RecipeSteps> getRecipeStepsByMealName(String mealName);
}
