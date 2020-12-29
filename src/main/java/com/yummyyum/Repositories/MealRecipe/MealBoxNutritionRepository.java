package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealBoxNutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MealBoxNutritionRepository extends JpaRepository<MealBoxNutrition, Long> {
    @Query(value = "SELECT * FROM meal_nutrition as mbn " +
            "JOIN meal m ON m.id = mbn.meal_box_nutrition_id " +
            "WHERE m.meal_name=:mealName",
            nativeQuery = true)
    Optional<MealBoxNutrition> findMealBoxNutritionByMealName(String mealName);
}
