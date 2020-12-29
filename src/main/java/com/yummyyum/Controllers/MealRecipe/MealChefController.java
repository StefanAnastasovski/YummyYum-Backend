package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealChef;
import com.yummyyum.Services.MealRecipe.MealChef.MealChefService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MealChefController {

    private final MealChefService mealChefService;

    public MealChefController(MealChefService mealChefService) {
        this.mealChefService = mealChefService;

    }

    @GetMapping("/meal-chef")
    public List<MealChef> getAllMealChefs() {
        return mealChefService.getAllMealChefs();
    }

    @GetMapping("/meal-chef/meal/{mealName}")
    public Optional<MealChef> findMealChefByMealName(@PathVariable("mealName") String mealName) {
        return mealChefService.findMealChefByMealName(mealName);
    }

    @PostMapping("/meal-chef")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealChef createNewMealChef(@RequestBody MealChef mealChef,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        MealChef mealChef1 = mealChefService.createNewMealChef(mealChef.getFullName(),
                mealChef.getChefMealDescription(), mealChef.getMeal());


        response.setHeader("Location", builder.path("/api/meal-chef/" + mealChef.getId()).
                buildAndExpand(mealChef1.getId()).toUriString());

        return mealChef1;
    }
}
