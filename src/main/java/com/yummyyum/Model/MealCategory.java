package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "meal_category")
@Getter
@Setter
@AllArgsConstructor
public class MealCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category")
    private String category;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "meal_category_id")
    private Set<Meal> meals;

    public MealCategory() {
    }

    public MealCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "MealCategory{" +
                "category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealCategory mealCategory = (MealCategory) o;

        return id != null ? id.equals(mealCategory.id) : mealCategory.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

