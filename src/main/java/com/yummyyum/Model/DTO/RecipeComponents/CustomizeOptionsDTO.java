package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealRecipe.MealCustomizeOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomizeOptionsDTO {

    @NotNull
    private List<MealCustomizeOption> mealCustomizeOptions;

    @NotNull
    private String mealName;

    public CustomizeOptionsDTO() {
    }

    public CustomizeOptionsDTO(List<MealCustomizeOption> mealCustomizeOptions) {
        this.mealCustomizeOptions = mealCustomizeOptions;
    }


}

