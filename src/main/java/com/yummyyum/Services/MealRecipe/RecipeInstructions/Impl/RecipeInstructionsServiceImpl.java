package com.yummyyum.Services.MealRecipe.RecipeInstructions.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.RecipeInstructions;
import com.yummyyum.Repositories.MealRecipe.RecipeInstructionsRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.RecipeInstructions.RecipeInstructionsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeInstructionsServiceImpl implements RecipeInstructionsService {

    private final RecipeInstructionsRepository  recipeInstructionsRepository;
    private final MealRepository mealRepository;

    public RecipeInstructionsServiceImpl(RecipeInstructionsRepository recipeInstructionsRepository,
                                         MealRepository mealRepository) {
        this.recipeInstructionsRepository = recipeInstructionsRepository;
        this.mealRepository = mealRepository;
    }


    @Override
    public List<RecipeInstructions> getAllRecipeInstructions() {
        return recipeInstructionsRepository.findAll();
    }

    @Override
    public Optional<RecipeInstructions> findRecipeInstructionsByMealName(String mealName) {
        return recipeInstructionsRepository.findRecipeInstructionsByMealName(mealName);
    }

    @Override
    public RecipeInstructions createNewRecipeInstructions(String cookSteps, String guidelines,
                                                          String customizeInstructions, Meal meal) {
        RecipeInstructions recipeInstructions = new RecipeInstructions(cookSteps, guidelines,
                customizeInstructions);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        recipeInstructions.setMeal(meal1.get());
        return recipeInstructionsRepository.save(recipeInstructions);
    }

}
