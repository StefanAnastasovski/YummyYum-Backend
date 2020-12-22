package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.RecipeInstructions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeInstructionsRepository extends JpaRepository<RecipeInstructions, Long> {
    Optional<RecipeInstructions> getRecipeInstructionsByMealName(String mealName);
}