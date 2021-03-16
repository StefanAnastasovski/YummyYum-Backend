package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.ImageDTO;
import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import com.yummyyum.Services.Image.ImageService;
import com.yummyyum.Services.Meal.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ImageController {

    private final ImageService imageService;
    private final MealService mealService;

    public ImageController(ImageService imageService,
                           MealService mealService) {
        this.imageService = imageService;
        this.mealService = mealService;
    }

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/images/meal-name/{mealname}")
    public List<Image> getImagesByMealName(@PathVariable("mealname") String mealName) {
        return imageService.getImagesByMealName(mealName);
    }

    @GetMapping("/images/meal-name/{mealname}/chef-img")
    public Optional<Image> getImageByMealNameAndIsChefImgTrue(@PathVariable("mealname") String mealName) {
        return imageService.getImageByMealNameAndIsChefImgTrue(mealName);
    }

    @GetMapping("/images/meal-name/{mealname}/main-recipe-img")
    public Optional<Image> getImageByMealNameAndIsMainRecipeImgTrue(@PathVariable("mealname") String mealName) {
        return imageService.getImageByMealNameAndIsMainRecipeImgTrue(mealName);
    }


    @PostMapping("/images")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Image createNewImage(@RequestBody ImageDTO imageDTO,
                                HttpServletResponse response,
                                UriComponentsBuilder builder) {

        Image image1 = imageService.createNewImage(imageDTO.getUrl(), imageDTO.getAlt(),
                imageDTO.getIsChefImg(),
                imageDTO.getIsMainRecipeImg(),imageDTO.getCookingStep(), imageDTO.getMeal());

        response.setHeader("Location", builder.path("/api/images/" + image1.getId()).
                buildAndExpand(image1.getId()).toUriString());

        return image1;
    }

}
