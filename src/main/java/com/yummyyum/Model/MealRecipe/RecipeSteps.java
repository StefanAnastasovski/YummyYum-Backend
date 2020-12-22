package com.yummyyum.Model.MealRecipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "recipe_steps")
@Getter
@Setter
@AllArgsConstructor
public class RecipeSteps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "meal_utensils_row1")
    @Lob
    private String mealUtensilsRow1;

    @Column(name = "meal_utensils_row2")
    @Lob
    private String mealUtensilsRow2;

    @Column(name = "meal_name_fk")
    private String mealName;

    public RecipeSteps() {

    }

    public RecipeSteps(String mealUtensilsRow1, String mealUtensilsRow2, String mealName) {
        this.mealUtensilsRow1 = mealUtensilsRow1;
        this.mealUtensilsRow2 = mealUtensilsRow2;
        this.mealName = mealName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeSteps recipeSteps = (RecipeSteps) o;

        return id != null ? id.equals(recipeSteps.id) : recipeSteps.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

