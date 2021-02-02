package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.MealCategory;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MealDTO {

    @NotNull
    private String mealName;

    @NotNull
    private String mealDescription;

    @NotNull
    private String mealTimeTag;

    @NotNull
    private String mealIngredientTag;

    @NotNull
    private Double price;

    @NotNull
    private MealCategory mealCategory;

    public MealDTO() {
    }

    public MealDTO(String mealName, String mealDescription,
                   String mealTimeTag, String mealIngredientTag,
                   Double price, MealCategory mealCategory) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealTimeTag = mealTimeTag;
        this.mealIngredientTag = mealIngredientTag;
        this.price = price;
        this.mealCategory = mealCategory;
    }

}
