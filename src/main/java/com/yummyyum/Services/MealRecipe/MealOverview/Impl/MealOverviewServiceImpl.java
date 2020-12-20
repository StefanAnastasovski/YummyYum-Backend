package com.yummyyum.Services.MealRecipe.MealOverview.Impl;

import com.yummyyum.Model.MealRecipe.MealOverview;
import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import com.yummyyum.Repositories.MealRecipe.MealOverviewRepository;
import com.yummyyum.Services.MealRecipe.MealOverview.MealOverviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealOverviewServiceImpl implements MealOverviewService {

    private final MealOverviewRepository mealOverviewRepository;

    public MealOverviewServiceImpl(MealOverviewRepository mealOverviewRepository) {
        this.mealOverviewRepository = mealOverviewRepository;
    }

    @Override
    public List<MealOverview> getAllMealOverviews() {
        return mealOverviewRepository.findAll();
    }

    @Override
    public Optional<MealOverview> getMealOverviewByMealName(String mealName) {
        return mealOverviewRepository.getMealOverviewByMealName(mealName);
    }

    @Override
    public MealOverview createNewMealOverview(DifficultyLevelEnum difficultyLevel, SpiceLevelEnum spiceLevel,
                                              String prepCookTime, Integer cookWithin, String mealName) {

        MealOverview mealOverview1 = new MealOverview(difficultyLevel, spiceLevel, prepCookTime, cookWithin, mealName);

        return mealOverviewRepository.save(mealOverview1);
    }


}
