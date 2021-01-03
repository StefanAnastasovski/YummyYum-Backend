package com.yummyyum.Services.Meal.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Repositories.MealCategoryRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.Meal.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final MealCategoryRepository mealCategoryRepository;

    public MealServiceImpl(MealRepository mealRepository, MealCategoryRepository mealCategoryRepository) {
        this.mealRepository = mealRepository;
        this.mealCategoryRepository = mealCategoryRepository;
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Optional<Meal> getMealByMealName(String mealName) {
        return mealRepository.getMealByMealName(mealName);
    }

    @Override
    public Meal createNewMeal(String mealName, String mealDescription,
                              String mealTimeTag, String mealIngredientTag,
                              Double price, MealCategory mealCategory) {

        Meal meal = new Meal(mealName, mealDescription, mealTimeTag, mealIngredientTag, price);
        Optional<MealCategory> mealCategory1 =
                mealCategoryRepository.findMealCategoryByCategory(mealCategory.getCategory());
        meal.setMealCategory(mealCategory1.get());

        return mealRepository.save(meal);

    }

}
