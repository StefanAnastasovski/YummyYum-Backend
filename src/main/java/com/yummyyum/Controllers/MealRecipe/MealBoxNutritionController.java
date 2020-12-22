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

    @GetMapping("/getallmealboxnutritions")
    public List<MealBoxNutrition> getAllMealBoxNutritiones() {
        return mealBoxNutritionService.getAllMealBoxNutritions();
    }

    @GetMapping("/getmealboxnutritionbymealname/{mealname}")
    public Optional<MealBoxNutrition> getMealBoxNutritionByMealName(@PathVariable String mealName) {
        return mealBoxNutritionService.getMealBoxNutritionByMealName(mealName);
    }

    @PostMapping("/createmealboxnutrition")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealBoxNutrition createNewMealBoxNutrition(@RequestBody MealBoxNutrition mealBoxNutrition,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        MealBoxNutrition mealBoxNutrition1 = mealBoxNutritionService.createNewMealBoxNutrition(mealBoxNutrition.getCalories(),
                mealBoxNutrition.getProtein(), mealBoxNutrition.getCarbohydrates(),
                mealBoxNutrition.getFat(), mealBoxNutrition.getMealName());

        response.setHeader("Location", builder.path("/api/createmealboxnutrition/" + mealBoxNutrition.getId()).
                buildAndExpand(mealBoxNutrition1.getId()).toUriString());

        return mealBoxNutrition1;
    }
}

