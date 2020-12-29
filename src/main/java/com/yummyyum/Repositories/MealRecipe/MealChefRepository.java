package com.yummyyum.Repositories.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealChef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MealChefRepository extends JpaRepository<MealChef, Long> {

    @Query(value = "SELECT * FROM meal_chef as mc " +
            "JOIN meal m ON m.id = mc.meal_chef_id " +
            "WHERE m.meal_name=:mealName",
            nativeQuery = true)
    Optional<MealChef> findMealChefByMealName(String mealName);

}
