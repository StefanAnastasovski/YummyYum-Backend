package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MealOverviewRepository extends JpaRepository<MealOverview, Long> {

    @Query(value="SELECT * FROM meal_overview as mo " +
            "JOIN meal m ON m.id = mo.meal_overview_id " +
            "WHERE m.meal_name=:mealName",
    nativeQuery = true)
    Optional<MealOverview> findMealOverviewByMealName(String mealName);

}
