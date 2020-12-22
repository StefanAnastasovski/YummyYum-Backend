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

    @GetMapping("/getallrecipesteps")
    public List<RecipeSteps> getAllRecipeSteps() {
        return recipeStepsService.getAllRecipeSteps();
    }

    @GetMapping("/getrecipestepsbymealname/{mealName}")
    public Optional<RecipeSteps> getRecipeStepsByMealName(@PathVariable String mealName) {
        return recipeStepsService.getRecipeStepsByMealName(mealName);
    }

    @PostMapping("/createrecipesteps")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RecipeSteps createNewRecipeSteps(@RequestBody RecipeSteps recipeSteps,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        RecipeSteps recipeSteps1 = recipeStepsService.createNewRecipeSteps(recipeSteps.getMealUtensilsRow1(),
                recipeSteps.getMealUtensilsRow2(), recipeSteps.getMealName());
        response.setHeader("Location", builder.path("/api/createrecipesteps/" + recipeSteps.getId()).
                buildAndExpand(recipeSteps1.getId()).toUriString());

        return recipeSteps1;
    }
}
