package com.yummyyum.Model.MealRecipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yummyyum.Model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "meal_customize_option")
@Getter
@Setter
@AllArgsConstructor
public class MealCustomizeOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "meal_customize_option")
    private String mealCustomizeOption;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "meal_customize_option_id")
    private Meal meal;

    public MealCustomizeOption() {
    }

    public MealCustomizeOption(String mealCustomizeOption) {
        this.mealCustomizeOption = mealCustomizeOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealCustomizeOption that = (MealCustomizeOption) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

