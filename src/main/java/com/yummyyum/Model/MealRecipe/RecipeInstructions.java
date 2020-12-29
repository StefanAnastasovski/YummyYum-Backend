package com.yummyyum.Model.MealRecipe;

import com.yummyyum.Model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "recipe_instructions")
@Getter
@Setter
@AllArgsConstructor
public class RecipeInstructions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cook_steps")
    @Lob
    private String cookSteps;

    @Column(name = "guidelines")
    @Lob
    private String guidelines;

    @Column(name = "customize_instructions")
    @Lob
    private String customizeInstructions;

    @OneToOne
    @JoinColumn(name = "recipe_instructions_id", referencedColumnName = "id")
    private Meal meal;

    public RecipeInstructions() {

    }

    public RecipeInstructions(String cookSteps, String guidelines, String customizeInstructions) {
        this.cookSteps = cookSteps;
        this.guidelines = guidelines;
        this.customizeInstructions = customizeInstructions;
    }

    @Override
    public String toString() {
        return "RecipeInstructions{" +
                "cookSteps='" + cookSteps + '\'' +
                ", guidelines='" + guidelines + '\'' +
                ", customizeInstructions='" + customizeInstructions + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeInstructions recipeInstructions = (RecipeInstructions) o;

        return id != null ? id.equals(recipeInstructions.id) : recipeInstructions.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

