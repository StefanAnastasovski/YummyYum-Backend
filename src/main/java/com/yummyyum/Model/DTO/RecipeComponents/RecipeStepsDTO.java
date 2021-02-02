package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeStepsDTO {

    @NotNull
    private String mealUtensilsRow1;

    @NotNull
    private String mealUtensilsRow2;

    public RecipeStepsDTO(){}

    public RecipeStepsDTO(String mealUtensilsRow1, String mealUtensilsRow2) {
        this.mealUtensilsRow1 = mealUtensilsRow1;
        this.mealUtensilsRow2 = mealUtensilsRow2;
    }

}
