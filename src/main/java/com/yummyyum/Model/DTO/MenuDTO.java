package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MenuDTO {

    @NotNull
    private String menuName;

    @NotNull
    private Date releaseDate;

    @NotNull
    private List<CategoryDTO> mealCategories;


    public MenuDTO() {
    }

    public MenuDTO(String menuName, Date releaseDate, List<CategoryDTO> mealCategories) {
        this.menuName = menuName;
        this.releaseDate = releaseDate;
        this.mealCategories = mealCategories;
    }
}
