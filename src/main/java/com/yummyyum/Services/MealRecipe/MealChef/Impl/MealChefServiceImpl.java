package com.yummyyum.Services.MealRecipe.MealChef.Impl;

import com.yummyyum.Model.MealRecipe.MealChef;
import com.yummyyum.Repositories.MealRecipe.MealChefRepository;
import com.yummyyum.Services.MealRecipe.MealChef.MealChefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealChefServiceImpl implements MealChefService {

    private final MealChefRepository mealChefRepository;

    public MealChefServiceImpl(MealChefRepository mealChefRepository) {
        this.mealChefRepository = mealChefRepository;
    }

    @Override
    public List<MealChef> getAllMealChefs() {
        return mealChefRepository.findAll();
    }

    @Override
    public Optional<MealChef> getMealChefByMealName(String mealName) {
        return mealChefRepository.getMealChefByMealName(mealName);
    }

    @Override
    public MealChef createNewMealChef(String fullName, String chefMealDescription, String mealName) {

        MealChef mealChef = new MealChef(fullName, chefMealDescription, mealName);

        return mealChefRepository.save(mealChef);
    }
}
