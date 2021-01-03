package com.yummyyum.Controllers;

import com.yummyyum.Model.MealCategory;
import com.yummyyum.Services.MealCategory.MealCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MealCategoryController {

    private final MealCategoryService mealCategoryService;

    public MealCategoryController(MealCategoryService mealCategoryService) {
        this.mealCategoryService = mealCategoryService;

    }

    @GetMapping("/meal-category")
    public List<MealCategory> getAllAllMealCategories() {
        return mealCategoryService.getAllMealCategories();
    }


    @GetMapping("/meal-category/category/{category}")
    public Optional<MealCategory> findMealCategoryByCategory(@PathVariable String category) {
        return mealCategoryService.findMealCategoryByCategory(category);
    }

    @PostMapping("/meal-category")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealCategory createNewMealCategory(@RequestBody MealCategory mealCategory,
                                              HttpServletResponse response,
                                              UriComponentsBuilder builder) {

        MealCategory mealCategory1 = mealCategoryService.createNewMealCategory(mealCategory.getCategory());

        response.setHeader("Location", builder.path("/api/meal-category/" + mealCategory.getId()).
                buildAndExpand(mealCategory1.getId()).toUriString());

        return mealCategory1;
    }
}
