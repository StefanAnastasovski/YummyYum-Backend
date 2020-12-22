package com.yummyyum.Services.MealRecipe.RecipeSteps.Impl;

import com.yummyyum.Model.MealRecipe.RecipeSteps;
import com.yummyyum.Repositories.MealRecipe.RecipeStepsRepository;
import com.yummyyum.Services.MealRecipe.RecipeSteps.RecipeStepsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeStepsServiceImpl implements RecipeStepsService {

    private final RecipeStepsRepository recipeStepsRepository;

    public RecipeStepsServiceImpl(RecipeStepsRepository recipeStepsRepository) {
        this.recipeStepsRepository = recipeStepsRepository;
    }

    @Override
    public List<RecipeSteps> getAllRecipeSteps() {
        return recipeStepsRepository.findAll();
    }

    @Override
    public Optional<RecipeSteps> getRecipeStepsByMealName(String mealName) {
        return recipeStepsRepository.getRecipeStepsByMealName(mealName);
    }

    @Override
    public RecipeSteps createNewRecipeSteps(String mealUtensilsRow1, String mealUtensilsRow2, String mealName) {

        RecipeSteps recipeSteps = new RecipeSteps(mealUtensilsRow1, mealUtensilsRow2, mealName);

        return recipeStepsRepository.save(recipeSteps);
    }


}
