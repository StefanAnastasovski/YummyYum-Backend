package com.yummyyum.Services.MealRecipe.MealBoxNutrition.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealBoxNutrition;
import com.yummyyum.Repositories.MealRecipe.MealBoxNutritionRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.MealBoxNutrition.MealBoxNutritionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealBoxNutritionServiceImpl implements MealBoxNutritionService {

    private final MealBoxNutritionRepository mealBoxNutritionRepository;
    private final MealRepository mealRepository;

    public MealBoxNutritionServiceImpl(MealBoxNutritionRepository mealBoxNutritionRepository, MealRepository mealRepository) {
        this.mealBoxNutritionRepository = mealBoxNutritionRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<MealBoxNutrition> getAllMealBoxNutritions() {
        return mealBoxNutritionRepository.findAll();
    }

    @Override
    public Optional<MealBoxNutrition> findMealBoxNutritionByMealName(String mealName) {
        return mealBoxNutritionRepository.findMealBoxNutritionByMealName(mealName);
    }

    @Override
    public MealBoxNutrition createNewMealBoxNutrition(Integer calories, Integer protein,
                                                      Integer carbohydrates, Integer fat, Meal meal) {

        MealBoxNutrition mealBoxNutrition = new MealBoxNutrition(calories, protein, carbohydrates, fat);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        mealBoxNutrition.setMeal(meal1.get());

        return mealBoxNutritionRepository.save(mealBoxNutrition);
    }
}

