package com.yummyyum.Services.Image.Impl;

import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import com.yummyyum.Repositories.ImageRepository;
import com.yummyyum.Repositories.MealRepository;
import com.yummyyum.Services.Image.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Image createNewImage(String url, String alt,
                                Integer stepOrderNumber,
                                Boolean isChefImg,
                                Boolean isMainRecipeImg) {

        Image image = new Image(url, alt, stepOrderNumber, isChefImg, isMainRecipeImg);

        return imageRepository.save(image);

    }


}
