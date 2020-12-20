package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealOverview;

import com.yummyyum.Services.MealRecipe.MealOverview.MealOverviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MealOverviewController {

    private final MealOverviewService mealOverviewService;

    public MealOverviewController(MealOverviewService mealOverviewService) {
        this.mealOverviewService = mealOverviewService;

    }

    @GetMapping("/getallmealoverviews")
    public List<MealOverview> getAllMealOverviews() {
        return mealOverviewService.getAllMealOverviews();
    }

    @GetMapping("/getmealoverviewbymealname/{mealName}")
    public Optional<MealOverview> getMealOverviewByMealName(@PathVariable String mealName) {
        return mealOverviewService.getMealOverviewByMealName(mealName);
    }

    @PostMapping("/createmealoverview")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealOverview createNewMealOverview(@RequestBody MealOverview mealOverview,
                                              HttpServletResponse response,
                                              UriComponentsBuilder builder) {

        MealOverview mealOverview1 = mealOverviewService.createNewMealOverview(mealOverview.getDifficultyLevel(),
                mealOverview.getSpiceLevel(), mealOverview.getPrepCookTime(),
                mealOverview.getCookWithin(), mealOverview.getMealName());


        response.setHeader("Location", builder.path("/api/createmealoverview/" + mealOverview.getId()).
                buildAndExpand(mealOverview1.getId()).toUriString());

        return mealOverview1;
    }
}
