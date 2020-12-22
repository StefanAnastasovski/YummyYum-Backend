package com.yummyyum.Services.MealRecipe.RecipeInstructions.Impl;

import com.yummyyum.Model.MealRecipe.RecipeInstructions;
import com.yummyyum.Repositories.MealRecipe.RecipeInstructionsRepository;
import com.yummyyum.Services.MealRecipe.RecipeInstructions.RecipeInstructionsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeInstructionsServiceImpl implements RecipeInstructionsService {

    private final RecipeInstructionsRepository  recipeInstructionsRepository;

    public RecipeInstructionsServiceImpl(RecipeInstructionsRepository recipeInstructionsRepository) {
        this.recipeInstructionsRepository = recipeInstructionsRepository;
    }


    @Override
    public List<RecipeInstructions> getAllRecipeInstructions() {
        return recipeInstructionsRepository.findAll();
    }

    @Override
    public Optional<RecipeInstructions> getRecipeInstructionsByMealName(String mealName) {
        return recipeInstructionsRepository.getRecipeInstructionsByMealName(mealName);
    }

    @Override
    public RecipeInstructions createNewRecipeInstructions(String cookSteps, String guidelines,
                                                          String customizeInstructions, String mealName) {
        RecipeInstructions recipeInstructions = new RecipeInstructions(cookSteps, guidelines,
                customizeInstructions, mealName);
        return recipeInstructionsRepository.save(recipeInstructions);
    }

}
