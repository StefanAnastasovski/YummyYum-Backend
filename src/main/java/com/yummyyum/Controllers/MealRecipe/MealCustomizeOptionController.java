package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.DTO.RecipeComponents.CustomizeOptionsDTO;
import com.yummyyum.Model.MealRecipe.MealCustomizeOption;
import com.yummyyum.Services.MealRecipe.MealCustomizeOption.MealCustomizeOptionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MealCustomizeOptionController {

    private final MealCustomizeOptionService mealCustomizeOptionService;

    public MealCustomizeOptionController(MealCustomizeOptionService mealCustomizeOptionService) {
        this.mealCustomizeOptionService = mealCustomizeOptionService;
    }


    @GetMapping("/meal-customize-option/meal/{mealName}")
    public List<MealCustomizeOption> getAllMealCustomizeOptionsByMeal(@PathVariable("mealName") String mealName) {
        return mealCustomizeOptionService.getAllMealCustomizeOptionsByMeal(mealName);
    }

    @PostMapping("/meal-customize-option")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<MealCustomizeOption> createNewMealCustomizeOption(@RequestBody CustomizeOptionsDTO mealCustomizeOption,
                                                            HttpServletResponse response,
                                                            UriComponentsBuilder builder) {

        return mealCustomizeOptionService.createNewMealCustomizeOption(mealCustomizeOption.getMealCustomizeOptions(),
                mealCustomizeOption.getMealName());

    }

}
