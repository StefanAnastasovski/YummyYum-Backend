package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealBoxNutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealBoxNutritionRepository extends JpaRepository<MealBoxNutrition, Long> {
    Optional<MealBoxNutrition> getMealBoxNutritionByMealName(String mealName);
}
