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
    public Optional<MealCategory> findMealCategoryByCategory(String category) {
        return mealCategoryRepository.findMealCategoryByCategory(category);
    }


    @Override
    public MealCategory createNewMealCategory(String category) {

        MealCategory mealCategory = new MealCategory(category);

        return mealCategoryRepository.save(mealCategory);

    }
}
