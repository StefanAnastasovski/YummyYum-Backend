package com.yummyyum.Controllers.MealRecipe;

import com.yummyyum.Model.MealRecipe.MealBox;
import com.yummyyum.Services.MealRecipe.MealBox.MealBoxService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MealBoxController {

    private final MealBoxService mealBoxService;

    public MealBoxController(MealBoxService mealBoxService) {
        this.mealBoxService = mealBoxService;

    }

    @GetMapping("/meal-box")
    public List<MealBox> getAllMealBoxes() {
        return mealBoxService.getAllMealBoxes();
    }

    @GetMapping("/meal-box/meal/{mealName}")
    public Optional<MealBox> findMealBoxByMealName(@PathVariable("mealName") String mealName) {
        return mealBoxService.findMealBoxByMealName(mealName);
    }

    @PostMapping("/meal-box")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MealBox createNewMealBox(@RequestBody MealBox mealBox,
                                  HttpServletResponse response,
                                  UriComponentsBuilder builder) {

        MealBox mealBox1 = mealBoxService.createNewMealBox(mealBox.getServeQuantity(),
                mealBox.getMealIngredients(), mealBox.getMeal());

        response.setHeader("Location", builder.path("/api/meal-box/" + mealBox.getId()).
                buildAndExpand(mealBox1.getId()).toUriString());

        return mealBox1;
    }
}
