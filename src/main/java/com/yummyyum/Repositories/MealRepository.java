package com.yummyyum.Repositories;

import com.yummyyum.Model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> getMealByMealName(String mealName);
}
