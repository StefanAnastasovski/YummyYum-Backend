package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ImageDTO {

    @NotNull
    private String url;

    @NotNull
    private String alt;

    @NotNull
    private Integer stepOrderNumber;

    @NotNull
    private Boolean isChefImg;

    @NotNull
    private Boolean isMainRecipeImg;

    @NotNull
    private Meal meal;

    public ImageDTO() {
    }

    public ImageDTO(String url, String alt,
                    Integer stepOrderNumber, Boolean isChefImg,
                    Boolean isMainRecipeImg, Meal meal) {
        this.url = url;
        this.alt = alt;
        this.stepOrderNumber = stepOrderNumber;
        this.isChefImg = isChefImg;
        this.isMainRecipeImg = isMainRecipeImg;
        this.meal = meal;
    }

}
