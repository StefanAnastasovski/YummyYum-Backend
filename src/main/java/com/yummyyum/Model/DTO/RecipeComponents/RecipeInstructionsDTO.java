package com.yummyyum.Model.DTO.RecipeComponents;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeInstructionsDTO {

    @NotNull
    private String cookSteps;

    @NotNull
    private String guidelines;

    @NotNull
    private String customizeInstructions;

    public RecipeInstructionsDTO() {
    }

    public RecipeInstructionsDTO(String cookSteps, String guidelines, String customizeInstructions) {
        this.cookSteps = cookSteps;
        this.guidelines = guidelines;
        this.customizeInstructions = customizeInstructions;
    }

}
