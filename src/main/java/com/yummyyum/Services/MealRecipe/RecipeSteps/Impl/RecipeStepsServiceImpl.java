package com.yummyyum.Services.MealRecipe.RecipeSteps.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.RecipeSteps;
import com.yummyyum.Repositories.MealRecipe.RecipeStepsRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.RecipeSteps.RecipeStepsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeStepsServiceImpl implements RecipeStepsService {

    private final RecipeStepsRepository recipeStepsRepository;
    private final MealRepository mealRepository;

    public RecipeStepsServiceImpl(RecipeStepsRepository recipeStepsRepository, MealRepository mealRepository) {
        this.recipeStepsRepository = recipeStepsRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<RecipeSteps> getAllRecipeSteps() {
        return recipeStepsRepository.findAll();
    }

    @Override
    public Optional<RecipeSteps> findRecipeStepsByMealName(String mealName) {
        return recipeStepsRepository.findRecipeStepsByMealName(mealName);
    }

    @Override
    public RecipeSteps createNewRecipeSteps(String mealUtensilsRow1, String mealUtensilsRow2, Meal meal) {

        RecipeSteps recipeSteps = new RecipeSteps(mealUtensilsRow1, mealUtensilsRow2);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        recipeSteps.setMeal(meal1.get());
        return recipeStepsRepository.save(recipeSteps);
    }


}
