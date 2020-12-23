package com.yummyyum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "category_code")
    private String categoryCode;

    public MealCategory() {
    }

    public MealCategory(String category, String categoryCode) {
        this.category = category;
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "MealCategory{" +
                "category='" + category + '\'' +
                ", category_code='" + categoryCode + '\'' +
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

