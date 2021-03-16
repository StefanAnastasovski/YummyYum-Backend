package com.yummyyum.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;


@Getter
@Setter
public class ImageDTO {

    @NotNull
    @Lob
    private String url;

    @NotNull
    private String alt;

    @NotNull
    private int cookingStep;

    @NotNull
    private Boolean isChefImg;

    @NotNull
    private Boolean isMainRecipeImg;

    @NotNull
    private Meal meal;

    public ImageDTO() {
    }

    public ImageDTO(String url, String alt, int cookingStep, Boolean isChefImg, Boolean isMainRecipeImg, Meal meal) {
        this.url = url;
        this.alt = alt;
        this.cookingStep = cookingStep;
        this.isChefImg = isChefImg;
        this.isMainRecipeImg = isMainRecipeImg;
        this.meal = meal;
    }
}
