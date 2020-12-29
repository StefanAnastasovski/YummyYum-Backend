package com.yummyyum.Services.MealRecipe.MealBox.Impl;

import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealBox;
import com.yummyyum.Repositories.MealRecipe.MealBoxRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.MealRecipe.MealBox.MealBoxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealBoxServiceImpl implements MealBoxService {

    private final MealBoxRepository mealBoxRepository;
    private final MealRepository mealRepository;

    public MealBoxServiceImpl(MealBoxRepository mealBoxRepository, MealRepository mealRepository) {
        this.mealBoxRepository = mealBoxRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<MealBox> getAllMealBoxes() {
        return mealBoxRepository.findAll();
    }

    @Override
    public Optional<MealBox> findMealBoxByMealName(String mealName) {
        return mealBoxRepository.findMealBoxByMealName(mealName);
    }

    @Override
    public MealBox createNewMealBox(Integer serveQuantity, String mealIngredients, Meal meal) {

        MealBox mealBox = new MealBox(serveQuantity, mealIngredients);
        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());
        mealBox.setMeal(meal1.get());

        return mealBoxRepository.save(mealBox);
    }


}
