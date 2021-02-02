package com.yummyyum.Repositories;

import com.yummyyum.Model.MealCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MealCategoryRepository extends JpaRepository<MealCategory, Long> {
    Optional<MealCategory> findMealCategoryByCategory(String category);

    @Query(value = "SELECT category FROM meal" +
            " join meal_category mc " +
            "on " +
            "meal.meal_category_id = mc.id " +
            "WHERE meal_name=:mealName",
            nativeQuery = true)
    String getMealCategoryByMealName(String mealName);

}
