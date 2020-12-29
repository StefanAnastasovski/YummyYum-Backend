package com.yummyyum.Services.MealRecipe.MealChef.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealChef;
import com.yummyyum.Repositories.MealRecipe.MealChefRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.MealChef.MealChefService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealChefServiceImpl implements MealChefService {

    private final MealChefRepository mealChefRepository;
    private final MealRepository mealRepository;

    public MealChefServiceImpl(MealChefRepository mealChefRepository, MealRepository mealRepository) {
        this.mealChefRepository = mealChefRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<MealChef> getAllMealChefs() {
        return mealChefRepository.findAll();
    }

    @Override
    public Optional<MealChef> findMealChefByMealName(String mealName) {
        return mealChefRepository.findMealChefByMealName(mealName);
    }

    @Override
    public MealChef createNewMealChef(String fullName, String chefMealDescription, Meal meal) {

        MealChef mealChef = new MealChef(fullName, chefMealDescription);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        mealChef.setMeal(meal1.get());

        return mealChefRepository.save(mealChef);
    }
}
