package com.yummyyum.Services.MealCategory;

import com.yummyyum.Model.MealCategory;

import java.util.List;
import java.util.Optional;

public interface MealCategoryService {

    List<MealCategory> getAllMealCategories();

    Optional<MealCategory> findMealCategoryByCategory(String category);

    MealCategory createNewMealCategory(String category);

    String getMealCategoryByMealName(String mealName);

}
