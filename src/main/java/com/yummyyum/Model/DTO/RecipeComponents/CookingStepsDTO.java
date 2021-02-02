package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookingStepsDTO {

    @NotNull
    private Integer stepNumber;

    @NotNull
    private String stepTitle;

    @NotNull
    private String stepDescription;

    public CookingStepsDTO(){}

    public CookingStepsDTO(Integer stepNumber, String stepTitle, String stepDescription) {
        this.stepNumber = stepNumber;
        this.stepTitle = stepTitle;
        this.stepDescription = stepDescription;
    }

}
