package com.yummyyum.Services.MealRecipe.MealBoxNutrition.Impl;

import com.yummyyum.Model.MealRecipe.MealBoxNutrition;
import com.yummyyum.Repositories.MealRecipe.MealBoxNutritionRepository;
import com.yummyyum.Services.MealRecipe.MealBoxNutrition.MealBoxNutritionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealBoxNutritionServiceImpl implements MealBoxNutritionService {

    private final MealBoxNutritionRepository mealBoxNutritionRepository;

    public MealBoxNutritionServiceImpl(MealBoxNutritionRepository mealBoxNutritionRepository) {
        this.mealBoxNutritionRepository = mealBoxNutritionRepository;
    }

    @Override
    public List<MealBoxNutrition> getAllMealBoxNutritions() {
        return mealBoxNutritionRepository.findAll();
    }

    @Override
    public Optional<MealBoxNutrition> getMealBoxNutritionByMealName(String mealName) {
        return mealBoxNutritionRepository.getMealBoxNutritionByMealName(mealName);
    }

    @Override
    public MealBoxNutrition createNewMealBoxNutrition(Integer calories, Integer protein,
                            Integer carbohydrates, Integer fat, String mealName) {

        MealBoxNutrition mealBox = new MealBoxNutrition(calories, protein, carbohydrates, fat, mealName);

        return mealBoxNutritionRepository.save(mealBox);
    }
}

