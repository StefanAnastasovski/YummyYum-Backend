package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MenuNutritionDTO {

    @NotNull
    private String menuName;

    @NotNull
    private Date releaseDate;

    @NotNull
    private List<CategoryMealsNutritionDTO> mealCategories;


    public MenuNutritionDTO() {
    }

    public MenuNutritionDTO(String menuName, Date releaseDate,
                            List<CategoryMealsNutritionDTO> mealCategories) {
        this.menuName = menuName;
        this.releaseDate = releaseDate;
        this.mealCategories = mealCategories;
    }
}
