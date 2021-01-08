package com.yummyyum.Services.Image;

import com.yummyyum.Model.Image;

import java.util.List;

public interface ImageService {

    List<Image> getAllImages();

    Image createNewImage(String url, String alt,
                         Integer stepOrderNumber,
                         Boolean isChefImg,
                         Boolean isMainRecipeImg);
}
