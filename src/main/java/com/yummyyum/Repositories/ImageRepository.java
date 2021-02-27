package com.yummyyum.Repositories;

import com.yummyyum.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ImageRepository extends JpaRepository<Image, Long> {


    @Query(value = "SELECT * FROM image AS i JOIN meal m ON m.id = i.image_id " +
            "WHERE m.meal_name = :mealName " +
            "AND i.is_chef_img = FALSE " +
            "AND i.is_main_recipe_img = FALSE",
            nativeQuery = true)
    List<Image> getImagesByMealName(String mealName);

    @Query(value = "SELECT * FROM image AS i JOIN meal m ON m.id = i.image_id " +
            "WHERE m.meal_name = :mealName " +
            "AND i.is_main_recipe_img=FALSE " +
            "AND i.is_chef_img=TRUE ",
            nativeQuery = true)
    Optional<Image> getImageByMealNameAndIsChefImgTrue(String mealName);

    @Query(value = "SELECT * FROM image AS i JOIN meal m ON m.id = i.image_id " +
            "WHERE m.meal_name = :mealName " +
            "AND i.is_main_recipe_img=TRUE " +
            "AND i.is_chef_img=FALSE ",
            nativeQuery = true)
    Optional<Image> getImageByMealNameAndIsMainRecipeImgTrue(String mealName);
}
