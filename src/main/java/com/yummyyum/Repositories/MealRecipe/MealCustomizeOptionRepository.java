package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealCustomizeOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealCustomizeOptionRepository extends JpaRepository<MealCustomizeOption, Long> {

    @Query(value = "SELECT mco.* FROM meal_customize_option " +
            "AS mco JOIN meal m ON m.id = mco.meal_customize_option_id " +
            "WHERE m.meal_name = :mealName",
            nativeQuery = true)
    List<MealCustomizeOption> getMealCustomizeOptionByMealName(String mealName);

}
