package com.yummyyum.Services.MealCategory.Impl;

import com.yummyyum.Model.MealCategory;
import com.yummyyum.Repositories.MealCategoryRepository;
import com.yummyyum.Services.MealCategory.MealCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealCategoryServiceImpl implements MealCategoryService {

    private final MealCategoryRepository mealCategoryRepository;

    public MealCategoryServiceImpl(MealCategoryRepository mealCategoryRepository) {
        this.mealCategoryRepository = mealCategoryRepository;
    }

    @Override
    public List<MealCategory> getAllMealCategories() {
        return mealCategoryRepository.findAll();
    }

    @Override
    public Optional<MealCategory> getMealCategoryByCategory(String category) {
        return mealCategoryRepository.getMealCategoryByCategory(category);
    }

    @Override
    public Optional<MealCategory> getMealCategoryByCategoryCode(String categoryCode) {
        return mealCategoryRepository.getMealCategoryByCategoryCode(categoryCode);
    }

    @Override
    public MealCategory createNewMealCategory(String category, String categoryCode) {

        MealCategory mealCategory = new MealCategory(category, categoryCode);

        return mealCategoryRepository.save(mealCategory);

    }
}
