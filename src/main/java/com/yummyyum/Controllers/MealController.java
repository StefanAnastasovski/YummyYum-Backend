package com.yummyyum.Controllers;


import com.yummyyum.Model.Meal;
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
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/meals/meal/{mealname}")
    public Optional<Meal> getMealByMealName(@PathVariable("mealname") String mealName) {
        return mealService.getMealByMealName(mealName);
    }

    @GetMapping("/meals/category/{category}")
    public List<Meal> getMealsByMealCategory(@PathVariable("category") String category) {
        return mealService.getMealsByMealCategory(category);
    }

    @PostMapping("/meals")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Meal createNewMeal(@RequestBody Meal meal,
                              HttpServletResponse response,
                              UriComponentsBuilder builder) {

        Meal meal1 = mealService.createNewMeal(meal.getMealName(), meal.getMealDescription(),
                meal.getMealTimeTag(), meal.getMealIngredientTag(),
                meal.getPrice(), meal.getMealCategory());

        response.setHeader("Location", builder.path("/api/meals/" + meal.getId()).
                buildAndExpand(meal1.getId()).toUriString());

        return meal1;
    }

}
