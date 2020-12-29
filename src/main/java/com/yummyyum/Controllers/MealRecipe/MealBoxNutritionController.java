package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealBoxNutrition;
import com.yummyyum.Services.MealRecipe.MealBoxNutrition.MealBoxNutritionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MealBoxNutritionController {

    private final MealBoxNutritionService mealBoxNutritionService;

    public MealBoxNutritionController(MealBoxNutritionService mealBoxNutritionService) {
        this.mealBoxNutritionService = mealBoxNutritionService;

    }

    @GetMapping("/meal-box-nutrition")
    public List<MealBoxNutrition> getAllMealBoxNutritiones() {
        return mealBoxNutritionService.getAllMealBoxNutritions();
    }

    @GetMapping("/meal-box-nutrition/meal/{mealName}")
    public Optional<MealBoxNutrition> findMealBoxNutritionByMealName(@PathVariable("mealName") String mealName) {
        return mealBoxNutritionService.findMealBoxNutritionByMealName(mealName);
    }

    @PostMapping("/meal-box-nutrition")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealBoxNutrition createNewMealBoxNutrition(@RequestBody MealBoxNutrition mealBoxNutrition,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        MealBoxNutrition mealBoxNutrition1 = mealBoxNutritionService.createNewMealBoxNutrition(mealBoxNutrition.getCalories(),
                mealBoxNutrition.getProtein(), mealBoxNutrition.getCarbohydrates(),
                mealBoxNutrition.getFat(), mealBoxNutrition.getMeal());

        response.setHeader("Location", builder.path("/api/meal-box-nutrition/" + mealBoxNutrition.getId()).
                buildAndExpand(mealBoxNutrition1.getId()).toUriString());

        return mealBoxNutrition1;
    }
}

