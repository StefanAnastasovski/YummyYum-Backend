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

    @GetMapping("/getallmealchefs")
    public List<MealChef> getAllMealChefs() {
        return mealChefService.getAllMealChefs();
    }

    @GetMapping("/getmealchefbymealname/{mealName}")
    public Optional<MealChef> getMealChefByMealName(@PathVariable String mealName) {
        return mealChefService.getMealChefByMealName(mealName);
    }

    @PostMapping("/createmealchef")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealChef createNewMealChef(@RequestBody MealChef mealChef,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        MealChef mealChef1 = mealChefService.createNewMealChef(mealChef.getFullName(), mealChef.getChefMealDescription(), mealChef.getMealName());

        response.setHeader("Location", builder.path("/api/createmealchef/" + mealChef.getId()).
                buildAndExpand(mealChef1.getId()).toUriString());

        return mealChef1;
    }
}
