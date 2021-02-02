package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealChefDTO {

    @NotNull
    private String fullName;

    @NotNull
    private String chefMealDescription;

    public MealChefDTO(){}

    public MealChefDTO(String fullName, String chefMealDescription) {
        this.fullName = fullName;
        this.chefMealDescription = chefMealDescription;
    }

}
