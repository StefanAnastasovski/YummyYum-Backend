package com.yummyyum.Services.MealRecipe.CookingSteps.Impl;

import com.yummyyum.Model.MealRecipe.CookingSteps;
import com.yummyyum.Repositories.MealRecipe.CookingStepsRepository;
import com.yummyyum.Services.MealRecipe.CookingSteps.CookingStepsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookingStepsServiceImpl implements CookingStepsService {

    private final CookingStepsRepository cookingStepsRepository;

    public CookingStepsServiceImpl(CookingStepsRepository cookingStepsRepository) {
        this.cookingStepsRepository = cookingStepsRepository;
    }

    @Override
    public List<CookingSteps> getAllCookingSteps() {
        return cookingStepsRepository.findAll();
    }

    @Override
    public List<CookingSteps> getCookingStepsByMealName(String mealName) {
        return cookingStepsRepository.getCookingStepsByMealName(mealName);
    }

    @Override
    public CookingSteps createNewCookingSteps(Integer stepNumber, String stepTitle,
                        String stepDescription, String mealName) {

        CookingSteps cookingSteps = new CookingSteps(stepNumber, stepTitle, stepDescription, mealName);

        return cookingStepsRepository.save(cookingSteps);
    }
}
