package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealBoxRepository extends JpaRepository<MealBox, Long> {
    Optional<MealBox> getMealBoxByMealName(String mealName);
}
