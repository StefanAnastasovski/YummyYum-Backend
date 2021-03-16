package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MenuDTO2 {

    @NotNull
    private String menuName;

    @NotNull
    private Date releaseDate;

    @NotNull
    private List<CategoryDTO2> mealCategories;


    public MenuDTO2() {
    }

    public MenuDTO2(String menuName, Date releaseDate, List<CategoryDTO2> mealCategories) {
        this.menuName = menuName;
        this.releaseDate = releaseDate;
        this.mealCategories = mealCategories;
    }
}
