package com.yummyyum.Model.MealRecipe.MealRecipeEnum;

public enum PlaceOfImage {
    MC("MenuCard"),
    CS("Cooking Steps");

    private final String imgPlace;

    PlaceOfImage(String s) {
        this.imgPlace = s;
    }

    public String getImgPlace() {
        return this.imgPlace;
    }

}


//    @Column(name = "place_of_image")
//    @Enumerated(EnumType.STRING)
//    private String placeOfImage;
