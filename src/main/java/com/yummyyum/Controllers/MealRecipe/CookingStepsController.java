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

    @GetMapping("/getallcookingsteps")
    public List<CookingSteps> getAllCookingSteps() {
        return cookingStepsService.getAllCookingSteps();
    }

    @GetMapping("/getcookingstepsbymealname/{mealname}")
    public Optional<CookingSteps> getCookingStepsByMealName(@PathVariable String mealName) {
        return cookingStepsService.getCookingStepsByMealName(mealName);
    }

    @PostMapping("/createcookingsteps")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CookingSteps createNewCookingSteps(@RequestBody CookingSteps cookingSteps,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        CookingSteps cookingSteps1 = cookingStepsService.createNewCookingSteps(cookingSteps.getStepTitle(),
                cookingSteps.getStepDescription(), cookingSteps.getImageUrls(), cookingSteps.getMealName());

        response.setHeader("Location", builder.path("/api/createcookingsteps/" + cookingSteps.getId()).
                buildAndExpand(cookingSteps1.getId()).toUriString());

        return cookingSteps1;
    }
}

