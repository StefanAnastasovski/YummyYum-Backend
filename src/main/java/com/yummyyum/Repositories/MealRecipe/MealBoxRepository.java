package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MealBoxRepository extends JpaRepository<MealBox, Long> {
    @Query(value = "SELECT * FROM meal_box as mb " +
            "JOIN meal m ON m.id = mb.meal_box_id " +
            "WHERE m.meal_name=:mealName",
            nativeQuery = true)
    Optional<MealBox> findMealBoxByMealName(String mealName);
}
