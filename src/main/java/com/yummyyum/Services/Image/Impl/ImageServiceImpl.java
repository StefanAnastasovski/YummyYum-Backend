package com.yummyyum.Services.Image.Impl;

import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import com.yummyyum.Repositories.ImageRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.Image.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final MealRepository mealRepository;

    public ImageServiceImpl(ImageRepository imageRepository, MealRepository mealRepository) {
        this.imageRepository = imageRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImagesByMealName(String mealName) {
        return imageRepository.getImagesByMealName(mealName);
    }

    @Override
    public Optional<Image> getImageByMealNameAndIsChefImgTrue(String mealName) {
        return imageRepository.getImageByMealNameAndIsChefImgTrue(mealName);
    }

    @Override
    public Optional<Image> getImageByMealNameAndIsMainRecipeImgTrue(String mealName) {
        return imageRepository.getImageByMealNameAndIsMainRecipeImgTrue(mealName);
    }


    @Override
    public Image createNewImage(String url, String alt,
                                Boolean isChefImg,
                                Boolean isMainRecipeImg, Meal meal) {

        Image image = new Image(url, alt, isChefImg, isMainRecipeImg);

        Optional<Meal> meal1 = mealRepository.getMealByMealName(meal.getMealName());

        image.setMeal(meal1.get());

        return imageRepository.save(image);

    }


}
