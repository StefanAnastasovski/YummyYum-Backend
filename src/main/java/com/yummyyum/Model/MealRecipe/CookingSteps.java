package com.yummyyum.Model.MealRecipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cooking_steps")
@Getter
@Setter
@AllArgsConstructor
public class CookingSteps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "step_title")
    @Lob
    private String stepTitle;

    @Column(name = "step_description")
    @Lob
    private String stepDescription;

    @Column(name = "image_urls")
    @Lob
    private String imageUrls;

    @Column(name = "meal_name_fk")
    private String mealName;

    public CookingSteps() {

    }

    public CookingSteps(String stepTitle, String stepDescription, String imageUrls, String mealName) {
        this.stepTitle = stepTitle;
        this.stepDescription = stepDescription;
        this.imageUrls = imageUrls;
        this.mealName = mealName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CookingSteps cookingSteps = (CookingSteps) o;

        return id != null ? id.equals(cookingSteps.id) : cookingSteps.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

