package com.yummyyum.Services.Meal.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.Meal.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
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
                              Double price) {

        Meal meal = new Meal(mealName, mealDescription, mealTimeTag, mealIngredientTag, price);

        return mealRepository.save(meal);

    }

}
