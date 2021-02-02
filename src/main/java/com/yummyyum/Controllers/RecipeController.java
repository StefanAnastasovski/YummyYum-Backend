package com.yummyyum.Controllers;


import com.yummyyum.Model.DTO.RecipeComponents.*;
import com.yummyyum.Model.DTO.RecipeDTO;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.MealRecipe.*;
import com.yummyyum.Repositories.MealCategoryRepository;
import com.yummyyum.Repositories.MealRecipe.*;
import com.yummyyum.Repositories.MealRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class RecipeController {

    private final MealRepository mealRepository;
    private final MealCategoryRepository mealCategoryRepository;
    private final MealOverviewRepository mealOverviewRepository;
    private final MealChefRepository mealChefRepository;
    private final MealBoxRepository mealBoxRepository;
    private final MealBoxNutritionRepository mealBoxNutritionRepository;
    private final CookingStepsRepository cookingStepsRepository;
    private final RecipeStepsRepository recipeStepsRepository;
    private final RecipeInstructionsRepository recipeInstructionsRepository;

    public RecipeController(MealRepository mealRepository,
                            MealCategoryRepository mealCategoryRepository, MealOverviewRepository mealOverviewRepository,
                            MealChefRepository mealChefRepository,
                            MealBoxRepository mealBoxRepository,
                            MealBoxNutritionRepository mealBoxNutritionRepository,
                            CookingStepsRepository cookingStepsRepository,
                            RecipeStepsRepository recipeStepsRepository,
                            RecipeInstructionsRepository recipeInstructionsRepository) {
        this.mealRepository = mealRepository;
        this.mealCategoryRepository = mealCategoryRepository;
        this.mealOverviewRepository = mealOverviewRepository;
        this.mealChefRepository = mealChefRepository;
        this.mealBoxRepository = mealBoxRepository;
        this.mealBoxNutritionRepository = mealBoxNutritionRepository;
        this.cookingStepsRepository = cookingStepsRepository;
        this.recipeStepsRepository = recipeStepsRepository;
        this.recipeInstructionsRepository = recipeInstructionsRepository;
    }

    @GetMapping("/recipe/meal-name/{mealName}")
    public RecipeDTO getMenuByMenuName(@PathVariable("mealName") String mealName) {

        Optional<Meal> meal = mealRepository.getMealByMealName(mealName);
        Optional<MealOverview> mealOverview = mealOverviewRepository.findMealOverviewByMealName(mealName);
        Optional<MealChef> mealChef = mealChefRepository.findMealChefByMealName(mealName);
        Optional<MealBox> mealBox = mealBoxRepository.findMealBoxByMealName(mealName);
        Optional<MealBoxNutrition> mealBoxNutrition = mealBoxNutritionRepository.findMealBoxNutritionByMealName(mealName);
        List<CookingSteps> cookingSteps = cookingStepsRepository.findCookingStepsByMealName(mealName);
        Optional<RecipeSteps> recipeSteps = recipeStepsRepository.findRecipeStepsByMealName(mealName);
        Optional<RecipeInstructions> recipeInstructions = recipeInstructionsRepository.findRecipeInstructionsByMealName(mealName);
        String mealCategory = mealCategoryRepository.getMealCategoryByMealName(mealName);

        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setMealName(meal.get().getMealName());
        recipeDTO.setMealDescription(meal.get().getMealDescription());
        recipeDTO.setMealTimeTag(meal.get().getMealTimeTag());
        recipeDTO.setMealIngredientTag(meal.get().getMealIngredientTag());
        recipeDTO.setPrice(meal.get().getPrice());

//        ------------------- Meal Overview
        MealOverviewDTO mealOverviewDTO = new MealOverviewDTO();

        mealOverviewDTO.setCookWithin(mealOverview.get().getCookWithin());
        mealOverviewDTO.setDifficultyLevel(mealOverview.get().getDifficultyLevel());
        mealOverviewDTO.setSpiceLevel(mealOverview.get().getSpiceLevel());
        mealOverviewDTO.setPrepCookTime(mealOverview.get().getPrepCookTime());

//        ------------------- Meal Chef
        MealChefDTO mealChefDTO = new MealChefDTO();

        mealChefDTO.setChefMealDescription(mealChef.get().getChefMealDescription());
        mealChefDTO.setFullName(mealChef.get().getFullName());

//        ------------------- Meal Box
        MealBoxDTO mealBoxDTO = new MealBoxDTO();

        mealBoxDTO.setMealIngredients(mealBox.get().getMealIngredients());
        mealBoxDTO.setServeQuantity(mealBox.get().getServeQuantity());

//        ------------------- Meal Box Nutrition
        MealBoxNutritionDTO mealBoxNutritionDTO = new MealBoxNutritionDTO();

        mealBoxNutritionDTO.setCalories(mealBoxNutrition.get().getCalories());
        mealBoxNutritionDTO.setCarbohydrates(mealBoxNutrition.get().getCarbohydrates());
        mealBoxNutritionDTO.setProtein(mealBoxNutrition.get().getProtein());
        mealBoxNutritionDTO.setFat(mealBoxNutrition.get().getFat());

//        ------------------- Cooking Steps
        CookingStepsDTO cookingStepsDTO = new CookingStepsDTO();

        List<CookingStepsDTO> cookingStepsDTOs = new ArrayList<>();

        int n = cookingSteps.size();
        ArrayList<CookingStepsDTO>[] cookingStepsList = new ArrayList[n];

        // initializing
        for (int i = 0; i < n; i++) {
            cookingStepsList[i] = new ArrayList<CookingStepsDTO>();
        }

        for (int i = 0; i < cookingSteps.size(); i++) {

            cookingStepsDTO.setStepNumber(cookingSteps.get(i).getStepNumber());
            cookingStepsDTO.setStepTitle(cookingSteps.get(i).getStepTitle());
            cookingStepsDTO.setStepDescription(cookingSteps.get(i).getStepDescription());

            cookingStepsList[i].add(cookingStepsDTO);

        }

        for (int i = 0; i < cookingSteps.size(); i++) {

            System.out.println(cookingStepsList[i]);

        }

//        ------------------- Recipe Steps
        RecipeStepsDTO recipeStepsDTO = new RecipeStepsDTO();

        recipeStepsDTO.setMealUtensilsRow1(recipeSteps.get().getMealUtensilsRow1());
        recipeStepsDTO.setMealUtensilsRow2(recipeSteps.get().getMealUtensilsRow2());

//        ------------------- Recipe Instructions
        RecipeInstructionsDTO recipeInstructionsDTO = new RecipeInstructionsDTO();

        recipeInstructionsDTO.setCustomizeInstructions(recipeInstructions.get().getCustomizeInstructions());
        recipeInstructionsDTO.setCookSteps(recipeInstructions.get().getCookSteps());
        recipeInstructionsDTO.setGuidelines(recipeInstructions.get().getGuidelines());

//        ------------------- Meal Category


        recipeDTO.setMealBox(mealBoxDTO);
        recipeDTO.setRecipeSteps(recipeStepsDTO);
        recipeDTO.setMealBoxNutrition(mealBoxNutritionDTO);
        recipeDTO.setMealOverview(mealOverviewDTO);
        recipeDTO.setRecipeInstructions(recipeInstructionsDTO);
        recipeDTO.setMealChef(mealChefDTO);
        recipeDTO.setMealCategory(mealCategory);
        for (int i = 0; i < cookingSteps.size(); i++) {

              recipeDTO.setCookingSteps(cookingStepsList[i].get(i));

        }

        return recipeDTO;

    }


}
