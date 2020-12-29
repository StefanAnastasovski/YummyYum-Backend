package com.yummyyum.Services.MealRecipe.MealOverview.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealOverview;
import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import com.yummyyum.Repositories.MealRecipe.MealOverviewRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.MealOverview.MealOverviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealOverviewServiceImpl implements MealOverviewService {

    private final MealOverviewRepository mealOverviewRepository;
    private final MealRepository mealRepository;

    public MealOverviewServiceImpl(MealOverviewRepository mealOverviewRepository, MealRepository mealRepository) {
        this.mealOverviewRepository = mealOverviewRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<MealOverview> getAllMealOverviews() {
        return mealOverviewRepository.findAll();
    }

    @Override
    public Optional<MealOverview> findMealOverviewByMealName(String mealName) {
        return mealOverviewRepository.findMealOverviewByMealName(mealName);
    }

    @Override
    public MealOverview createNewMealOverview(DifficultyLevelEnum difficultyLevel, SpiceLevelEnum spiceLevel,
                                              String prepCookTime, Integer cookWithin, Meal meal) {

        MealOverview mealOverview1 = new MealOverview(difficultyLevel, spiceLevel, prepCookTime, cookWithin);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        mealOverview1.setMeal(meal1.get());
        return mealOverviewRepository.save(mealOverview1);
    }


}
