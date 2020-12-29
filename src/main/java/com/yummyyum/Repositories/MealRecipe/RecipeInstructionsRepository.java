package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.RecipeInstructions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecipeInstructionsRepository extends JpaRepository<RecipeInstructions, Long> {
    @Query(value = "SELECT * FROM recipe_instructions as ri " +
            "JOIN meal m ON m.id = ri.recipe_instructions_id " +
            "WHERE m.meal_name=:mealName",
            nativeQuery = true)
    Optional<RecipeInstructions> findRecipeInstructionsByMealName(String mealName);
}