package com.yummyyum.Repositories;

import com.yummyyum.Model.MealCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealCategoryRepository extends JpaRepository<MealCategory, Long> {
    Optional<MealCategory> findMealCategoryByCategory(String category);
}
