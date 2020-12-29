package com.yummyyum.Model.MealRecipe;

import com.yummyyum.Model.Meal;
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

    @OneToOne
    @JoinColumn(name = "recipe_steps_id", referencedColumnName = "id")
    private Meal meal;

    public RecipeSteps() {

    }

    public RecipeSteps(String mealUtensilsRow1, String mealUtensilsRow2) {
        this.mealUtensilsRow1 = mealUtensilsRow1;
        this.mealUtensilsRow2 = mealUtensilsRow2;
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

