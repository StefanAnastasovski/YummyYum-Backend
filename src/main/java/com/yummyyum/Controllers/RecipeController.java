package com.yummyyum.Controllers;


import com.yummyyum.Model.DTO.ImageRecipeDTO;
import com.yummyyum.Model.DTO.RecipeComponents.*;
import com.yummyyum.Model.DTO.RecipeDTO;
import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.*;
import com.yummyyum.Repositories.ImageRepository;
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
    private final ImageRepository imageRepository;
    private final MealCustomizeOptionRepository mealCustomizeOptionRepository;

    public RecipeController(MealRepository mealRepository,
                            MealCategoryRepository mealCategoryRepository, MealOverviewRepository mealOverviewRepository,
                            MealChefRepository mealChefRepository,
                            MealBoxRepository mealBoxRepository,
                            MealBoxNutritionRepository mealBoxNutritionRepository,
                            CookingStepsRepository cookingStepsRepository,
                            RecipeStepsRepository recipeStepsRepository,
                            RecipeInstructionsRepository recipeInstructionsRepository, ImageRepository imageRepository,
                            MealCustomizeOptionRepository mealCustomizeOptionRepository) {
        this.mealRepository = mealRepository;
        this.mealCategoryRepository = mealCategoryRepository;
        this.mealOverviewRepository = mealOverviewRepository;
        this.mealChefRepository = mealChefRepository;
        this.mealBoxRepository = mealBoxRepository;
        this.mealBoxNutritionRepository = mealBoxNutritionRepository;
        this.cookingStepsRepository = cookingStepsRepository;
        this.recipeStepsRepository = recipeStepsRepository;
        this.recipeInstructionsRepository = recipeInstructionsRepository;
        this.imageRepository = imageRepository;
        this.mealCustomizeOptionRepository = mealCustomizeOptionRepository;
    }

    @GetMapping("/recipe/meal-name/{mealName}")
    public RecipeDTO getMealRecipeByMealName(@PathVariable("mealName") String mealName) {

        Optional<Meal> meal = mealRepository.getMealByMealName(mealName);
        Optional<MealOverview> mealOverview = mealOverviewRepository.findMealOverviewByMealName(mealName);
        Optional<MealChef> mealChef = mealChefRepository.findMealChefByMealName(mealName);
        Optional<MealBox> mealBox = mealBoxRepository.findMealBoxByMealName(mealName);
        Optional<MealBoxNutrition> mealBoxNutrition = mealBoxNutritionRepository.findMealBoxNutritionByMealName(mealName);
        List<CookingSteps> cookingSteps = cookingStepsRepository.findCookingStepsByMealName(mealName);
        Optional<RecipeSteps> recipeSteps = recipeStepsRepository.findRecipeStepsByMealName(mealName);
        Optional<RecipeInstructions> recipeInstructions = recipeInstructionsRepository.findRecipeInstructionsByMealName(mealName);
        String mealCategory = mealCategoryRepository.getMealCategoryByMealName(mealName);
        List<Image> images = imageRepository.getImagesByMealName(mealName);
        Optional<Image> chefImg = imageRepository.getImageByMealNameAndIsChefImgTrue(mealName);
        Optional<Image> mainMealImg = imageRepository.getImageByMealNameAndIsMainRecipeImgTrue(mealName);
        List<MealCustomizeOption> customizeOptions = mealCustomizeOptionRepository.getMealCustomizeOptionByMealName(mealName);

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

//        ------------------- Recipe Steps
        RecipeStepsDTO recipeStepsDTO = new RecipeStepsDTO();
        recipeStepsDTO.setMealUtensilsRow1(recipeSteps.get().getMealUtensilsRow1());
        recipeStepsDTO.setMealUtensilsRow2(recipeSteps.get().getMealUtensilsRow2());

//        ------------------- Recipe Instructions
        RecipeInstructionsDTO recipeInstructionsDTO = new RecipeInstructionsDTO();
        recipeInstructionsDTO.setCustomizeInstructions(recipeInstructions.get().getCustomizeInstructions());
        recipeInstructionsDTO.setCookSteps(recipeInstructions.get().getCookSteps());
        recipeInstructionsDTO.setGuidelines(recipeInstructions.get().getGuidelines());

//        ------------------- Cooking Steps Images
        List<ImageRecipeDTO> cookingStepsImages = new ArrayList<>();

        for (int i = 0; i < images.size(); i++) {
            ImageRecipeDTO cookingStepsImage = new ImageRecipeDTO();
            cookingStepsImage.setAlt(images.get(i).getAlt());
            cookingStepsImage.setIsChefImg(images.get(i).getIsChefImg());
            cookingStepsImage.setIsMainRecipeImg(images.get(i).getIsMainRecipeImg());
            cookingStepsImage.setUrl(images.get(i).getUrl());
            cookingStepsImages.add(cookingStepsImage);
        }

//        ------------------- Main Meal Images
        ImageRecipeDTO mainRecipeImage = new ImageRecipeDTO();
        if (images.isEmpty()) {
            mainRecipeImage = null;
        } else {
            mainRecipeImage.setAlt(mainMealImg.get().getAlt());
            mainRecipeImage.setIsChefImg(mainMealImg.get().getIsChefImg());
            mainRecipeImage.setIsMainRecipeImg(mainMealImg.get().getIsMainRecipeImg());
            mainRecipeImage.setUrl(mainMealImg.get().getUrl());
        }


//        ------------------- Chef Image
        ImageRecipeDTO chefImage = new ImageRecipeDTO();
        chefImage = null;
//        if (images.isEmpty()) {
//            chefImage = null;
//        } else {
//            chefImage.setAlt(chefImg.get().getAlt());
//            chefImage.setIsChefImg(chefImg.get().getIsChefImg());
//            chefImage.setIsMainRecipeImg(chefImg.get().getIsMainRecipeImg());
//            chefImage.setUrl(chefImg.get().getUrl());
//        }

//        ------------------- Customize Options

        List<MealCustomizeOptionDTO> mealCustomizeOptions = new ArrayList<>();

        for (MealCustomizeOption customizeOption : customizeOptions) {
            MealCustomizeOptionDTO mealCustomizeOption = new MealCustomizeOptionDTO();
            mealCustomizeOption.setMealCustomizeOption(customizeOption.getMealCustomizeOption());
            mealCustomizeOptions.add(mealCustomizeOption);
        }
//        -------------------------------------------------
        recipeDTO.setMealBox(mealBoxDTO);
        recipeDTO.setRecipeSteps(recipeStepsDTO);
        recipeDTO.setMealBoxNutrition(mealBoxNutritionDTO);
        recipeDTO.setMealOverview(mealOverviewDTO);
        recipeDTO.setRecipeInstructions(recipeInstructionsDTO);
        recipeDTO.setMealChef(mealChefDTO);
        recipeDTO.setMealCategory(mealCategory);
        recipeDTO.setCookingStepsImages(cookingStepsImages);
        recipeDTO.setChefImg(chefImage);
        recipeDTO.setMainRecipeImage(mainRecipeImage);
        recipeDTO.setMealCustomizeOptions(mealCustomizeOptions);

        for (int i = 0; i < cookingSteps.size(); i++) {

            recipeDTO.setCookingSteps(cookingStepsList[i].get(i));

        }

        return recipeDTO;

    }
//1,Option 1,1
//2,Option 2,1
//3,Option 3,1


}
