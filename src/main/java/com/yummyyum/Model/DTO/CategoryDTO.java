package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.Meal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {

    @NotNull
    private String category;

    @NotNull
    private List<Meal> meals;


    public CategoryDTO() {
    }

    public CategoryDTO(String category, List<Meal> meals) {
        this.category = category;
        this.meals = meals;
    }
}
