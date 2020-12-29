package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.CookingSteps;
import com.yummyyum.Services.MealRecipe.CookingSteps.CookingStepsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class CookingStepsController {

    private final CookingStepsService cookingStepsService;

    public CookingStepsController(CookingStepsService cookingStepsService) {
        this.cookingStepsService = cookingStepsService;

    }

    @GetMapping("/cooking-steps")
    public List<CookingSteps> getAllCookingSteps() {
        return cookingStepsService.getAllCookingSteps();
    }

    @GetMapping("/cooking-steps/meal/{mealName}")
    public List<CookingSteps> findCookingStepsByMealName(@PathVariable("mealName") String mealName) {
        return cookingStepsService.findCookingStepsByMealName(mealName);
    }

    @PostMapping("/cooking-steps")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CookingSteps createNewCookingSteps(@RequestBody CookingSteps cookingSteps,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        CookingSteps cookingSteps1 = cookingStepsService.createNewCookingSteps(cookingSteps.getStepNumber(),
                cookingSteps.getStepTitle(), cookingSteps.getStepDescription(),
                cookingSteps.getMeal());

        response.setHeader("Location", builder.path("/api/cooking-steps/" + cookingSteps.getId()).
                buildAndExpand(cookingSteps1.getId()).toUriString());

        return cookingSteps1;
    }
}

