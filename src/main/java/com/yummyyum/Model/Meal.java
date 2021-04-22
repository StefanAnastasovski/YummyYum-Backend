package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yummyyum.Model.MealRecipe.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "meal")
@Getter
@Setter
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "meal_name", unique = true)
    private String mealName;

    @Column(name = "meal_description")
    private String mealDescription;

    @Column(name = "meal_time_tag")
    private String mealTimeTag;

    @Column(name = "meal_ingredient_tag")
    private String mealIngredientTag;

    @Column
    private Double price;

    //Meal Recipe RSs
    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private MealOverview mealOverview;

    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private MealChef mealChef;

    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private MealBox mealBox;

    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private MealBoxNutrition mealBoxNutrition;

    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private RecipeSteps recipeSteps;

    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private RecipeInstructions recipeInstructions;

    @JsonIgnore
    @OneToOne(mappedBy = "meal")
    private CookingSteps cookingSteps;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "meal_customize_option_id")
    private List<MealCustomizeOption> mealCustomizeOption;

    //Meal Category RS

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "meal_category_id", nullable = true)
    private MealCategory mealCategory;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "image_id")
    private List<Image> images;

    @ManyToMany(mappedBy = "meals")
    @JsonIgnore
    private List<Menu> menus = new ArrayList<>();

    public Meal() {

    }

    public Meal(String mealName, String mealDescription, String mealTimeTag, String mealIngredientTag, Double price) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealTimeTag = mealTimeTag;
        this.mealIngredientTag = mealIngredientTag;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealDescription='" + mealDescription + '\'' +
                ", mealTimeTag='" + mealTimeTag + '\'' +
                ", mealIngredientTag='" + mealIngredientTag + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return id != null ? id.equals(meal.id) : meal.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
