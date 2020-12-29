package com.yummyyum.Model.MealRecipe;

import com.yummyyum.Model.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "meal_chef")
@Getter
@Setter
@AllArgsConstructor
public class MealChef {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "chef_meal_description")
    @Lob
    private String chefMealDescription;

    @OneToOne
    @JoinColumn(name = "meal_chef_id", referencedColumnName = "id")
    private Meal meal;

    public MealChef() {

    }

    public MealChef(String fullName, String chefMealDescription) {
        this.fullName = fullName;
        this.chefMealDescription = chefMealDescription;
    }

    @Override
    public String toString() {
        return "MealChef{" +
                "fullName='" + fullName + '\'' +
                ", chefMealDescription='" + chefMealDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealChef mealChef = (MealChef) o;

        return id != null ? id.equals(mealChef.id) : mealChef.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

