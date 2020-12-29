package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.RecipeSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecipeStepsRepository extends JpaRepository<RecipeSteps, Long> {
    @Query(value = "SELECT * FROM recipe_steps as rs " +
            "JOIN meal m ON m.id = rs.recipe_steps_id " +
            "WHERE m.meal_name=:mealName",
            nativeQuery = true)
    Optional<RecipeSteps> findRecipeStepsByMealName(String mealName);
}
