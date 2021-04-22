package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MealCustomizeOptionDTO {

    @NotNull
    private String mealCustomizeOption;

    public MealCustomizeOptionDTO() {
    }

}

