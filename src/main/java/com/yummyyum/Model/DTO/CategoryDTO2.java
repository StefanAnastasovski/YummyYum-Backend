package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.Meal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO2 {

    @NotNull
    private String category;

    @NotNull
    private List<MealDTO> meals;


    public CategoryDTO2() {
    }

    public CategoryDTO2(String category, List<MealDTO> meals) {
        this.category = category;
        this.meals = meals;
    }
}
