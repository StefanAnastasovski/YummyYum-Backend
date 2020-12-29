package com.yummyyum.Services.MealRecipe.CookingSteps.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.CookingSteps;
import com.yummyyum.Repositories.MealRecipe.CookingStepsRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.CookingSteps.CookingStepsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookingStepsServiceImpl implements CookingStepsService {

    private final CookingStepsRepository cookingStepsRepository;
    private final MealRepository mealRepository;

    public CookingStepsServiceImpl(CookingStepsRepository cookingStepsRepository, MealRepository mealRepository) {
        this.cookingStepsRepository = cookingStepsRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<CookingSteps> getAllCookingSteps() {
        return cookingStepsRepository.findAll();
    }

    @Override
    public List<CookingSteps> findCookingStepsByMealName(String mealName) {
        return cookingStepsRepository.findCookingStepsByMealName(mealName);
    }

    @Override
    public CookingSteps createNewCookingSteps(Integer stepNumber, String stepTitle,
                                              String stepDescription, Meal meal) {

        CookingSteps cookingSteps = new CookingSteps(stepNumber, stepTitle, stepDescription);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        cookingSteps.setMeal(meal1.get());
        return cookingStepsRepository.save(cookingSteps);
    }
}
