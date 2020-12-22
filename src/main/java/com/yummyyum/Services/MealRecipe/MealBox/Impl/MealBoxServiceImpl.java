package com.yummyyum.Services.MealRecipe.MealBox.Impl;

import com.yummyyum.Model.MealRecipe.MealBox;
import com.yummyyum.Repositories.MealRecipe.MealBoxRepository;
import com.yummyyum.Services.MealRecipe.MealBox.MealBoxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealBoxServiceImpl implements MealBoxService {

    private final MealBoxRepository mealBoxRepository;

    public MealBoxServiceImpl(MealBoxRepository mealBoxRepository) {
        this.mealBoxRepository = mealBoxRepository;
    }

    @Override
    public List<MealBox> getAllMealBoxes() {
        return mealBoxRepository.findAll();
    }

    @Override
    public Optional<MealBox> getMealBoxByMealName(String mealName) {
        return mealBoxRepository.getMealBoxByMealName(mealName);
    }

    @Override
    public MealBox createNewMealBox(Integer serveQuantity, String mealIngredients, String mealName) {

        MealBox mealBox = new MealBox(serveQuantity, mealIngredients, mealName);

        return mealBoxRepository.save(mealBox);
    }


}
