package com.yummyyum.Services.MealCategory;

import com.yummyyum.Model.MealCategory;

import java.util.List;
import java.util.Optional;

public interface MealCategoryService {

    List<MealCategory> getAllMealCategories();

    Optional<MealCategory> getMealCategoryByCategory(String category);

    Optional<MealCategory> getMealCategoryByCategoryCode(String categoryCode);

    MealCategory createNewMealCategory(String category, String categoryCode);

}
