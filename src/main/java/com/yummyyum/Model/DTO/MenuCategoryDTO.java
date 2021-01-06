package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuCategoryDTO {

    @NotNull
    private Menu menu;

    @NotNull
    private MealCategory mealCategory;

    public MenuCategoryDTO() {
    }

    public MenuCategoryDTO(Menu menu, MealCategory mealCategory) {
        this.menu = menu;
        this.mealCategory = mealCategory;
    }

}
