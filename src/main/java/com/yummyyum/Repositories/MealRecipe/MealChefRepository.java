package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealChef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealChefRepository extends JpaRepository<MealChef, Long> {
     Optional<MealChef> getMealChefByMealName(String mealName);
}
