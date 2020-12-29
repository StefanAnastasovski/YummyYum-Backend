package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.RecipeSteps;
import com.yummyyum.Services.MealRecipe.RecipeSteps.RecipeStepsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class RecipeStepsController {

    private final RecipeStepsService recipeStepsService;

    public RecipeStepsController(RecipeStepsService recipeStepsService) {
        this.recipeStepsService = recipeStepsService;

    }

    @GetMapping("/recipe-steps")
    public List<RecipeSteps> getAllRecipeSteps() {
        return recipeStepsService.getAllRecipeSteps();
    }

    @GetMapping("/recipe-steps/meal/{mealName}")
    public Optional<RecipeSteps> findRecipeStepsByMealName(@PathVariable("mealName") String mealName) {
        return recipeStepsService.findRecipeStepsByMealName(mealName);
    }

    @PostMapping("/recipe-steps")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RecipeSteps createNewRecipeSteps(@RequestBody RecipeSteps recipeSteps,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        RecipeSteps recipeSteps1 = recipeStepsService.createNewRecipeSteps(recipeSteps.getMealUtensilsRow1(),
                recipeSteps.getMealUtensilsRow2(), recipeSteps.getMeal());
        response.setHeader("Location", builder.path("/api/recipe-steps/" + recipeSteps.getId()).
                buildAndExpand(recipeSteps1.getId()).toUriString());

        return recipeSteps1;
    }
}
