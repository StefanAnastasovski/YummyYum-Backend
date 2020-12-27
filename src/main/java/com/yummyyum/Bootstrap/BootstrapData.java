package com.yummyyum.Bootstrap;

import com.yummyyum.Model.*;
import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import com.yummyyum.Model.MealRecipe.*;
import com.yummyyum.Repositories.*;
import com.yummyyum.Repositories.MealRecipe.*;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final EmailRepository emailRepository;
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    private final SubscribeEmailRepository subscribeEmailRepository;
    private final MealRepository mealRepository;
    private final MealOverviewRepository mealOverviewRepository;
    private final MealChefRepository mealChefRepository;
    private final MealBoxRepository mealBoxRepository;
    private final MealBoxNutritionRepository mealBoxNutritionRepository;
    private final RecipeStepsRepository recipeStepsRepository;
    private final RecipeInstructionsRepository recipeInstructionsRepository;
    private final CookingStepsRepository cookingStepsRepository;
    private final MealCategoryRepository mealCategoryRepository;
    private final MenuRepository menuRepository;

    public BootstrapData(EmailRepository emailRepository, UserRepository userRepository, LoginRepository loginRepository,
                         SubscribeEmailRepository subscribeEmailRepository, MealRepository mealRepository,
                         MealOverviewRepository mealOverviewRepository, MealChefRepository mealChefRepository,
                         MealBoxRepository mealBoxRepository, MealBoxNutritionRepository mealBoxNutritionRepository,
                         RecipeStepsRepository recipeStepsRepository,
                         RecipeInstructionsRepository recipeInstructionsRepository,
                         CookingStepsRepository cookingStepsRepository,
                         MealCategoryRepository mealCategoryRepository, MenuRepository menuRepository) {
        this.emailRepository = emailRepository;
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
        this.subscribeEmailRepository = subscribeEmailRepository;
        this.mealRepository = mealRepository;
        this.mealOverviewRepository = mealOverviewRepository;
        this.mealChefRepository = mealChefRepository;
        this.mealBoxRepository = mealBoxRepository;
        this.mealBoxNutritionRepository = mealBoxNutritionRepository;
        this.recipeStepsRepository = recipeStepsRepository;
        this.recipeInstructionsRepository = recipeInstructionsRepository;
        this.cookingStepsRepository = cookingStepsRepository;
        this.mealCategoryRepository = mealCategoryRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//
//        Email email1 = new Email("stefanA@mail.com", true);
//        User user1 = new User("Stefan", "Annnnnnn", "Stevo",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
////        email1.setUser(user1);
////        user1.setEmail(email1);
//        emailRepository.save(email1);
//        userRepository.save(user1);

//
//         User user2 = new User("Petar", "Zdsae", "Petar",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user2);
//         User user3 = new User("Trajce", "KKease", "Trajce",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user3);
//         User user4 = new User("Mile", "LLSEsz", "Mile",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user4);
//         User user5 = new User("Bisera", "Ppeso", "Bisera",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user5);
//         User user6 = new User("Marija", "Adszews", "Marija",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user6);
//         User user7 = new User("Angela", "Iewasd", "Angela",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user7);
//
//        User user8 = new User("Stojne", "Utwhsk", "Stojne",
//                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        userRepository.save(user8);
//
//        Email email1 = new Email("stefanA@mail.com", true);
//        email1.setUser(user1);
//
//        Email email2 = new Email("Petar@mail.com", false);
//        email2.setUser(user2);
//
//        Email email3 = new Email("Trajce@mail.com", true);
//        email3.setUser(user3);
//
//        Email email4 = new Email("Mile@mail.com", false);
//        email4.setUser(user4);
//
//        Email email5 = new Email("Bisera@mail.com", true);
//        email5.setUser(user5);
//
//        Email email6 = new Email("Marija@mail.com", false);
//        email6.setUser(user6);
//
//        Email email7 = new Email("Angela@mail.com", true);
//        email7.setUser(user7);
//
//        Email email8 = new Email("Stojne@mail.com", false);
//        email8.setUser(user8);
//        emailRepository.save(email8);
//        user1.setEmail(email1);
//        userRepository.save(user1);
////        Email email2 = new Email("stefanA23@mail.com", true);
////        Email email3 = new Email("stefanA32@mail.com", true);
////        Email email4 = new Email("stefanA444@mail.com", true);
////        Email email5 = new Email("stefanA654@mail.com", false);
////        Email email6 = new Email("stefanA7777@mail.com", false);
////        Email email7 = new Email("stefanA99999@mail.com", false);
////        Email email8 = new Email("stefanA1111@mail.com", false);
//        emailRepository.saveAll(email1);
//
//        List<Email> emails = Arrays.asList(email1, email2, email3, email4, email5, email6, email7, email8);
//        emailRepository.saveAll(emails);

//        Login login1 = new Login(Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        loginRepository.save(login1);
//
//        SubscribeEmail subscribeEmail1 = new SubscribeEmail(Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
//        subscribeEmailRepository.save(subscribeEmail1);

        Meal meal1 = new Meal("Honey-Ginger Salmon", "with roasted sweet potatoes and bok choy",
                "30-40 min.", "Eggs, Fish, Soy", 6.99);
        mealRepository.save(meal1);


        MealOverview mealOverview1 = new MealOverview(DifficultyLevelEnum.ONE, SpiceLevelEnum.THREE,
                "30-40 min.", 3, "Honey-Ginger Salmon");

        mealOverviewRepository.save(mealOverview1);

        MealChef mealChef1 = new MealChef("David Roaz",
                "What do you get when you mix " +
                        "the sticky sweetness of honey with the pungent zest of ginger?" +
                        " The perfect sauce to enrobe this delicate flakey salmon. " +
                        "Second question: What do you get when you combine creamy mayonnaise with fiery Sriracha?" +
                        " The perfect sauce to drizzle over these tender sweet potatoes. Last question… combine great flavors" +
                        " and easy-to-follow recipes and what do you get? This dinner, of course. " +
                        "Tip: Having trouble cutting that wobbly sweet potato? Trim off 1/4 along" +
                        " its length and cut that section into 1/2 dice. Turn sweet potato onto its flat side. " +
                        "You now have a flat base to work from while you cut the remaining sweet potato.",
                "Honey-Ginger Salmon");

        mealChefRepository.save(mealChef1);

        MealBox mealBox1 = new MealBox(2,
                "1 tsp. Minced Ginger |" +
                        " 2 Heads of Baby Bok Choy |" +
                        " 12 oz. Salmon Fillets |" +
                        " 1 tsp. Sriracha |" +
                        " ½ fl. oz. Honey |" +
                        " 18 oz. Sweet Potato |" +
                        " 1.26 oz. Mayonnaise |" +
                        " 3 oz. Shiitake Mushrooms |" +
                        " 0.406 fl. oz. Tamari Soy Sauce", "Honey-Ginger Salmon");

        mealBoxRepository.save(mealBox1);

        MealBoxNutrition mealBoxNutrition1 = new MealBoxNutrition(842, 63,
                46, 41, "Honey-Ginger Salmon");
        mealBoxNutritionRepository.save(mealBoxNutrition1);

        RecipeSteps recipeSteps1 = new RecipeSteps("Olive Oil |" +
                " Salt  Pepper | Cooking Spray", "1 Medium Non-Stick Pan |" +
                " 1 Baking Sheet | 2 Mixing Bowls" +
                " | 1 Large Non-Stick Pan",
                "Honey-Ginger Salmon");
        recipeStepsRepository.save(recipeSteps1);

        RecipeInstructions recipeInstructions1 = new RecipeInstructions(
                "Preheat oven to 425 degrees |" +
                        " If using any fresh produce, thoroughly rinse and pat dry |" +
                        " Prepare a baking sheet with foil and cooking spray",
                "Steak and Pork 145° F (rest cooked meat, 3 minutes) |" +
                        " Seafood 145° F |" +
                        " Chicken 165° F |" +
                        " Ground Beef 160° F |" +
                        " Ground Turkey 165° F |" +
                        " Ground Pork 160° F",
                "If using chicken breasts, pat dry and season both sides with a pinch of salt and pepper." +
                        " Follow same instructions as salmon in Step 3, cooking until chicken reaches" +
                        " minimum internal temperature, 5-7 minutes per side." +
                        " | If using sirloin steaks, pat dry and season both sides with a pinch of salt and pepper." +
                        " Follow same instructions as salmon in Step 3, cooking until steak reaches minimum internal" +
                        " temperature, 4-6 minutes per side.",
                "Honey-Ginger Salmon"
        );

        recipeInstructionsRepository.save(recipeInstructions1);

//        CookingSteps cookingSteps1 = new CookingSteps(
//                "1.Roast the Sweet Potatoes | 2.Prepare the Ingredients |" +
//                        " 3.Cook the Salmon | 4.Cook the Vegetables | 5.Finish the Dish",
//                "Quarter sweet potato and cut into ½ pieces. Place sweet potato pieces on prepared" +
//                        " baking sheet and toss with 2 tsp. olive oil, ¼ tsp. salt, and ¼ tsp. pepper." +
//                        " Massage oil and seasoning into potatoes. Spread into a single layer and roast" +
//                        " in hot oven until tender, 18-20 minutes. While sweet potato roasts, prepare ingredients." +
//                        " | Remove any discolored outer leaves from bok choy and trim ends. " +
//                        "Cut stems into ½ slices and coarsely chop leaves. Stem mushrooms and cut caps into ¼ strips." +
//                        "In a mixing bowl, combine honey and ginger. Set aside. In another mixing bowl, " +
//                        "combine mayonnaise and Sriracha (to taste). Set aside. Pat salmon dry, and season " +
//                        "flesh side with a pinch of salt and pepper. | Place a medium non-stick pan over medium " +
//                        "heat and add 2 tsp. olive oil. Add salmon, skin side up, to hot pan and cook until golden " +
//                        "brown and salmon reaches a minimum internal temperature of 145 degrees, 4-6 minutes per side. " +
//                        "Remove from burner. Remove salmon to a plate and tent with foil. While salmon cooks, cook " +
//                        "vegetables. | Place a large non-stick pan over medium-high heat and add 1 tsp. olive oil." +
//                        "Add mushrooms, bok choy, leaves and stems, soy sauce, and a pinch of pepper to hot pan. " +
//                        "Stir often until stems start to soften, 5-7 minutes. Remove from burner. | " +
//                        "Plate dish as pictured on front of card, topping salmon with honey-ginger sauce, " +
//                        "and sweet potatoes with Sriracha mayonnaise (to taste). Bon appétit!",
//                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F42385%2F107430" +
//                        "HoneyGingerSalmonStepsFinal-3.jpg?ixlib=rails-1.1.0" +
//                        "&w=1500&auto=format&s=0368f9dcebf33edc17c5025383ee84f8 |" +
//                        " https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%" +
//                        "2F42386%2F107430HoneyGingerSalmonStepsFinal-2.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=" +
//                        "6ab6a4f318f3655d4d7ba7594d42c76a | https://homechef.imgix.net/https%3A%2F%2Fasset." +
//                        "homechef.com%2Fuploads%2Frecipe%2Fimage%2F42387%2Fsalmon_in_pan.jpg?ixlib=rails-1.1.0&w=" +
//                        "1500&auto=format&s=3300e35739fb87a2a2b1383463bfcfdb | " +
//                        "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2F" +
//                        "image%2F42388%2F107430HoneyGingerSalmonStepsFinal-4.jpg?ixlib=rails-1.1.0" +
//                        "&w=1500&auto=format&s=182c362c41de7af2b89d353b2b1f3100 |" +
//                        " https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated" +
//                        "%2F11144%2F107430.001.01Honey-GingerSalmon_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0" +
//                        "&w=1500&auto=format&s=f265063222d6e92ffa3cf151c5067958",
//                "Honey-Ginger Salmon");

        CookingSteps cookingSteps1 = new CookingSteps(1, "Roast the Sweet Potatoes",
                "Quarter sweet potato and cut into ½ pieces. Place sweet potato pieces on prepared" +
                        " baking sheet and toss with 2 tsp. olive oil, ¼ tsp. salt, and ¼ tsp. pepper." +
                        " Massage oil and seasoning into potatoes. Spread into a single layer and roast" +
                        " in hot oven until tender, 18-20 minutes. While sweet potato roasts, prepare ingredients.",
                "Honey-Ginger Salmon");

        CookingSteps cookingSteps2 = new CookingSteps(2, "Prepare the Ingredients",
                "Remove any discolored outer leaves from bok choy and trim ends. " +
                        "Cut stems into ½ slices and coarsely chop leaves. Stem mushrooms and cut caps into ¼ strips." +
                        "In a mixing bowl, combine honey and ginger. Set aside. In another mixing bowl, " +
                        "combine mayonnaise and Sriracha (to taste). Set aside. Pat salmon dry, and season " +
                        "flesh side with a pinch of salt and pepper.",
                "Honey-Ginger Salmon");

        CookingSteps cookingSteps3 = new CookingSteps(3, "Cook the Salmon",
                "Place a medium non-stick pan over medium heat and add 2 tsp. olive oil. " +
                        "Add salmon, skin side up, to hot pan and cook until golden brown and salmon reaches " +
                        "a minimum internal temperature of 145 degrees, 4-6 minutes per side. " +
                        "Remove from burner. Remove salmon to a plate and tent with foil. " +
                        "While salmon cooks, cook vegetables.",
                "Honey-Ginger Salmon");

        CookingSteps cookingSteps4 = new CookingSteps(4, "Cook the Vegetables",
                "Place a large non-stick pan over medium-high heat and add 1 tsp. olive oil." +
                        "Add mushrooms, bok choy, leaves and stems, soy sauce, and a pinch of pepper to hot pan. " +
                        "Stir often until stems start to soften, 5-7 minutes. Remove from burner.",
                "Honey-Ginger Salmon");

        CookingSteps cookingSteps5 = new CookingSteps(5, "Finish the Dish",
                "Plate dish as pictured on front of card, topping salmon with honey-ginger sauce, " +
                        "and sweet potatoes with Sriracha mayonnaise (to taste). Bon appétit!",
                "Honey-Ginger Salmon");

        List<CookingSteps> cookingSteps = Arrays.asList(cookingSteps1, cookingSteps2, cookingSteps3,
                cookingSteps4, cookingSteps5);

        cookingStepsRepository.saveAll(cookingSteps);

        MealCategory mealCategory1 = new MealCategory("Adventurous", "Adv");
        MealCategory mealCategory2 = new MealCategory("Quick and Simple", "QaS");
        MealCategory mealCategory3 = new MealCategory("Low-Cal", "LC");
        MealCategory mealCategory4 = new MealCategory("Carb-Conscious", "CC");
        MealCategory mealCategory5 = new MealCategory("Vegeterian", "Veg");
        List<MealCategory> mealCategories = Arrays.asList(mealCategory1, mealCategory2, mealCategory3,
                mealCategory4, mealCategory5);

        mealCategoryRepository.saveAll(mealCategories);

        Menu menu1 = new Menu(Date.valueOf("2020-12-23"), "HoneyGingerSalmon", "Quick and Simple", "M1");

        menuRepository.save(menu1);

    }


}
