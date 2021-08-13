package com.yummyyum.Services.Meal.Impl;

import com.yummyyum.Model.DTO.MealExampleDTO;
import com.yummyyum.Model.DTO.RecipeComponents.MealBoxNutritionDTO;
import com.yummyyum.Model.DTO.RecipeComponents.MealCustomizeOptionDTO;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.MealRecipe.*;
import com.yummyyum.Repositories.MealCategoryRepository;
import com.yummyyum.Repositories.MealRecipe.*;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.Meal.MealService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final MealCategoryRepository mealCategoryRepository;
    private final MealOverviewRepository mealOverviewRepository;
    private final MealChefRepository mealChefRepository;
    private final MealBoxRepository mealBoxRepository;
    private final MealBoxNutritionRepository mealBoxNutritionRepository;
    private final CookingStepsRepository cookingStepsRepository;
    private final RecipeStepsRepository recipeStepsRepository;
    private final RecipeInstructionsRepository recipeInstructionsRepository;
    private final MealCustomizeOptionRepository mealCustomizeOptionRepository;

    public MealServiceImpl(MealRepository mealRepository,
                           MealCategoryRepository mealCategoryRepository,
                           MealOverviewRepository mealOverviewRepository,
                           MealChefRepository mealChefRepository,
                           MealBoxRepository mealBoxRepository,
                           MealBoxNutritionRepository mealBoxNutritionRepository,
                           CookingStepsRepository cookingStepsRepository,
                           RecipeStepsRepository recipeStepsRepository,
                           RecipeInstructionsRepository recipeInstructionsRepository,
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
        this.mealCustomizeOptionRepository = mealCustomizeOptionRepository;
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Optional<Meal> getMealByMealName(String mealName) {
        return mealRepository.getMealByMealName(mealName);
    }

    @Override
    public List<Meal> getMealsByMealCategory(String category) {
        return mealRepository.getMealsByMealCategory(category);
    }

    @Override
    public Meal createNewMeal(String mealName, String mealDescription,
                              String mealTimeTag, String mealIngredientTag,
                              Double price, MealCategory mealCategory) {

        Meal meal = new Meal(mealName, mealDescription, mealTimeTag, mealIngredientTag, price);
        Optional<MealCategory> mealCategory1 =
                mealCategoryRepository.findMealCategoryByCategory(mealCategory.getCategory());
        meal.setMealCategory(mealCategory1.get());

        return mealRepository.save(meal);

    }

    @Override
    public MealExampleDTO createMeal(String mealName, String mealDescription,
                                     String mealTimeTag, String mealIngredientTag,
                                     Double price, MealCategory mealCategory,
                                     MealOverview mealOverview, MealChef mealChef,
                                     MealBox mealBox, MealBoxNutritionDTO mealBoxNutrition,
                                     RecipeSteps recipeSteps, RecipeInstructions recipeInstructions,
                                     CookingSteps cookingSteps, List<MealCustomizeOptionDTO> mealCustomizeOptions) {

        Meal meal = new Meal(mealName, mealDescription,
                mealTimeTag, mealIngredientTag, price);
        Optional<MealCategory> mealCategory1 =
                mealCategoryRepository.findMealCategoryByCategory(mealCategory.getCategory());
        meal.setMealCategory(mealCategory1.get());

        mealRepository.save(meal);

        MealOverview mealOverview1 = new MealOverview(mealOverview.getDifficultyLevel(), mealOverview.getSpiceLevel(),
                mealOverview.getPrepCookTime(), mealOverview.getCookWithin());
        mealOverview1.setMeal(meal);

        mealOverviewRepository.save(mealOverview1);

        MealChef mealChef1 = new MealChef(mealChef.getFullName(), mealChef.getChefMealDescription());
        mealChef1.setMeal(meal);

        mealChefRepository.save(mealChef1);

        MealBox mealBox1 = new MealBox(mealBox.getServeQuantity(), mealBox.getMealIngredients());
        mealBox1.setMeal(meal);

        mealBoxRepository.save(mealBox1);


        MealBoxNutrition mealBoxNutrition1 = new MealBoxNutrition(mealBoxNutrition.getCalories(),
                mealBoxNutrition.getProtein(), mealBoxNutrition.getCarbohydrates(), mealBoxNutrition.getFat());
        mealBoxNutrition1.setMeal(meal);

        mealBoxNutritionRepository.save(mealBoxNutrition1);


        RecipeSteps recipeSteps1 = new RecipeSteps(recipeSteps.getMealUtensilsRow1(), recipeSteps.getMealUtensilsRow2());
        recipeSteps1.setMeal(meal);

        recipeStepsRepository.save(recipeSteps1);

        RecipeInstructions recipeInstructions1 = new RecipeInstructions(recipeInstructions.getCookSteps(),
                recipeInstructions.getGuidelines(), recipeInstructions.getCustomizeInstructions());
        recipeInstructions1.setMeal(meal);

        recipeInstructionsRepository.save(recipeInstructions1);

        CookingSteps cookingSteps1 = new CookingSteps(cookingSteps.getStepNumber(),
                cookingSteps.getStepTitle(), cookingSteps.getStepDescription());
        cookingSteps1.setMeal(meal);

        cookingStepsRepository.save(cookingSteps1);


        List<MealCustomizeOption> mealCustomizeOptionList = new ArrayList<>();

        for (MealCustomizeOptionDTO mealCustomizeOption : mealCustomizeOptions) {
            MealCustomizeOption mealCustomizeOption1 = new MealCustomizeOption();

            mealCustomizeOption1.setMealCustomizeOption(mealCustomizeOption.getMealCustomizeOption());
            mealCustomizeOption1.setMeal(meal);

            mealCustomizeOptionList.add(mealCustomizeOption1);
        }

        mealCustomizeOptionRepository.saveAll(mealCustomizeOptionList);


        return null;
    }

}
