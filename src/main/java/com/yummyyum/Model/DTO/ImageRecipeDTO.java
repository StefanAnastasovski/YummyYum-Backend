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
public class ImageRecipeDTO {

    @NotNull
    @Lob
    private String url;

    @NotNull
    private String alt;

    @NotNull
    private Boolean isChefImg;

    @NotNull
    private Boolean isMainRecipeImg;

    public ImageRecipeDTO() {
    }

    public ImageRecipeDTO(String url, String alt,
                    Boolean isChefImg,
                    Boolean isMainRecipeImg) {

        this.url = url;
        this.alt = alt;
        this.isChefImg = isChefImg;
        this.isMainRecipeImg = isMainRecipeImg;
    }

}
