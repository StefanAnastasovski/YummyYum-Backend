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

    @GetMapping("/getallcategories")
    public List<MealCategory> getAllAllMealCategories() {
        return mealCategoryService.getAllMealCategories();
    }

    @GetMapping("/getcategorybycategorycode/{categorycode}")
    public Optional<MealCategory> getMealCategoryByCategoryCode(@PathVariable("categorycode") String categoryCode) {
        return mealCategoryService.getMealCategoryByCategoryCode(categoryCode);
    }

    @GetMapping("/getcategorybycategory/{category}")
    public Optional<MealCategory> getMealCategoryByCategory(@PathVariable String category) {
        return mealCategoryService.getMealCategoryByCategory(category);
    }

    @PostMapping("/createcategory")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealCategory createNewMealCategory(@RequestBody MealCategory mealCategory,
                                              HttpServletResponse response,
                                              UriComponentsBuilder builder) {

        MealCategory mealCategory1 = mealCategoryService.createNewMealCategory(
                mealCategory.getCategory(), mealCategory.getCategoryCode());

        response.setHeader("Location", builder.path("/api/createcategory/" + mealCategory.getId()).
                buildAndExpand(mealCategory1.getId()).toUriString());

        return mealCategory1;
    }
}
