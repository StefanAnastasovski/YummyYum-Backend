package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.CookingSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CookingStepsRepository extends JpaRepository<CookingSteps, Long> {
    @Query(value = "SELECT cs.* FROM cooking_steps as cs " +
            "JOIN meal m ON m.id = cs.cooking_steps_id " +
            "WHERE m.meal_name=:mealName",
            nativeQuery = true)
    List<CookingSteps> findCookingStepsByMealName(String mealName);
}
