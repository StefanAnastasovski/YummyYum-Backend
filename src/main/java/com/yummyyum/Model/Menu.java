package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "meal_name_fk")
    private String mealName;

    @Column(name = "meal_category_fk")
    private String mealCategory;

    @Column(name = "menu_name")
    private String menuName;

    public Menu() {
    }

    public Menu(Date releaseDate, String mealName, String mealCategory, String menuName) {
        this.releaseDate = releaseDate;
        this.mealName = mealName;
        this.mealCategory = mealCategory;
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "releaseDate='" + releaseDate + '\'' +
                ", mealName='" + mealName + '\'' +
                ", mealCategory='" + mealCategory + '\'' +
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

