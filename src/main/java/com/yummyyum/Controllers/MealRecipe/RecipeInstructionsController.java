package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.RecipeInstructions;
import com.yummyyum.Services.MealRecipe.RecipeInstructions.RecipeInstructionsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class RecipeInstructionsController {

    private final RecipeInstructionsService recipeInstructionsService;

    public RecipeInstructionsController(RecipeInstructionsService recipeInstructionsService) {
        this.recipeInstructionsService = recipeInstructionsService;

    }

    @GetMapping("/recipe-instructions")
    public List<RecipeInstructions> getAllRecipeInstructionse() {
        return recipeInstructionsService.getAllRecipeInstructions();
    }

    @GetMapping("/recipe-instructions/meal/{mealName}")
    public Optional<RecipeInstructions> findRecipeInstructionsByMealName(@PathVariable("mealName") String mealName) {
        return recipeInstructionsService.findRecipeInstructionsByMealName(mealName);
    }

    @PostMapping("/recipe-instructions")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RecipeInstructions createNewRecipeInstructions(@RequestBody RecipeInstructions recipeInstructions,
                                                          HttpServletResponse response,
                                                          UriComponentsBuilder builder) {

        RecipeInstructions recipeInstructions1 =
                recipeInstructionsService.createNewRecipeInstructions(recipeInstructions.getCookSteps(),
                        recipeInstructions.getGuidelines(), recipeInstructions.getCustomizeInstructions(),
                        recipeInstructions.getMeal());

        response.setHeader("Location", builder.path("/api/recipe-instructions/" + recipeInstructions.getId()).
                buildAndExpand(recipeInstructions1.getId()).toUriString());

        return recipeInstructions1;
    }
}
