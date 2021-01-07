package com.yummyyum.Repositories;

import com.yummyyum.Model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> getMealByMealName(String mealName);

    @Query(value = "SELECT * from meal as m " +
            "join meal_category mc " +
            "on m.meal_category_id = mc.id " +
            "WHERE mc.category = :category",
            nativeQuery = true)
    List<Meal> getMealsByMealCategory(String category);
}
