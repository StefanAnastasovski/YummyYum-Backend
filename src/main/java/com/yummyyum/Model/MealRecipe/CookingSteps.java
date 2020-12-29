package com.yummyyum.Model.MealRecipe;

import com.yummyyum.Model.Meal;
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

    @Column(name = "step_number")
    private Integer stepNumber;

    @Column(name = "step_title")
    @Lob
    private String stepTitle;

    @Column(name = "step_description")
    @Lob
    private String stepDescription;

    @OneToOne
    @JoinColumn(name = "cooking_steps_id", referencedColumnName = "id")
    private Meal meal;

    public CookingSteps() {

    }

    public CookingSteps(Integer stepNumber, String stepTitle,
                        String stepDescription) {
        this.stepNumber = stepNumber;
        this.stepTitle = stepTitle;
        this.stepDescription = stepDescription;
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

