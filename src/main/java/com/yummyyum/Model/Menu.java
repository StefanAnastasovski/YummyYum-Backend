package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity(name = "menu")
@Getter
@Setter
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @Column(name = "menu_name", unique = true)
    private String menuName;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "menu_meal_category",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_category_id"))
    private List<MealCategory> mealCategories = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "menu_meal",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> meals = new ArrayList<>();


    public void addMealCategory(MealCategory mealCategory) {
        this.mealCategories.add(mealCategory);
        mealCategory.getMenus().add(this);
    }

    public void addMeal(Meal Meal) {
        this.meals.add(Meal);
        Meal.getMenus().add(this);
    }

    public Menu() {
    }

    public Menu(Date releaseDate, String menuName) {
        this.releaseDate = releaseDate;
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "releaseDate='" + releaseDate + '\'' +
                ", menuName='" + menuName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return id != null ? id.equals(menu.id) : menu.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

