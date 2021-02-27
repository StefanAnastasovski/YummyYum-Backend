package com.yummyyum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "image")
@Getter
@Setter
@AllArgsConstructor
public class Image {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Lob
    private String url;

    @Column
    @Lob
    private String alt;

    @Column(name = "is_chef_img", nullable = false)
    private Boolean isChefImg;

    @Column(name = "is_main_recipe_img", nullable = false)
    private Boolean isMainRecipeImg;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Meal meal;

    public Image() {

    }

    public Image(String url, String alt, Boolean isChefImg, Boolean isMainRecipeImg) {
        this.url = url;
        this.alt = alt;
        this.isChefImg = isChefImg;
        this.isMainRecipeImg = isMainRecipeImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return id != null ? id.equals(image.id) : image.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
