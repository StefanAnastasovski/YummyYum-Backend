package com.yummyyum.Services.MealRecipe.MealCustomizeOption.Impl;

import com.yummyyum.Model.DTO.RecipeComponents.CustomizeOptionsDTO;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealCustomizeOption;
import com.yummyyum.Repositories.MealRecipe.MealCustomizeOptionRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.MealCustomizeOption.MealCustomizeOptionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealCustomizeOptionServiceImpl implements MealCustomizeOptionService {

    private final MealCustomizeOptionRepository mealCustomizeOptionRepository;
    private final MealRepository mealRepository;

    public MealCustomizeOptionServiceImpl(MealCustomizeOptionRepository mealCustomizeOptionRepository,
                                          MealRepository mealRepository) {
        this.mealCustomizeOptionRepository = mealCustomizeOptionRepository;
        this.mealRepository = mealRepository;
    }


    @Override
    public List<MealCustomizeOption> getAllMealCustomizeOptionsByMeal(String mealName) {
        return mealCustomizeOptionRepository.getMealCustomizeOptionByMealName(mealName);

    }

    @Override
    public List<MealCustomizeOption> createNewMealCustomizeOption(List<MealCustomizeOption> mealCustomizeOptions, String mealName) {

        Optional<Meal> meal1 = mealRepository.getMealByMealName(mealName);
        List<MealCustomizeOption> mealCustomizeOptionsList = new ArrayList<>();

        for (MealCustomizeOption mealCustomizeOption : mealCustomizeOptions) {
            MealCustomizeOption mealCustomizeOption1 = new MealCustomizeOption(mealCustomizeOption.getMealCustomizeOption());
            mealCustomizeOption1.setMeal(meal1.get());
            mealCustomizeOptionsList.add(mealCustomizeOption1);
        }
            mealCustomizeOptionRepository.saveAll(mealCustomizeOptionsList);


        return mealCustomizeOptionsList;

    }

}
