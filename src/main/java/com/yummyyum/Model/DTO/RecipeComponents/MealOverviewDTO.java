package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealOverviewDTO {


    @NotNull
    private DifficultyLevelEnum difficultyLevel;

    @NotNull
    private SpiceLevelEnum spiceLevel;

    @NotNull
    private String prepCookTime;

    @NotNull
    private Integer cookWithin;

    public MealOverviewDTO(){}

    public MealOverviewDTO(DifficultyLevelEnum difficultyLevel, SpiceLevelEnum spiceLevel, String prepCookTime, Integer cookWithin) {
        this.difficultyLevel = difficultyLevel;
        this.spiceLevel = spiceLevel;
        this.prepCookTime = prepCookTime;
        this.cookWithin = cookWithin;
    }

}
