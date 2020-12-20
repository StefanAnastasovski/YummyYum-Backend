package com.yummyyum.Model.MealRecipe;

import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "meal_overview")
@Getter
@Setter
@AllArgsConstructor
public class MealOverview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "difficulty_level")
    @Enumerated(EnumType.STRING)
    private DifficultyLevelEnum difficultyLevel;

    @Column(name = "spice_level")
     @Enumerated(EnumType.STRING)
    private SpiceLevelEnum spiceLevel;

    @Column(name = "prep_cook_time")
    private String prepCookTime;

    @Column(name = "CookWithin")
    private Integer cookWithin;

    @Column(name = "meal_name_fk")
    private String mealName;


    public MealOverview() {

    }

    public MealOverview(DifficultyLevelEnum difficultyLevel, SpiceLevelEnum spiceLevel,
                        String prepCookTime, Integer cookWithin, String mealName) {
        this.difficultyLevel = difficultyLevel;
        this.spiceLevel = spiceLevel;
        this.prepCookTime = prepCookTime;
        this.cookWithin = cookWithin;
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "MealOverview{" +
                "difficultyLevel=" + difficultyLevel +
                ", spiceLevel=" + spiceLevel +
                ", prepCookTime='" + prepCookTime + '\'' +
                ", cookWithin=" + cookWithin +
                ", mealName=" + mealName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealOverview meal = (MealOverview) o;
        return id != null ? id.equals(meal.id) : meal.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
