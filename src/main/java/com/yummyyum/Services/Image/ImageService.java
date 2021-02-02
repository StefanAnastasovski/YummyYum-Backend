package com.yummyyum.Services.Image;

import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    List<Image> getAllImages();

    List<Image> getImagesByMealName(String mealName);

    Optional<Image> getImageByMealNameAndIsChefImgTrue(String mealName);

    Optional<Image> getImageByMealNameAndIsMainRecipeImgTrue(String mealName);


    Image createNewImage(String url, String alt,
                         Integer stepOrderNumber,
                         Boolean isChefImg,
                         Boolean isMainRecipeImg, Meal meal);
}
