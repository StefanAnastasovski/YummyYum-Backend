package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealOverview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealOverviewRepository extends JpaRepository<MealOverview, Long> {
    Optional<MealOverview> getMealOverviewByMealName(String mealName);
}
