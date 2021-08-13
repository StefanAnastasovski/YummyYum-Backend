package com.yummyyum.Controllers;

import com.yummyyum.Model.DTO.*;
import com.yummyyum.Model.DTO.RecipeComponents.MealBoxNutritionDTO;
import com.yummyyum.Model.DTO.RecipeComponents.MealCustomizeOptionDTO;
import com.yummyyum.Model.Image;
import com.yummyyum.Model.Meal;
import com.yummyyum.Model.MealCategory;
import com.yummyyum.Model.MealRecipe.MealBoxNutrition;
import com.yummyyum.Model.MealRecipe.MealCustomizeOption;
import com.yummyyum.Model.Menu;
import com.yummyyum.Repositories.ImageRepository;
import com.yummyyum.Repositories.MealRecipe.MealBoxNutritionRepository;
import com.yummyyum.Repositories.MealRecipe.MealCustomizeOptionRepository;
import com.yummyyum.Repositories.MenuRepository;
import com.yummyyum.Services.Meal.MealService;
import com.yummyyum.Services.MealCategory.MealCategoryService;
import com.yummyyum.Services.Menu.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class MenuController {

    private final MenuService menuService;
    private final MealCategoryService mealCategoryService;
    private final MealService mealService;
    private final MenuRepository menuRepository;
    private final ImageRepository imageRepository;
    private final MealCustomizeOptionRepository mealCustomizeOptionRepository;
    private final MealBoxNutritionRepository mealBoxNutritionRepository;

    public MenuController(MenuService menuService, MealCategoryService mealCategoryService,
                          MealService mealService, MenuRepository menuRepository, ImageRepository imageRepository,
                          MealCustomizeOptionRepository mealCustomizeOptionRepository, MealBoxNutritionRepository mealBoxNutritionRepository) {
        this.menuService = menuService;
        this.mealCategoryService = mealCategoryService;
        this.mealService = mealService;
        this.menuRepository = menuRepository;
        this.imageRepository = imageRepository;
        this.mealCustomizeOptionRepository = mealCustomizeOptionRepository;
        this.mealBoxNutritionRepository = mealBoxNutritionRepository;
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @PostMapping("/menus")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MenuDTO createNewMenu(@RequestBody Menu menu,
                                 HttpServletResponse response,
                                 UriComponentsBuilder builder) {

        Menu menu1 = menuService.createNewMenu(menu.getReleaseDate(), menu.getMenuName());

        List<MealCategory> mealCategories = mealCategoryService.getAllMealCategories();

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setMenuName(menu1.getMenuName());
        menuDTO.setReleaseDate(menu1.getReleaseDate());

        int i;
        int numberOfMealsToAdd = 9;
        int mealsArraySize;
        int randomInt;
        int n = mealCategories.size();

        Random random = new Random();

        String mealCategoryName;

        List<Meal> meals;
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        List<Meal> mealsDTO = new ArrayList<>();
        ArrayList<Meal>[] mealList = new ArrayList[n];

        // initializing
        for (i = 0; i < n; i++) {
            mealList[i] = new ArrayList<Meal>();
        }

        for (i = 0; i < mealCategories.size(); i++) {

            CategoryDTO categoryDTO = new CategoryDTO();

            mealCategoryName = mealCategories.get(i).getCategory();
            menu1.addMealCategory(mealCategories.get(i));
            categoryDTO.setCategory(menu1.getMealCategories().get(0).getCategory());

            meals = mealService.getMealsByMealCategory(mealCategoryName);

            for (int j = 0; j < numberOfMealsToAdd; j++) {

                mealsArraySize = meals.size();
                randomInt = random.nextInt(mealsArraySize);
                mealList[i].add(meals.get(randomInt));
                meals.remove(randomInt);

            }

            categoryDTO.setMeals(mealList[i]);
            categoryDTOs.add(categoryDTO);

        }

        for (i = 0; i < mealList.length; i++) {
            mealsDTO.addAll(mealList[i]);
        }

        menu1.setMeals(mealsDTO);

        menuDTO.setMealCategories(categoryDTOs);

        menuRepository.save(menu1);

        return menuDTO;
    }

    @PostMapping("/menu-mealcategory")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Menu processAddCategories(@RequestBody MenuCategoryDTO menuCategoryDTO,
                                     Errors errors,
                                     HttpServletResponse response,
                                     UriComponentsBuilder builder) {

        Menu menu = menuCategoryDTO.getMenu();
        Optional<MealCategory> mealCategory =
                mealCategoryService.findMealCategoryByCategory(menuCategoryDTO.getMealCategory().getCategory());

        if (!(menu.getMealCategories().contains(mealCategory))) {
            menu.addMealCategory(mealCategory.get());
            menuRepository.save(menu);
        }


        return menu;

    }

    @GetMapping("/menus/menu-name/{menuName}")
    public MenuDTO2 getMenuByMenuName(@PathVariable("menuName") String menuName) {

        Optional<Menu> menu1 = menuService.getMenuByMenuName(menuName);
        List<Meal> allMeals = menu1.get().getMeals();

        String mealCategory;
        int n = menu1.get().getMealCategories().size() + 1;

        MenuDTO2 menuDTO = new MenuDTO2();
        menuDTO.setMenuName(menu1.get().getMenuName());
        menuDTO.setReleaseDate(menu1.get().getReleaseDate());

        List<CategoryDTO2> categoryDTOs = new ArrayList<>();

        ArrayList<MealDTO>[] mealList1 = new ArrayList[n];
        List<MealDTO> mealListTemp = new ArrayList<>();

        // initializing
        for (int i = 0; i < n; i++) {
            mealList1[i] = new ArrayList<MealDTO>();
        }


        for (int i = 0; i < n - 1; i++) {

            CategoryDTO2 categoryDTO = new CategoryDTO2();
            mealCategory = menu1.get().getMealCategories().get(i).getCategory();
            categoryDTO.setCategory(mealCategory);

            for (Meal allMeal : allMeals) {
                MealDTO meal = new MealDTO();
                Optional<Image> image = imageRepository.getImageByMealNameAndIsMainRecipeImgTrue(allMeal.getMealName());
                List<MealCustomizeOption> mealCustomizeOptions = mealCustomizeOptionRepository.getMealCustomizeOptionByMealName(allMeal.getMealName());
                List<MealCustomizeOptionDTO> mealCustomizeOptionsTemp = new ArrayList<>();
                for (MealCustomizeOption customizeOption : mealCustomizeOptions) {
                    MealCustomizeOptionDTO temp = new MealCustomizeOptionDTO(customizeOption.getMealCustomizeOption());
                    mealCustomizeOptionsTemp.add(temp);
                }
                meal.setMealName(allMeal.getMealName());
                meal.setMealCategory(allMeal.getMealCategory());
                meal.setMealDescription(allMeal.getMealDescription());
                meal.setMealIngredientTag(allMeal.getMealIngredientTag());
                meal.setMealTimeTag(allMeal.getMealTimeTag());
                meal.setPrice(allMeal.getPrice());

                if (image.isPresent()) {
                    meal.setImage(image.get());
                }
                meal.setMealCustomizeOptions(mealCustomizeOptionsTemp);
                if (allMeal.getMealCategory().getCategory().equals(mealCategory)) {
                    mealList1[i].add(meal);
                }
            }

            categoryDTO.setMeals(mealList1[i]);
            categoryDTOs.add(categoryDTO);

        }

        Random randomNumberToGetOnlyOneMealFromMealCategory = new Random();
        int randomInt = randomNumberToGetOnlyOneMealFromMealCategory.nextInt(2);

        Random randomNUmberToGetAMeal = new Random();
        int randomMealInt;

        int previousMealIndex = 9999;

        CategoryDTO2 tempCategoryDTO2 = new CategoryDTO2();
        MealDTO meal = new MealDTO();
        for (int j = 0; j < 5; j++) {

            tempCategoryDTO2.setCategory("Mix");

            if (j != randomInt) {

                for (int q = 0; q < 2; q++) {

                    randomMealInt = randomNUmberToGetAMeal.nextInt(9);
                    if (previousMealIndex == randomMealInt) {
                        q--;
                        continue;
                    } else {
                        previousMealIndex = randomMealInt;
                    }

                    meal = mealList1[j].get(randomMealInt);
                    mealListTemp.add(meal);

                }

            } else {
                meal = mealList1[j].get(randomInt);
                mealListTemp.add(meal);
            }


        }

        tempCategoryDTO2.setMeals(mealListTemp);
        categoryDTOs.add(0, tempCategoryDTO2);

        menuDTO.setMealCategories(categoryDTOs);


        return menuDTO;
    }


    @GetMapping("/menus/menu-name/{menuName}/meal-nutrition")
    public MenuNutritionDTO getMenuAndMealNutritionByMenuName(@PathVariable("menuName") String menuName) {

        Optional<Menu> menu1 = menuService.getMenuByMenuName(menuName);
        List<Meal> allMeals = menu1.get().getMeals();

        String mealCategory;
        int n = menu1.get().getMealCategories().size() + 1;

        MenuNutritionDTO menuDTO = new MenuNutritionDTO();
        menuDTO.setMenuName(menu1.get().getMenuName());
        menuDTO.setReleaseDate(menu1.get().getReleaseDate());

        List<CategoryMealsNutritionDTO> categoryDTOs = new ArrayList<>();

        ArrayList<MealImageCategoryCustomizeOptionNutritionDTO>[] mealList1 = new ArrayList[n];
        List<MealImageCategoryCustomizeOptionNutritionDTO> mealListTemp = new ArrayList<>();

        // initializing
        for (int i = 0; i < n; i++) {
            mealList1[i] = new ArrayList<MealImageCategoryCustomizeOptionNutritionDTO>();
        }


        for (int i = 0; i < n - 1; i++) {

            CategoryMealsNutritionDTO categoryDTO = new CategoryMealsNutritionDTO();
            mealCategory = menu1.get().getMealCategories().get(i).getCategory();
            categoryDTO.setCategory(mealCategory);

            for (Meal allMeal : allMeals) {
                MealImageCategoryCustomizeOptionNutritionDTO meal = new MealImageCategoryCustomizeOptionNutritionDTO();
                Optional<Image> image = imageRepository.getImageByMealNameAndIsMainRecipeImgTrue(allMeal.getMealName());
                Optional<MealBoxNutrition> mealBoxNutrition = mealBoxNutritionRepository.findMealBoxNutritionByMealName(allMeal.getMealName());
                List<MealCustomizeOption> mealCustomizeOptions = mealCustomizeOptionRepository.getMealCustomizeOptionByMealName(allMeal.getMealName());
                List<MealCustomizeOptionDTO> mealCustomizeOptionsTemp = new ArrayList<>();
                for (MealCustomizeOption customizeOption : mealCustomizeOptions) {
                    MealCustomizeOptionDTO temp = new MealCustomizeOptionDTO(customizeOption.getMealCustomizeOption());
                    mealCustomizeOptionsTemp.add(temp);
                }

                MealBoxNutritionDTO mealBoxNutritionDTO = new MealBoxNutritionDTO(mealBoxNutrition.get().getCalories(),
                        mealBoxNutrition.get().getProtein(),
                        mealBoxNutrition.get().getCarbohydrates(),
                        mealBoxNutrition.get().getFat());
                meal.setMealName(allMeal.getMealName());
                meal.setMealCategory(allMeal.getMealCategory());
                meal.setMealDescription(allMeal.getMealDescription());
                meal.setMealIngredientTag(allMeal.getMealIngredientTag());
                meal.setMealTimeTag(allMeal.getMealTimeTag());
                meal.setPrice(allMeal.getPrice());
                meal.setMealBoxNutrition(mealBoxNutritionDTO);

                if (image.isPresent()) {
                    meal.setImage(image.get());
                }
                meal.setMealCustomizeOptions(mealCustomizeOptionsTemp);
                if (allMeal.getMealCategory().getCategory().equals(mealCategory)) {
                    mealList1[i].add(meal);
                }
            }

            categoryDTO.setMeals(mealList1[i]);
            categoryDTOs.add(categoryDTO);

        }

        Random randomNumberToGetOnlyOneMealFromMealCategory = new Random();
        int randomInt = randomNumberToGetOnlyOneMealFromMealCategory.nextInt(2);

        Random randomNUmberToGetAMeal = new Random();
        int randomMealInt;

        int previousMealIndex = 9999;

        CategoryMealsNutritionDTO tempCategoryMealsNutritionDTO = new CategoryMealsNutritionDTO();
        MealImageCategoryCustomizeOptionNutritionDTO meal = new MealImageCategoryCustomizeOptionNutritionDTO();
        for (int j = 0; j < 5; j++) {

            tempCategoryMealsNutritionDTO.setCategory("Mix");

            if (j != randomInt) {

                for (int q = 0; q < 2; q++) {

                    randomMealInt = randomNUmberToGetAMeal.nextInt(9);
                    if (previousMealIndex == randomMealInt) {
                        q--;
                        continue;
                    } else {
                        previousMealIndex = randomMealInt;
                    }

                    meal = mealList1[j].get(randomMealInt);
                    mealListTemp.add(meal);

                }

            } else {
                meal = mealList1[j].get(randomInt);
                mealListTemp.add(meal);
            }


        }

        tempCategoryMealsNutritionDTO.setMeals(mealListTemp);
        categoryDTOs.add(0, tempCategoryMealsNutritionDTO);

        menuDTO.setMealCategories(categoryDTOs);


        return menuDTO;
    }

}
