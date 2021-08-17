package com.yummyyum.Bootstrap;

import com.yummyyum.Model.*;
import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import com.yummyyum.Model.MealRecipe.*;
import com.yummyyum.Repositories.*;
import com.yummyyum.Repositories.MealRecipe.*;
import com.yummyyum.Services.Meal.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    private final ImageRepository imageRepository;
    private final MealService mealService;
    private final MealCustomizeOptionRepository mealCustomizeOptionRepository;

    public BootstrapData(EmailRepository emailRepository, UserRepository userRepository, LoginRepository loginRepository,
                         SubscribeEmailRepository subscribeEmailRepository, MealRepository mealRepository,
                         MealOverviewRepository mealOverviewRepository, MealChefRepository mealChefRepository,
                         MealBoxRepository mealBoxRepository, MealBoxNutritionRepository mealBoxNutritionRepository,
                         RecipeStepsRepository recipeStepsRepository,
                         RecipeInstructionsRepository recipeInstructionsRepository,
                         CookingStepsRepository cookingStepsRepository,
                         MealCategoryRepository mealCategoryRepository, MenuRepository menuRepository, ImageRepository imageRepository, MealService mealService, MealCustomizeOptionRepository mealCustomizeOptionRepository) {
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
        this.imageRepository = imageRepository;
        this.mealService = mealService;
        this.mealCustomizeOptionRepository = mealCustomizeOptionRepository;
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void run(String... args) throws Exception {
////
        Email email1 = new Email("yummyyumkits@gmail.com", true);
        User user1 = new User("Stefan", "Annnnnnn", "Stevo",
                "1234", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
        user1.setEmail(email1);
        emailRepository.save(email1);
        userRepository.save(user1);
//
        Email email2 = new Email("admin@mail.com", true);
        User user2 = new User("Admin", "Admin", "admin",
                "admin", Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
        user2.setEmail(email2);
        emailRepository.save(email2);
        userRepository.save(user2);


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
//        Email email2 = new Email("stefanA23@mail.com", true);
//        Email email3 = new Email("stefanA32@mail.com", true);
//        Email email4 = new Email("stefanA444@mail.com", true);
//        Email email5 = new Email("stefanA654@mail.com", false);
//        Email email6 = new Email("stefanA7777@mail.com", false);
//        Email email7 = new Email("stefanA99999@mail.com", false);
//        Email email8 = new Email("stefanA1111@mail.com", false);
//        emailRepository.saveAll(email1);

//        List<Email> emails = Arrays.asList(email1, email2, email3, email4, email5, email6, email7, email8);
//        emailRepository.saveAll(emails);

        Login login1 = new Login(Timestamp.valueOf("2018-11-12 01:02:03.123456789"));
        loginRepository.save(login1);

        Date date = new Date();
        SubscribeEmail subscribeEmail1 = new SubscribeEmail(date);
        subscribeEmail1.setEmail(email2);
        subscribeEmailRepository.save(subscribeEmail1);
        MealCategory mealCategory1 = new MealCategory("Adventurous");
        MealCategory mealCategory2 = new MealCategory("Quick and Simple");
        MealCategory mealCategory3 = new MealCategory("Low-Cal");
        MealCategory mealCategory4 = new MealCategory("Carb-Conscious");
        MealCategory mealCategory5 = new MealCategory("Vegetarian");
        List<MealCategory> mealCategories = Arrays.asList(mealCategory1, mealCategory2, mealCategory3,
                mealCategory4, mealCategory5);

        mealCategoryRepository.saveAll(mealCategories);

        ArrayList<Meal>[] mealList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            mealList[i] = new ArrayList<Meal>();
        }

        for (int i = 0; i < 50; i++) {
            Meal meal = new Meal();
            meal.setMealName("Honey-Ginger Salmon" + (i + 1));
            meal.setMealDescription("with roasted sweet potatoes and bok choy");
            meal.setMealTimeTag("30-40 min.");
            meal.setMealIngredientTag("Eggs, Fish, Soy");
            meal.setPrice(6.99);
            if (i < 10) {
                meal.setMealCategory(mealCategory1);
            } else if (i < 20) {
                meal.setMealCategory(mealCategory2);
            } else if (i < 30) {
                meal.setMealCategory(mealCategory3);
            } else if (i < 40) {
                meal.setMealCategory(mealCategory4);
            } else if (i < 50) {
                meal.setMealCategory(mealCategory5);
            }
            mealList[i].add(meal);
            mealRepository.save(meal);
        }


        ArrayList<MealOverview>[] mealOverviewList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            mealOverviewList[i] = new ArrayList<MealOverview>();
        }

        for (int i = 0; i < 50; i++) {
            MealOverview mealOverview = new MealOverview();
            mealOverview.setDifficultyLevel(DifficultyLevelEnum.ONE);
            mealOverview.setSpiceLevel(SpiceLevelEnum.THREE);
            mealOverview.setCookWithin(3);
            mealOverview.setPrepCookTime("30-40 min.");

            mealOverview.setMeal(mealList[i].get(0));
            mealOverviewRepository.save(mealOverview);
        }


        ArrayList<MealChef>[] mealChefList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            mealChefList[i] = new ArrayList<MealChef>();
        }

        for (int i = 0; i < 50; i++) {
            MealChef mealChef = new MealChef();
            mealChef.setFullName("David Roaz");
            mealChef.setChefMealDescription("What do you get when you mix " +
                    "the sticky sweetness of honey with the pungent zest of ginger?" +
                    " The perfect sauce to enrobe this delicate flakey salmon. " +
                    "Second question: What do you get when you combine creamy mayonnaise with fiery Sriracha?" +
                    " The perfect sauce to drizzle over these tender sweet potatoes. Last question… combine great flavors" +
                    " and easy-to-follow recipes and what do you get? This dinner, of course. " +
                    "Tip: Having trouble cutting that wobbly sweet potato? Trim off 1/4 along" +
                    " its length and cut that section into 1/2 dice. Turn sweet potato onto its flat side. " +
                    "You now have a flat base to work from while you cut the remaining sweet potato.");
            mealChef.setMeal(mealList[i].get(0));
            mealChefRepository.save(mealChef);
        }

        ArrayList<MealBox>[] mealBoxList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            mealBoxList[i] = new ArrayList<MealBox>();
        }

        for (int i = 0; i < 50; i++) {
            MealBox mealBox = new MealBox();
            mealBox.setMealIngredients("1 tsp. Minced Ginger |" +
                    " 2 Heads of Baby Bok Choy |" +
                    " 12 oz. Salmon Fillets |" +
                    " 1 tsp. Sriracha |" +
                    " ½ fl. oz. Honey |" +
                    " 18 oz. Sweet Potato |" +
                    " 1.26 oz. Mayonnaise |" +
                    " 3 oz. Shiitake Mushrooms |" +
                    " 0.406 fl. oz. Tamari Soy Sauce");
            mealBox.setServeQuantity(2);

            mealBox.setMeal(mealList[i].get(0));
            mealBoxRepository.save(mealBox);
        }


        ArrayList<MealBoxNutrition>[] mealBoxNutritionList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            mealBoxNutritionList[i] = new ArrayList<MealBoxNutrition>();
        }

        for (int i = 0; i < 50; i++) {
            MealBoxNutrition mealBoxNutrition = new MealBoxNutrition();
            mealBoxNutrition.setCalories(842);
            mealBoxNutrition.setProtein(63);
            mealBoxNutrition.setCarbohydrates(46);
            mealBoxNutrition.setFat(41);

            mealBoxNutrition.setMeal(mealList[i].get(0));
            mealBoxNutritionRepository.save(mealBoxNutrition);
        }

        ArrayList<RecipeSteps>[] recipeStepsList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            recipeStepsList[i] = new ArrayList<RecipeSteps>();
        }

        for (int i = 0; i < 50; i++) {
            RecipeSteps recipeSteps = new RecipeSteps();
            recipeSteps.setMealUtensilsRow1("Olive Oil |" +
                    " Salt  Pepper | Cooking Spray");
            recipeSteps.setMealUtensilsRow2("1 Medium Non-Stick Pan |" +
                    " 1 Baking Sheet | 2 Mixing Bowls" +
                    " | 1 Large Non-Stick Pan");

            recipeSteps.setMeal(mealList[i].get(0));
            recipeStepsRepository.save(recipeSteps);
        }

        ArrayList<RecipeInstructions>[] recipeInstructionsList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            recipeInstructionsList[i] = new ArrayList<RecipeInstructions>();
        }

        for (int i = 0; i < 50; i++) {
            RecipeInstructions recipeInstructions = new RecipeInstructions();
            recipeInstructions.setCookSteps("Preheat oven to 425 degrees |" +
                    " If using any fresh produce, thoroughly rinse and pat dry |" +
                    " Prepare a baking sheet with foil and cooking spray");
            recipeInstructions.setGuidelines("Steak and Pork 145° F (rest cooked meat, 3 minutes) |" +
                    " Seafood 145° F |" +
                    " Chicken 165° F |" +
                    " Ground Beef 160° F |" +
                    " Ground Turkey 165° F |" +
                    " Ground Pork 160° F");
            recipeInstructions.setCustomizeInstructions("If using chicken breasts, pat dry and season " +
                    "both sides with a pinch of salt and pepper." +
                    " Follow same instructions as salmon in Step 3, cooking until chicken reaches" +
                    " minimum internal temperature, 5-7 minutes per side." +
                    " | If using sirloin steaks, pat dry and season both sides with a pinch of salt and pepper." +
                    " Follow same instructions as salmon in Step 3, cooking until steak reaches minimum internal" +
                    " temperature, 4-6 minutes per side.");

            recipeInstructions.setMeal(mealList[i].get(0));
            recipeInstructionsRepository.save(recipeInstructions);
        }

        ArrayList<CookingSteps>[] cookingStepsList = new ArrayList[50];

        // initializing
        for (int i = 0; i < 50; i++) {
            cookingStepsList[i] = new ArrayList<CookingSteps>();
        }

        for (int i = 0; i < 50; i++) {
            CookingSteps cookingSteps = new CookingSteps();

            cookingSteps.setStepNumber(1);
            cookingSteps.setStepTitle("Roast the Sweet Potatoes | Prepare the Ingredients " +
                    "| Cook the Salmon | Cook the Vegetables | Finish the Dish");
            cookingSteps.setStepDescription("Quarter sweet potato and cut into ½ pieces. " +
                    "Place sweet potato pieces on prepared baking sheet and toss with 2 tsp. " +
                    "olive oil, ¼ tsp. salt, and ¼ tsp. pepper. Massage oil and seasoning into potatoes." +
                    " Spread into a single layer and roast in hot oven until tender, 18-20 minutes. " +
                    "While sweet potato roasts, prepare ingredients. " +
                    "| Remove any discolored outer leaves from bok choy and trim ends. " +
                    "Cut stems into ½ slices and coarsely chop leaves. Stem mushrooms and cut caps into ¼ strips." +
                    "In a mixing bowl, combine honey and ginger. Set aside. In another mixing bowl, " +
                    "combine mayonnaise and Sriracha (to taste). Set aside. Pat salmon dry, and season " +
                    "flesh side with a pinch of salt and pepper. | " + "Place a medium non-stick pan over " +
                    "medium heat and add 2 tsp. olive oil. " +
                    "Add salmon, skin side up, to hot pan and cook until golden brown and salmon reaches " +
                    "a minimum internal temperature of 145 degrees, 4-6 minutes per side. " +
                    "Remove from burner. Remove salmon to a plate and tent with foil. " +
                    "While salmon cooks, cook vegetables. | " + "Place a large non-stick pan over medium-high " +
                    "heat and add 1 tsp. olive oil." +
                    "Add mushrooms, bok choy, leaves and stems, soy sauce, and a pinch of pepper to hot pan. " +
                    "Stir often until stems start to soften, 5-7 minutes. Remove from burner. " +
                    "| Finish the Dish Plate dish as pictured on front of card, " +
                    "topping salmon with honey-ginger sauce, " + "and sweet potatoes with Sriracha " +
                    "mayonnaise (to taste). Bon appétit!");

            cookingSteps.setMeal(mealList[i].get(0));
            cookingStepsRepository.save(cookingSteps);
        }


//        Menu menu1 = new Menu(Date.valueOf("2020-12-23"), "dasda");
//
//        menuRepository.save(menu1);

//        Image image1 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F5152%2F5152BBQTeriyakiandWasabiSlawBurgersReshoot__1_of_1_-c3e05e47403944539aa528a1579db1db-c3e05e47403944539aa528a1579db1db.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=882bb21ade9f5fce4e3996f3dfe761f8", "alt", false, true, 9999);
//        Image image2 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fchef%2Fchef_photo%2F21%2FDavid_Padilla-347235bc049404479e28cea9bb7ef597.jpg?ixlib=rails-1.1.0&w=110&auto=format&s=aa17086bc447d792377fea5507f30575", "alt", true, false, 9999);
//        Image image3 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24771%2F5152_BBQ_Teriyaki_and_Sriracha_Slaw_Burgers__5_of_5_-db642c886b4bde3ffd7d196cecc3e14d-db642c886b4bde3ffd7d196cecc3e14d.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=70a97293bee204b8489a181cb7d7fbcb", "alt", false, false, 1);
//        Image image4 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24772%2F5152_BBQ_Teriyaki_and_Sriracha_Slaw_Burgers__2_of_5_-9f6042e3691d59e2cb92727501294ba1-9f6042e3691d59e2cb92727501294ba1.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=a68e3f7f2452d6b30bf4d4d0c8669750", "alt", false, false, 2);
//        Image image5 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24774%2F5152_BBQ_Teriyaki_and_Sriracha_Slaw_Burgers__4_of_5_-46bada133f5299106049a1e727fb7b4d-46bada133f5299106049a1e727fb7b4d.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=230c45a4585159103e01c43254c28546", "alt", false, false, 3);
//        Image image6 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24773%2F5152JapaneseBBQBurgerFinal__1_of_1_-ce093bc28b876653663a30d5d40a0d4e-ce093bc28b876653663a30d5d40a0d4e.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=940a544ec0ada35e656ddeff0fe443cb", "alt", false, false, 4);
//        Image image7 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F5152%2F5152BBQTeriyakiandWasabiSlawBurgersReshoot__1_of_1_-c3e05e47403944539aa528a1579db1db-c3e05e47403944539aa528a1579db1db.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=d26b427b836dd651c1546ec54ba7d04d", "alt", false, false, 5);


        for (int i = 1; i <= 50; i++) {
            Image image1 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F5152%2F5152BBQTeriyakiandWasabiSlawBurgersReshoot__1_of_1_-c3e05e47403944539aa528a1579db1db-c3e05e47403944539aa528a1579db1db.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=882bb21ade9f5fce4e3996f3dfe761f8", "alt", false, true, 9999);
            Image image2 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fchef%2Fchef_photo%2F21%2FDavid_Padilla-347235bc049404479e28cea9bb7ef597.jpg?ixlib=rails-1.1.0&w=110&auto=format&s=aa17086bc447d792377fea5507f30575", "alt", true, false, 9999);
            Image image3 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24771%2F5152_BBQ_Teriyaki_and_Sriracha_Slaw_Burgers__5_of_5_-db642c886b4bde3ffd7d196cecc3e14d-db642c886b4bde3ffd7d196cecc3e14d.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=70a97293bee204b8489a181cb7d7fbcb", "alt", false, false, 1);
            Image image4 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24772%2F5152_BBQ_Teriyaki_and_Sriracha_Slaw_Burgers__2_of_5_-9f6042e3691d59e2cb92727501294ba1-9f6042e3691d59e2cb92727501294ba1.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=a68e3f7f2452d6b30bf4d4d0c8669750", "alt", false, false, 2);
            Image image5 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24774%2F5152_BBQ_Teriyaki_and_Sriracha_Slaw_Burgers__4_of_5_-46bada133f5299106049a1e727fb7b4d-46bada133f5299106049a1e727fb7b4d.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=230c45a4585159103e01c43254c28546", "alt", false, false, 3);
            Image image6 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F24773%2F5152JapaneseBBQBurgerFinal__1_of_1_-ce093bc28b876653663a30d5d40a0d4e-ce093bc28b876653663a30d5d40a0d4e.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=940a544ec0ada35e656ddeff0fe443cb", "alt", false, false, 4);
            Image image7 = new Image("https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F5152%2F5152BBQTeriyakiandWasabiSlawBurgersReshoot__1_of_1_-c3e05e47403944539aa528a1579db1db-c3e05e47403944539aa528a1579db1db.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=d26b427b836dd651c1546ec54ba7d04d", "alt", false, false, 5);
            String name = "Honey-Ginger Salmon" + i;
            name = name.toString();
            Optional<Meal> mealOne = mealRepository.getMealByMealName(name);
            mealOne.ifPresent(meal -> {
                image1.setMeal(meal);
                image2.setMeal(meal);
                image3.setMeal(meal);
                image4.setMeal(meal);
                image5.setMeal(meal);
                image6.setMeal(meal);
                image7.setMeal(meal);
            });

            List<Image> images = Arrays.asList(image1, image2, image3, image4, image5, image6, image7);
            imageRepository.saveAll(images);
        }


//        sendEmail();

        System.out.println("Done");

//        for (int i = 0; i < 50; i++) {
//            Meal meal = new Meal();
//            meal.setMealName("Honey-Ginger Salmon" + (i + 1));
//            meal.setMealDescription("with roasted sweet potatoes and bok choy");
//            meal.setMealTimeTag("30-40 min.");
//            meal.setMealIngredientTag("Eggs, Fish, Soy");
//            meal.setPrice(6.99);
//            if (i < 10) {
//                meal.setMealCategory(mealCategory1);
//            } else if (i < 20) {
//                meal.setMealCategory(mealCategory2);
//            } else if (i < 30) {
//                meal.setMealCategory(mealCategory3);
//            } else if (i < 40) {
//                meal.setMealCategory(mealCategory4);
//            } else if (i < 50) {
//                meal.setMealCategory(mealCategory5);
//            }
//            mealList[i].add(meal);
//            mealRepository.save(meal);
//        }

        String[] vegetarianMealNames = {"Cheesy Smoked Gouda Portobello Flautas",
                "Mexicali Cheesy Penne", "Pear and Blue Cheese Pizza",
                "Cheese Tortellini Peperonata", "Creamy Mushroom and Kale White Cheddar Biscuit Pie",
                "Crispy Tofu and Tzatziki Gyros", "Tortilla Elotes Risotto",
                "Charred Broccoli and Shiitake Mushroom Noodles", "Sesame Teriyaki Impossible Burger",
                "Spinach and Artichoke Risotto", "Butternut Squash White Lasagna Skillet",
                "Spicy Orange Brussels Sprouts Fritters", "Roasted Sweet Potato Tortilla Soup",
                "Huli Huli Tofu Rice Bowl", "Butternut Squash Alfredo Penne",
                "Smoky-Sweet Mushroom Sandwich", "Oven-Roasted Gnocchi with Pesto Cream",
                "Sesame Sweet Potatoes and Avocado", "Cheesy Spanish-Style Rice Stuffed Poblanos",
                "Crispy Teriyaki Tofu Tacos", "Crispy Portobello Parmesan"
        };

        String[] vegetarianMealDescriptions = {"with peppers and onions",
                "with corn and poblano", "with smoked almonds",
                "with garlic bread and Parmesan", "with peas and onions",
                "with feta and tomatoes", "with cotija cheese and jalapeño",
                "with green onions", "with fries and lime aioli",
                "with Parmesan and crispy breadcrumbs", "with lemon ricotta and rosemary mushrooms",
                "with bok choy rice", "with avocado crema",
                "with charred pineapple and teriyaki glaze", "with spicy walnuts and garlic bread",
                "with cheddar and oven-roasted potato wedges", "and spring vegetables",
                "with snap peas and jasmine rice", "with pico de gallo and sour cream",
                "with pineapple salsa", "with sun-dried tomato cream"
        };

        String[] vegetarianMealTimeTags = {"35-45 min.",
                "20-30 min.", "25-35 min.",
                "35-45 min.", "45-55 min.",
                "30-40 min.", "35-45 min.",
                "30-40 min.", "45-55 min.",
                "35-45 min.", "30-40 min.",
                "40-50 min.", "30-40 min.",
                "25-35 min.", "30-40 min.",
                "35-45 min.", "45-55 min.",
                "30-40 min.", "30-40 min.",
                "30-40 min.", "45-55 min."
        };

        String[] vegetarianMealIngredientsTags = {"Milk, Wheat",
                "Milk, Wheat", "Milk, Eggs, Wheat, Soy, Tree Nuts",
                "Milk, Eggs, Wheat", "Milk, Wheat",
                "Milk, Eggs, Wheat, Soy", "Milk",
                "Wheat, Soy", "Milk, Eggs, Wheat, Soy",
                "Milk, Wheat", "Milk, Wheat",
                "Wheat, Soy", "Milk",
                "Eggs, Wheat, Soy", "Milk, Eggs, Wheat, Tree Nuts",
                "Milk, Eggs, Wheat", "Milk, Wheat",
                "Wheat, Soy", "Milk",
                "Wheat, Soy", "Milk, Wheat"
        };

        int[] vegetarianMealDifficultyLevel = {
                2, 1, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1
        };

        int[] vegetarianMealSpiceLevel = {
                1, 3, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 3, 1, 1, 1, 0, 1, 2, 2, 1
        };

        int[] vegetarianCookWithin = {
                7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 7, 7, 7, 7, 7, 7, 7
        };

        String vegetarianChefName = "Stefan Anastasovski";
        int vegetarianServeQuantity = 2;

        String[] vegetarianChefMealDescription = {
                "Is this meal just good? No, it's Gouda… and by Gouda, we mean rich, salty, yummy cheese that helps forms a sauce that enrobes the crispy tortillas with pure flavor gold. And with meaty, umami-rich portobello mushrooms (and cream cheese) on the inside, these flautas aren't just good, aren't just Gouda, they're great… a. (We tried too hard with that one, we know.)",
                "Here's your creamy, comfy bowl of pasta, with a twist: instead of classic Italian flavors for soothing and solace, Mexican-inspired ingredients and spices form a simple yet elegant meal. Sweet corn, spicy crispy jalapeño, and zesty poblano combine for forkful after forkful of deliciousness, all with a cheesy, melty sauce so divine, you'll melt in its presence. Pasta has never felt so perfecto.",
                "There ain't no pairing like pear and blue cheese. (We know what we did.) The elegant, crisp flavors of pear, with that subtle sweetness, is made for merging with the funky strength of blue cheese. Not to mention, the sweet caramelized onions and the peppery arugula… our perfect pairing has multiplied into a fantastic foursome of flavor. And adding in the crunchy almonds… well, math was never our strong suit; making great meals (and word puns) that you'll enjoy is.",
                "Peperonata sounds like a fancy pepperoni, but not so! It is sweet peppers cooked in olive oil. (It can also be tomatoes, onion, garlic, and herbs, or served hot or cold.) Thus ends the dictionary portion of this meal description. Onto the flavors: peppers, onion, garlic, pesto, tomatoes… and delightful, rich delightful, rich tortellini mixed right in. Nothing fancy, nothing overwhelming, just plain delicious.",
                "When Mom used to say “eat your vegetables,” it used to inspire waves of moans, groans, and hiding various green things in napkins. (We hope that asparagus isn't still balled up in there!) But there would be no objection to vegetables done this way, covered in a flaky, buttery biscuit with the secret to a lot of great vegetables: cheese, cheese, and more cheese. Mom won't need to say anything now: These vegetables will fly off the plate, into your mouth, and then the recipe into your heart. (That asparagus from 1987 is long gone, right?)",
                "The Platonic gyros may mean meat slowly rotating on a spit. (See what we did there with “Platonic gyros?”) But the greatest Greek wrap can't be that limited! The flavors of gyros come through on the crisped tofu, with creamy tzatziki and fresh tomato and arugula. What would Plato have to say about this meal? Don't eat it in a cave! (Ask your philosopher friends.)",
                "This meal combines two of our favorite things: elotes, that Mexican corn dish of divine delight, and risotto, the arm workout that results in creamy perfection beyond our wildest dreams. This marriage of flavors and concepts (not to mention Mexico and Italy) is made in flavor heaven, with spicy jalapeño and sweet corn contrasting with crispy tortillas and fresh cilantro. Dreams, heaven, divine… are we overselling it a bit? We think not; take one taste and be transported. Tip: Easier way to mince cilantro? Gather them all in one hand and lay on the cutting board. Use your knife in a rocking motion to cut, then turn 90 degrees and repeat until the herbs are properly minced!",
                "Here's a fact you can “well, actually” your dining partner with: Traditionally, teriyaki is a cooking method, not a sauce. What?!? Did we just blow your mind? Let us blow your mind further with this sesame noodle and broccoli dish. Noodles are tossed with a dressing that includes sweet teriyaki glaze and spicy Sriracha, then topped with roasted vegetables. Impress with trivia and taste thanks to this calorie-conscious “teriyaki” dinner. Tip: Best way to remove ribs and seeds from a red bell pepper? Cut off top and bottom of pepper, then either carefully cut or tear out the seed portion.",
                "We've offered Impossible burger as a customize-it option before, but we're as pleased as plant-based punch to be offering it to you as its own meal. And what a meal! A sesame slaw, full of flavor and crunch topping the burger with perfectly sweet teriyaki. We've also got fries on the side, of course, but these spuds are seasoned with special furikake seasoning. Everything about this meal is special, and it proves that delicious fake meat is absolutely not impossible.",
                "Spinach and artichoke is the basis of many a delicious dip, and now is the delicious basis for this creamy risotto. The fresh spinach and the briny artichokes (toasted!) combine with a hint of bright lemon to make this risotto sparkle and sing. What other appetizers will make great inspiration for us? Keep ordering and see.",
                "The tart brightness of lemon, the herbaceous Christmas tree delight of rosemary, sweet butternut, and earthy mushrooms all come together in lasagna skillet form, with this classic veggie stunner. And does this skillet have gooey mozzarella cheese? Oh does it ever!",
                "Step off the beaten path here with a meal that brings together three distinct and wonderful things: Brussels sprouts turned into fritters and fried to crunchy, salty, truly finger-licking perfection, sweet orange and spicy pepper flakes combining to form a sweet spicy sauce, and a bok choy rice that brings together starchy goodness and fresh bok choy. That's one long sentence to describe one great meal, but the flavors are worth every word.",
                "Soup is for all times and for all seasons, but this soup sings of summer to us. The sweet potato, firm outside and tender inside, living up to its name by lending a sweet touch to the proceedings. Slightly spicy poblano and sweet corn are obvious sunshine and lazy days ingredients… but the sour cream, guacamole, and tortillas on top? Our bowl is already clean: Summer soups sooth so splendidly. Tip: Having trouble cutting that wobbly sweet potato? Trim off 1/4" + "along its length and cut that section into 1/2" + "dice. Turn sweet potato onto its flat side. You now have a flat base to work from while you dice remaining sweet potato.",
                "Combine the sweet Hawaiian BBQ flavors of huli huli with fried and crisped tofu and what do you have? Well, dinner, as right after reading this you'll be putting this meal in your basket for sure. But to elaborate further, teriyaki and pineapple provide a one-two huli huli punch that pairs with the tofu like nothing else. Want to hear more? It's easy-peasy to make and quick to come together. Mic. Dropped.",
                "We've never steered you wrong with a bowl of comfort pasta before, and this guy is not only comforting… he's interesting! Sweet soft butternut and buttery hard walnuts are both giving a slight dash of spices with Cajun seasoning, then added to a pasta with a rich Alfredo sauce and tangy goat cheese. We're steering you right yet again.",
                "Vegetarian isn't just rice bowl after rice bowl after tofu tacos after tofu tacos. (Our rice bowls and tofu tacos are delicious and amazing however, and you should order them every time!) Take this mighty mushroom sandwich, with melty cheese, fresh tomato, and that sweet, sweet BBQ sauce. Mix up your veggie world; you'll be surprised how delightful it is.",
                "Gnocchi are small Italian dumplings, whose name either comes from the Italian word for knot, or the Italian word for knuckle. (Both small things, but certainly not as delicious.) The denseness of gnocchi pairs so delightful with both the spring vegetables in this meal, and the creamy lemon sauce. It's rich, but light, filling, but not too heavy, a knot, but not a knuckle… ok, not so sure about that last one.",
                "Sriracha is everywhere: potato chips, fast food chains, probably an answer on Jeopardy at this point. But there is a reason behind the hipness and hype; Sriracha is a tasty and versatile hot sauce. Here, we combine the heat with garlic sesame sauce and use the resulting spoon-licking perfection to cook snap peas and sweet potato. Served with avocado, this meal is hip and happening, with just the right amount of spice. Tip: Having trouble cutting that wobbly sweet potato? Trim off 1/4" + "along its length and cut that section into 1/2" + "dice. Turn sweet potato onto its flat side. You now have a flat base to work from while you dice the remaining sweet potato.",
                "We love a good side of rice and beans, but you know what we love more? Stuffing Spanish-style rice and black beans into a roasted poblano, then topping it with melty cheese. Tomato salsa and sour cream on top just add to the things we love about this dish. Do you know what else we love? Our customers and that's why we've given this meal to you. (Too creepy?)",
                "We've combined tacos with many a world cuisine before, but we haven't yet brought tacos to the land of the rising sun. Not until now. Crispy fried tofu makes for a perfect morsel, topped with a fiery pineapple salsa that brings the heat and sweet in perfect balance. Add in that teriyaki glaze and you've got an East meets Southwest hand-held wonder that breaks the compass with ingenuity. Tip: Easiest way to remove jalapeño stems and seeds? Remove ends, then hold upright. Carefully slice the pepper into four pieces, leaving stem and seeds to discard.",
                "Pasta often contains mushrooms, but not like this: mushrooms coated in flour and panko, are fried to a rich, amazing crunch and flavor, sitting atop a mound of spaghetti and pesto sauce that brings both flavor and comfort. The perfect combo of umami and tang, this pasta meal brings the shrooms in a whole new and amazing way."
        };

        String[] vegetarianMealIngredients = {
                "2 Smoked Gouda Slices | 6 Small Flour Tortillas | 2 oz. Light Cream Cheese | 2 tsp. Mushroom Seasoning | 2 tsp. Mirepoix Broth Concentrate | 2 Portobello Mushrooms | ¼ tsp. Red Pepper Flakes | 2 Green Onions | 6 oz. Pepper and Onion Mix",
                "2 Green Onions | 5 oz. Penne Pasta | 1 Poblano Pepper | 1 Ear of Corn | 4 oz. Grape Tomatoes | 2 tsp. Taco Seasoning | 4 oz. Light Cream | 2 oz. Shredded Cheddar-Jack Cheese | 1 oz. Sour Cream | 1 oz. Crispy Jalapeños",
                "2 Naan Flatbreads | 1 Yellow Onion1 Bosc Pear | ½ oz. Baby Arugula | 1 oz. Smoked Almonds | 1 oz. Blue Cheese Crumbles | 4 oz. Shredded Mozzarella | 1 fl. oz. Balsamic Fig Glaze",
                "3 Tbsp. Roasted Red Pepper Pesto | 1 Red Bell Pepper | 2 Garlic Cloves | 1 French Roll | 15 oz. Crushed Tomatoes | ½ tsp. Garlic Pepper | 1 tsp. Sugar | 9 oz. Par-Cooked 5-Cheese Tortellini | ½ oz. Shredded Parmesan Cheese | 1 Yellow Onion",
                "1 Yellow Onion | 3 oz. Chopped Kale | 4 tsp. Mirepoix Broth Concentrate | 2 oz. Shredded White Cheddar Cheese | 2 oz. Light Cream Cheese | 4 oz. Buttermilk Biscuit Mix | 2 tsp. Garlic Pepper | 3 oz. Peas | 8 oz. Cremini Mushrooms",
                "2 Tbsp. Cornstarch | 2 oz. Tzatziki Dip | 1 Roma Tomato | 1 oz. Sour Cream | 2 tsp. Chimichurri Seasoning | 12 oz. Extra Firm Tofu | ½ oz. Feta Cheese Crumbles | 4 Mini Naan Flatbreads | 2 Tbsp. Panko Breadcrumbs | ½ oz. Baby Arugula",
                "5 oz. Corn Kernels | 2 oz. Grated Cotija Cheese | 2 tsp. Vegetable Broth Concentrate | ½ oz. Tortilla Strips | 1 Lime | 1 Jalapeño Pepper | 1 oz. Butter | ¾ cup Arborio Rice | ¼ oz. Cilantro | 1 Shallot",
                "2 Green Onions | 2 oz. Teriyaki Glaze | 6 oz. Broccoli Florets | 1 Red Bell Pepper | 3 oz. Shiitake Mushrooms | 8 oz. Cooked Asian Noodles | ½ fl. oz. Toasted Sesame Oil | 1 tsp. Sriracha | 1 tsp. Multicolor Sesame Seeds",
                "2 tsp. Asian Garlic, Ginger & Chile Seasoning | 2 Brioche Buns | 1.26 oz. Mayonnaise | 1 oz. Teriyaki Glaze | 3 oz. Shredded Red Cabbage | 2 Russet Potatoes | ¼ oz. Specialty Toasted Sesame Oil | 1 Lime | 1 Persian Cucumber | 12 oz. Impossible Burger",
                "8 oz. Artichoke Hearts | 2 oz. Light Cream Cheese | ½ tsp. Garlic Salt | 1 Lemon | 2 tsp. Mirepoix Broth Concentrate | ¼ cup Panko Breadcrumbs | 1 oz. Shredded Parmesan Cheese | 5 oz. Baby Spinach | 1 cups Arborio Rice",
                "2 oz. Shredded Mozzarella | 1 oz. Ricotta | 8 oz. Cubed Butternut Squash | 5 oz. Lasagna Noodles | 4 oz. Cremini Mushrooms | 4 fl. oz. Cream Sauce Base | ¼ oz. Flour | 1 Rosemary | 1 Lemon",
                "½ cups Tempura Mix | ¼ tsp. Red Pepper Flakes | 6 fl. oz. Canola Oil | 2 fl. oz. Orange Sauce | 4 oz. Shredded Brussels Sprouts | 1 tsp. Umami Seasoning | ¾ cup Jasmine Rice | 2 Green Onions | 2 Heads of Baby Bok Choy",
                "5 oz. Corn Kernels | 2 tsp. Mirepoix Broth Concentrate | 1 oz. Sour Cream | 1 Tbsp. Taco Seasoning | 1 Shallot | 1 Poblano Pepper | 18 oz. Sweet Potato | 2 oz. Guacamole | 1 oz. Tortilla Strips | 1 Lime",
                "3 Pineapple Rings | 0.84 oz. Mayonnaise | 3 Tbsp. Cornstarch | 12 oz. Extra Firm Tofu | 4 oz. Teriyaki Glaze | 4 oz. Slaw Mix | ¾ cup Jasmine Rice | ¼ tsp. Red Pepper Flakes | 2 Green Onions | 1 Lime",
                "1 Ciabatta | 1 tsp. Cajun Seasoning | 2 Garlic Cloves | ½ oz. Baby Spinach | 1 oz. Walnut Halves | 1 oz. Goat Cheese | 4 oz. Alfredo Sauce | ½ oz. Grated Parmesan | 8 oz. Cubed Butternut Squash | 5 oz. Penne Pasta",
                "1 Roma Tomato | 3 oz. BBQ Sauce | ½ oz. Crispy Jalapeños | 2 tsp. Buttermilk-Dill Seasoning | 1½ oz. Sliced Cheddar Cheese | 10 oz. Cremini Mushrooms | 12 oz. Yukon Potatoes | 2 Brioche Buns | 2 Green Onions",
                "1 Red Bell Pepper | 1 Shallot | 4 fl. oz. Cream Sauce Base | 1 Lemon | 1 Tbsp. Basil Pesto | 2 tsp. Mushroom Seasoning | 3 oz. Peas | 1 oz. Shaved Parmesan | 12 oz. Par-Cooked Gnocchi",
                "1 tsp. Multicolor Sesame Seeds | 1 Avocado | ¾ cup Jasmine Rice | 18 oz. Sweet Potato | 6 oz. Snap Peas | 1 Lime | 3 fl. oz. Garlic Sesame Sauce | 2 tsp. Sriracha | 3 oz. Matchstick Carrots",
                "3 oz. Black Beans | 1 Lime | 3 Poblano Peppers | 3 oz. Shredded Oaxacan Cheese | 1 tsp. Fajita Seasoning | ½ cup Basmati Rice | 2 fl. oz. Red Enchilada Sauce | 2 Roma Tomatoes | 2 oz. Sour Cream | ¼ oz. Cilantro",
                "3 oz. Pineapple Chunks | 3 Tbsp. Cornstarch | 1 tsp. Asian Garlic, Ginger & Chile Seasoning | 2 Green Onions | 6 Small Flour Tortillas | 2 oz. Teriyaki Glaze | ¼ oz. Cilantro | 1 Jalapeño Pepper | 12 oz. Extra Firm Tofu",
                "6 fl. oz. Canola Oil | 2 Tbsp. Sun-Dried Tomato Pesto | 5 oz. Spaghetti | ½ cup Panko Breadcrumbs | ½ oz. Grated Parmesan | 2 oz. Light Cream Cheese | 2 oz. Flour | ¼ tsp. Red Pepper Flakes | 2 Portobello Mushrooms"
        };

        int[] vegetarianCalories = {
                525, 655, 880, 734, 622, 769, 673, 393, 1076, 696,
                648, 933, 572, 938, 830, 736, 659, 834, 492, 721, 781
        };

        int[] vegetarianCarbohydrates = {
                56, 76, 99, 100, 61, 67, 87, 53, 107, 107,
                83, 113, 89, 111, 93, 110, 80, 139, 65, 73, 93
        };

        int[] vegetarianFat = {
                26, 32, 41, 26, 33, 42, 31, 15, 54, 21,
                28, 51, 21, 44, 41, 25, 31, 25, 17, 38, 38
        };

        int[] vegetarianProtein = {
                17, 19, 31, 27, 23, 28, 18, 12, 43, 23,
                21, 9, 9, 25, 26, 22, 17, 14, 20, 24, 21,
        };

        String[] vegetarianMealUtensilsRow1 = {
                "Olive Oil | Salt | Pepper",
                "Salt | Pepper | Cooking Spray",
                "Olive Oil  | Pepper",
                "Olive Oil | Salt | Pepper",
                "Olive Oil | Pepper | Cooking Spray",
                "Olive Oil  | Salt",
                "Olive Oil | Salt | Pepper",
                "Olive Oil | Salt | Pepper | Cooking Spray",
                "Olive Oil | Salt | Pepper | Cooking Spray",
                "Olive Oil | Salt | Pepper",
                "Olive Oil | Salt | Pepper",
                "Salt | Pepper",
                "Olive Oil | Salt | Pepper | Cooking Spray",
                "Olive Oil | Salt | Pepper",
                "Olive Oil | Salt | Cooking Spray",
                "Olive Oil | Salt | Pepper | Cooking Spray",
                "Olive Oil | Salt | Pepper | Cooking Spray",
                "Olive Oil | Salt | Pepper | Cooking Spray",
                "Olive Oil | Salt | Cooking Spray",
                "Olive Oil | Salt | Pepper",
                "Olive Oil | Salt | Pepper",
        };

        String[] vegetarianMealUtensilsRow2 = {
                "1 Small Pot | 1 Large Non-Stick Pan",
                "1 Medium Pot | 1 Colander | 1 Large Non-Stick Pan",
                "1 Baking Sheet | 1 Large Non-Stick Pan",
                "1 Colander | 1 Baking Sheet | 1 Medium Pot | 1 Large Non-Stick Pan",
                "1 Baking Sheet | 1 Small Oven-Safe Casserole Dish | 1 Mixing Bowl | 1 Large Non-Stick Pan",
                "1 Medium Non-Stick Pan | 1 Baking Sheet | 2 Mixing Bowls",
                "1 Small Pot | 1 Medium Pot",
                "1 Medium Pot | 1 Baking Sheet | 1 Mixing Bowl",
                "1 Baking Sheet | 2 Mixing Bowls | 1 Large Non-Stick Pan",
                "2 Medium Pots",
                "1 Large Pot | 1 Large Oven-Safe Non-Stick Pan | 1 Mixing Bowl | 1 Colander",
                "1 Medium Non-Stick Pan | 1 Small Pot | 2 Microwave-Safe Bowls",
                "1 Baking Sheet | 1 Mixing Bowl | 1 Medium Pot",
                "1 Medium Non-Stick Pan | 1 Small Pot | 2 Mixing Bowls",
                "1 Colander | 1 Baking Sheet | 1 Medium Pot | 1 Mixing Bowl | 1 Large Non-Stick Pan",
                "1 Baking Sheet  | 1 Large Non-Stick Pan",
                "2 Baking Sheets | 1 Mixing Bowl",
                "1 Baking Sheet | 1 Small Pot | 1 Mixing Bowl | 1 Large Non-Stick Pan",
                "1 Baking Sheet | 1 Small Pot | 2 Mixing Bowls | 1 Wire-Mesh Strainer",
                "1 Large Non-Stick Pan | 3 Mixing Bowls",
                "1 Colander | 2 Medium Non-Stick Pans | 1 Medium Pot | 1 Mixing Bowl"
        };

        String[] vegetarianCookSteps = {
                "If using any fresh produce, thoroughly rinse and pat dry | Set cream cheese on counter to soften | Ingredient(s) used more than once: green onions, cream cheese",
                "If using any fresh produce, thoroughly rinse and pat dry | Bring 8 cups water and 2 tsp. salt to a boil in a medium pot | Ingredient(s) used more than once: green onions",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Prepare a baking sheet with foil",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Bring 8 cups water to a boil in a medium pot | Prepare a baking sheet with foil | Ingredient(s) used more than once: garlic, cheese | Only half the onion is used in this recipe",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Prepare a casserole dish with cooking spray | Prepare a baking sheet with foil | Ingredient(s) used more than once: cheddar cheese",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Prepare a baking sheet with foil",
                "If using any fresh produce, thoroughly rinse and pat dry | Bring 4 cups water and 1/4 tsp. salt to a boil in a small pot | Ingredient(s) used more than once: cilantro, cheese",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Prepare a baking sheet with foil and cooking spray | Ingredient(s) used more than once: green onions, teriyaki glaze",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 425 degrees | Prepare a baking sheet with foil and generously coat with cooking spray | Ingredient(s) used more than once: lime juice, teriyaki glaze | Upon delivery, remove potatoes from meal bag and store at room temperature",
                "If using any fresh produce, thoroughly rinse and pat dry | Bring a medium pot of water to a boil",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat the broiler | Bring 8 cups water and 2 tsp. salt to a boil in a large pot",
                "If using any fresh produce, thoroughly rinse and pat dry | Ingredient(s) used more than once: green onions | Only a pinch of red pepper flakes is used in this recipe.",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Prepare a baking sheet with foil and cooking spray",
                "If using any fresh produce, thoroughly rinse and pat dry | Ingredient(s) used more than once: green onions",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 400 degrees | Bring 8 cups water and 2 tsp. salt to a boil in a medium pot | Prepare a baking sheet with foil and cooking spray | Ingredient(s) used more than once: seasoning blend",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 425 degrees | Prepare a baking sheet with foil and cooking spray | Ingredient(s) used more than once: green onions",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 425 degrees | Prepare two baking sheets with foil and cooking spray",
                "Preheat oven to 400 degrees | If using any fresh produce, thoroughly rinse and pat dry | Prepare a baking sheet with foil and cooking spray | Ingredient(s) used more than once: garlic sesame-Sriracha sauce, sesame seeds | Check avocado for ripeness upon delivery. If unripe, close in a paper bag, either alone or with a banana, apple, or tomato. Let sit on a counter for a couple days.",
                "If using any fresh produce, thoroughly rinse and pat dry | Preheat oven to 425 degrees | Prepare a baking sheet with foil | Ingredient(s) used more than once: cheese, lime juice",
                "If using any fresh produce, thoroughly rinse and pat dry | Ingredient(s) used more than once: green onions",
                "If using any fresh produce, thoroughly rinse and pat dry | Bring 8 cups water and 2 tsp. salt to a boil in a medium pot | Ingredient(s) used more than once: flour"
        };

        String guidelines = "Steak and Pork 145° F (rest cooked meat, 3 minutes) | Seafood 145° F | Chicken 165° F | Ground Beef 160° F | Ground Turkey 165° F | Ground Pork 160° F";

        String[] vegetarianStepTitles = {
                "Roast the Sweet Potatoes | Prepare the Ingredients | Cook the Salmon | Cook the Vegetables | Finish the Dish",
                "Prepare the Ingredients | Roast the Potatoes | Cook the Green Beans | Cook the Steaks | Make Sauce and Finish Dish",
                "Prepare Ingredients and Make Hot Honey | Par-Bake the Flatbreads | Crisp the Prosciutto | Cook the Onions | Assemble and Bake Flatbreads",
                "Prepare the Ingredients | Cook Shrimp and Artichokes | Cook the Pasta | Make the Sauce | Finish the Dish",
                "Prepare the Ingredients | Start the Risotto | Finish the Risotto | Sear the Steak Strips | Cook Mushrooms and Finish Dish",
                "Prepare the Ingredients | Cook the Chicken Mixture | Start the Stew | Finish the Stew | Finish the Dish",
                "Prepare the Ingredients | Cook the Filling | Assemble the Quesadillas | Cook the Quesadillas | Make Cilantro Crema and Finish Dish",
                "Prepare the Ingredients | Cook the Vegetables | Cook the Pork Chops | Make the Apple-Bacon-Shallot Jam | Finish the Dish",
                "Roast the Carrot | Make the Mashed Potatoes | Prepare Mushrooms and Form Meatballs | Start the Meatballs | Finish Meatballs and Finish Dish",
                "Bake the Tortillas | Prepare the Ingredients | Make the Salsa | Cook the Zucchini | Make Tzatziki and Assemble Tostadas",
                "Roast the Sweet Potatoes | Cook the Rice | Prepare the Ingredients | Cook the Vegetables | Finish the Dish",
                "Prepare the Ingredients | Cook the Filling | Assemble the Quesadillas | Toast the Flautas | Make Cheese Sauce and Finish Dish",
                "Cook the Pasta | Prepare the Ingredients | Cook the Vegetables | Make the Sauce | Finish the Dish",
                "Caramelize the Onion | Prepare the Ingredients | Par-Bake the Flatbreads | Bake the Pizzas | Finish the Dish",
                "Prepare the Ingredients | Make the Sauce | Make the Sauce | Cook the Tortellini | Finish the Dish",
                "Prepare the Ingredients | Start the Filling | Finish the Filling | Assemble Pie and Make Crust | Finish the Dish",
                "Prepare Ingredients and Make Tzatziki | Prepare the Tofu | Fry the Tofu | Toast the Flatbreads | Finish the Dish",
                "Prepare the Ingredients | Cook the Vegetables | Start the Risotto | Finish the Risotto | Finish the Dish",
                "Prepare the Ingredients | Roast the Vegetables | Make the Dressing | Heat the Noodles | Finish the Dish",
                "Bake the Fries | Prepare Ingredients and Make Lime Aioli | Make the Slaw | Make the Burgers | Toast Buns and Finish the Dish",
                "Prepare the Ingredients | Toast Panko and Cook Artichokes | Start the Risotto | Finish the Risotto | Finish the Dish"
        };

        String[] vegetarianStepDescription = {
                "Trim and thinly slice green onions on an angle, keeping white and green portions separate. Tear Gouda into small pieces. Using a spoon, scoop out black undersides (gills) of mushrooms. Cut mushrooms into ¼\" strips. | Place a large non-stick pan over medium-high heat and add 1 tsp. olive oil. Add mushrooms to hot pan and stir occasionally, 2 minutes. Add pepper and onion mix, white portions of green onions, seasoning blend, and a pinch of pepper. Stir occasionally until vegetables are softened, 10-12 minutes. Stir in ¼ cup water, mirepoix base, half the softened cream cheese (reserve remaining for sauce), and ¼ tsp. salt. Bring to a simmer. Once simmering, stir occasionally until combined and sauce begins to thicken, 1-2 minutes. Remove from burner. | Place tortillas on a clean work surface. | Divide filling equally among tortillas, placing in center. Wipe pan clean and reserve. Tuck one tortilla end under filling and roll tightly, placing seam side down. Repeat with remaining tortillas. | Return pan used to cook filling to medium heat and add 2 tsp. olive oil. Working in batches if necessary, place flautas in hot pan, seam-side down. Cook until browned on one side, 2-3 minutes. Replenish oil if necessary. Gently roll to opposite side and cook until browned, 2-3 minutes. Remove from burner. | Place a small pot over medium-high heat. Add 2 Tbsp. water, remaining cream cheese, and a pinch of salt to hot pot. Whisk or stir vigorously to combine, then add an additional 2 Tbsp. water and bring to a boil. Once boiling, remove from burner. Stir in Gouda pieces, a few at a time, returning to heat as needed, until completely combined and smooth. Plate dish as pictured on front of card, topping flautas with cheese sauce, green portions of green onions, and red pepper flakes (to taste). Bon appétit!",
                "Once water is boiling, add pasta and cook until al dente, 10-12 minutes. Reserve ¼ cup pasta cooking water. Drain pasta in a colander and return to pot. Set aside. While pasta cooks, prepare ingredients. |  Trim and thinly slice green onions on an angle. Halve tomatoes. Peel husk off corn and remove kernels from cob, holding cob vertically and carefully slicing downward. Stem poblano pepper, seed, halve lengthwise, and slice into thin strips. Poblano peppers can vary in spice level; most are mild, but a few can be quite hot. Wash hands and cutting board after prepping. | Place a large non-stick pan over medium-high heat and spray with cooking spray. Add corn, poblano (to taste), green onions (reserving a pinch for garnish), seasoning blend, ¼ tsp. salt, and a pinch of pepper to hot pan. Stir occasionally until poblano and corn are browned and tender, 4-6 minutes. | Add cream, reserved pasta cooking water, cheese, pasta, tomatoes, sour cream, and ¼ tsp. salt to pan. Stir constantly until cheese melts, 1-2 minutes. Remove from burner. | Plate dish as pictured on front of card, garnishing with crispy jalapeños (to taste) and reserved green onions. Bon appétit!",
                "Halve and peel onion. Slice halves into thin strips. Place a large non-stick pan over medium-low heat. Add 1 Tbsp. olive oil, onion, and a pinch of pepper to hot pan. Stir occasionally until onion is lightly caramelized, 15-20 minutes. While onion caramelizes, prepare ingredients. | Coarsely chop almonds. Quarter pear and core. Cut quarters into thin slices lengthwise. | Place flatbreads directly on rack in hot oven and toast, 5 minutes. | Place par-baked flatbreads on a clean work surface. Divide mozzarella evenly on flatbreads, leaving ¼\" border. Shingle pear slices on mozzarella. Drizzle each pizza with 1 tsp. olive oil. Place pizzas directly on oven rack, with prepared baking sheet on rack below to catch any drips. Bake until pizzas are golden brown and pears are tender, but still slightly crisp, 10-12 minutes. | Plate dish as pictured on front of card, garnishing pizzas with almonds, blue cheese, arugula, and caramelized onions (to taste). Drizzle with balsamic fig glaze. Bon appétit!",
                "Stem, seed, remove ribs, and cut red bell pepper into ½\" dice. Halve and peel onion. Slice one half into thin strips. (Remaining half is yours to use as you please!) Mince garlic. | Place a large non-stick pan over medium-high heat and add 2 tsp. olive oil. Add onion and red bell pepper to hot pan and stir occasionally until tender, 4-6 minutes. Add half the garlic (reserve remaining for bread), garlic pepper, sugar, crushed tomatoes, pesto, ¼ tsp. salt, and a pinch of pepper. Bring to a simmer. Once simmering, stir occasionally until combined, 2-3 minutes. Remove from burner. While sauce cooks, bake garlic bread. | Separate French roll, if necessary. Place French roll halves on prepared baking sheet, cut side up. Top evenly with 2 tsp. olive oil, remaining garlic, and half the cheese (reserve remaining for garnish). Bake in hot oven until cheese is melted and bread is golden-brown, 8-10 minutes. While garlic bread bakes, cook tortellini. | Once water is boiling, add tortellini and cook until softened and heated through, 3-4 minutes. Drain in a colander. Gently stir tortellini into pan with sauce until combined. | Plate dish as pictured on front of card, garnishing tortellini with remaining cheese. Bon appétit! | ",
                "Quarter mushrooms. Halve and peel onion. Cut halves into ¼\" dice. | Place a large non-stick pan over medium-high heat and add 2 tsp. olive oil. Add mushrooms to hot pan and stir occasionally until starting to brown, 4-6 minutes. Add onion and kale. Stir occasionally until kale wilts and onion softens, 4-6 minutes. | Stir ¾ cup water, mirepoix base, seasoning blend, cream cheese, and a pinch of pepper into hot pan. Bring to a simmer. Once simmering, stir occasionally until slightly thickened, 4-6 minutes. Remove from burner. Stir in peas and half the cheddar cheese (reserve remaining for topping) until completely combined. | Transfer filling to prepared casserole dish. For best results, use a 1-quart casserole dish. Place casserole dish on prepared baking sheet to catch any drips. In a mixing bowl, combine biscuit mix and ¼ cup water. Stir until a sticky dough forms. If too dry, add additional water, 1 Tbsp. at a time, until desired consistency is reached. Top filling evenly with dollops of dough and remaining cheddar cheese. | Bake in hot oven until crust is golden brown, 18-22 minutes. Plate dish as pictured on front of card, breaking crust evenly for each bowl. Bon appétit!",
                "Line a plate with a paper towel. Cut tofu into 1\" dice and place on towel-lined plate. Top with paper towels, then press gently but firmly to remove excess moisture. Set aside, 5 minutes. While tofu sits, core tomato and cut into ¼\" rounds. In a mixing bowl, mix cornstarch and ¼ cup water until completely combined. Set aside. In another mixing bowl, combine tzatziki, sour cream, and ¼ tsp. salt. Set aside. | Place a medium non-stick pan over medium heat and add 3 Tbsp. olive oil. Let oil heat, 5 minutes. While oil heats, line another plate with a paper towel. Place panko on another plate. Working in batches, dip tofu in cornstarch-water mixture, coating completely. Then transfer to plate with panko, coating completely. To get the best coat in panko, press down lightly on tofu, or gently flip. You may also sprinkle with panko on top, or use a bowl. | Test olive oil temperature by adding a pinch of panko to it. It should sizzle gently. If it browns immediately, turn heat down and let oil cool. If it doesn't brown, increase heat. Carefully, add tofu to hot oil. Fry until golden brown, 5-7 minutes, flipping once halfway through. Transfer fried tofu to towel-lined plate. Season with ¼ tsp. salt and seasoning blend. While tofu cooks, toast flatbreads. | Place flatbreads on prepared baking sheet. Bake in hot oven until toasted, 4-6 minutes. | Plate dish as pictured on front of card, filling flatbreads with tofu, tzatziki, cheese, tomato, and arugula. Bon appétit!",
                "Mince cilantro (no need to stem). Cut lime into wedges. Peel and mince shallot. Stem jalapeño, halve, seed, remove ribs, and mince. Wash hands and cutting board after working with jalapeño. | Heat 2 tsp. olive oil in a medium pot over medium heat. Add corn, shallot, 2 Tbsp. jalapeño (use less if spice-averse), ¼ tsp. salt, and a pinch of pepper to hot pot. Stir occasionally until lightly charred and tender, 3-5 minutes. Remove from burner. Remove vegetables to a plate and cover with foil. Reserve pot; no need to wipe clean. | Return pot used to cook vegetables to medium-high heat. Add 2 tsp. olive oil, rice, and vegetable base to hot pot. Stir occasionally until rice is toasted and opaque, 1-2 minutes. Add 1 cup boiling water from small pot to pot with rice. Rice should just be covered by water. Stir often until nearly all water is absorbed. | Add ½ cup boiling water from small pot to pot with rice and stir often again until water is nearly all absorbed. Repeat this process, stirring often, 18-20 minutes. Taste risotto as you cook, checking for tenderness. When rice has no more “bite” or crunch, it's done. There may be water left. Remove from burner. Stir in butter, cilantro (reserve a pinch for garnish), cheese (crumbling if necessary, and reserving a pinch for garnish), ¼ tsp. salt, and a pinch of pepper. | Plate dish as pictured on front of card, topping risotto with vegetables and garnishing with reserved cilantro, reserved cheese, and tortilla strips. Squeeze lime wedges over dish to taste. Bon appétit!",
                "Cut broccoli into bite-sized pieces. Stem, seed, remove ribs, and slice red bell pepper into ¼\" strips. Halve strips. Stem mushrooms and cut caps into ¼\" strips. Discard stems. Trim and slice white portions of green onions into ½\" pieces. Thinly slice green portions of green onions on an angle. Keep white and green portions separate. | Place broccoli, red bell pepper, mushrooms, and white portions of green onions on prepared baking sheet. Toss with 2 tsp. olive oil, ¼ tsp. salt, and a pinch of pepper. Spread into a single layer. Roast in hot oven until vegetables are tender and broccoli just begins to char, 20-25 minutes. Rest roasted vegetables at least 5 minutes. While vegetables roast, make dressing. | In a mixing bowl, combine teriyaki glaze (reserve 1 Tbsp. for garnish), 2 Tbsp. water, sesame oil, and Sriracha (to taste). Set aside. | Place a medium pot over medium-high heat. Add noodles, dressing, and green portions of green onions (reserve a pinch for garnish) to hot pot. Stir until combined and heated through, 1-2 minutes. Remove from burner. | Plate dish as pictured on front of card, placing vegetables on noodles and garnishing with reserved teriyaki glaze, remaining green portions of green onions, and sesame seeds. If desired, mix vegetables with noodles. Bon appétit!",
                "Cut potatoes into ½\" fries and pat dry. Place fries on prepared baking sheet and toss with 1 Tbsp. olive oil and a pinch of salt and pepper. Spread into a single layer and bake in hot oven until lightly browned, 33-35 minutes, tossing once halfway through. Remove from oven and toss or gently combine with seasoning blend (to taste). Baking sheet will be hot! Use a utensil. While fries bake, prepare ingredients. | Trim cucumber and thinly slice into rounds. Halve lime and juice. Combine mayonnaise and 2 tsp. lime juice (reserve remaining for slaw) in a mixing bowl. Set aside. | In another mixing bowl, combine cabbage, cucumber, sesame oil, 2 tsp. olive oil, 2 tsp. remaining lime juice, and half the teriyaki glaze (reserve remaining for burgers). Set aside. | Form Impossible Burger into two evenly-sized patties. Place a large non-stick pan over medium-high heat and spray with cooking spray. Add patties to hot pan. Cook until browned and patties are warmed through, 3-4 minutes per side. Remove patties to a plate. Wipe pan clean and reserve. | Return pan used to cook patties to medium-high heat. Add buns to hot, dry pan, cut side down, and toast until lightly browned 1-2 minutes. Remove from burner. Plate dish as pictured on front of card, topping bottom bun with patty, remaining teriyaki glaze, slaw, and top bun. Serve lime aioli on the side for dipping fries. Bon appétit!",
                "Drain artichokes, rinse, and pat dry. Coarsely chop. Coarsely chop spinach. Zest lemon, halve, and juice. | Place another medium pot over medium-high heat and add 2 tsp. olive oil. Add panko to hot pot and stir constantly until toasted, 1-2 minutes. Remove panko to a plate. Wipe pot clean and return to medium heat. Add 2 tsp. olive oil and artichokes to hot pot. Stir occasionally until softened, 2-3 minutes. Transfer artichokes to another plate. Wipe pot clean and reserve. | Return pot used to cook artichokes to medium-high heat and add 1 tsp. olive oil. Add rice to hot pot. Stir occasionally until rice is toasted and opaque, 1-2 minutes. Add 1 cup boiling water from other medium pot, mirepoix base, ¼ tsp. salt, and a pinch of pepper to pot with rice. Rice should just be covered by water. Stir often until nearly all water is absorbed. Add ½ cup boiling water and stir often again until nearly all water is absorbed. Repeat this process, stirring often, 18-20 minutes. | Taste risotto as you cook, checking for tenderness. When rice has no more “bite” or crunch, it's done. There may be water left. Add cream cheese, garlic salt, spinach, and artichokes to pot. Stir until spinach is wilted, 1-2 minutes. Stir in 1 tsp. lemon zest and 1 Tbsp. lemon juice. Remove from burner. | Plate dish as pictured on front of card, topping risotto with panko and Parmesan. Bon appétit!",
                "Cut mushrooms into ¼\" slices. Stem and mince rosemary. Break noodles in half. Halve any large butternut squash pieces to roughly match smaller pieces. Zest and halve lemon. Cut one half into wedges and juice the other half. In a mixing bowl, combine ricotta, ½ tsp. lemon zest, 1 tsp. lemon juice, and a pinch of salt and pepper. Stir until combined and smooth. Set aside. | Once water is boiling, add noodles and butternut squash. Stir occasionally until noodles are al dente and squash is fork-tender, 10-12 minutes. Drain pasta and squash in a colander. Don't worry if noodles break. Set aside. While noodles and butternut squash cook, start skillet. | Place large oven-safe non-stick pan over medium-high heat and add 2 tsp. olive oil. Add mushrooms to hot pan and stir occasionally until browned, 4-6 minutes. Stir in ¼ tsp. salt, 1 tsp. rosemary, and a pinch of pepper until combined. Add flour and stir until no dry flour remains in pan. | Add cream base and ⅔ cup water to hot pan. Bring to a simmer. Once simmering, cook until liquid is thick enough to coat the back of a spoon, 1-2 minutes. Remove from burner. Stir in ¼ tsp. salt, noodles, and butternut squash until coated. | Top skillet evenly with cheese and 1 tsp. olive oil. Place skillet under hot broiler and broil until cheese is melted and golden brown, 3-5 minutes. Don't text and broil! Keep an eye on skillet as it broils, as cheese may burn. Carefully remove from oven. Pan will be hot! Use an oven mitt. Plate dish as pictured on front of card, topping with lemon ricotta and squeezing lemon wedges over dish to taste. Bon appétit!",
                "Remove any discolored outer leaves from bok choy and trim ends. Cut into ¼\" strips, keeping leaves and stems separate. Bring a small pot with rice, bok choy stems, and 1½ cups water to a boil. Reduce to a simmer, cover, and cook until rice and bok choy are tender, 15-18 minutes. While rice and bok choy cook, thinly slice green onions, keeping white and green portions separate. | Uncover, and stir in bok choy leaves and seasoning blend. Cover and set aside. While rice cooks, make fritter batter. | Place Brussels sprouts, ¼ cup water, and a pinch of salt in a microwave-safe bowl. Cover with a damp paper towel and microwave on high, 1 minute. + " +
                        "Add tempura mix and white portions of green onions and combine thoroughly. Add ¼ cup water and stir until combined and a thin batter forms. Stir in a pinch of pepper. If too thick, add additional cold water, 1 Tbsp. at a time, until desired consistency is reached. | Add canola oil to a medium non-stick pan and place over medium-high heat. Let heat, 5 minutes. While oil heats, line a plate with a paper towel. Test oil temperature by adding a pinch of fritter batter to it. It should sizzle gently. If it browns immediately, turn heat down and let oil cool. If it doesn't brown, increase heat. +" +
                        "Working in batches, carefully add 2 Tbsp. dollops of fritter batter to hot oil, 2-4 at a time. Cook undisturbed until golden brown, 2-4 minutes per side. Flip fritters gently (use chopsticks or tongs for best results). Remove fritters to towel-lined plate. Repeat with remaining batter. Batter should make about six fritters total. | In another microwave-safe bowl, combine orange sauce, a pinch of red pepper flakes (remaining is yours to do with as you please!), and 1 Tbsp. water. Cover with a damp paper towel and microwave until sauce is bubbling, 1-2 minutes. Plate dish as pictured on front of card, topping fritters with sauce. Garnish meal with green portions of green onions. Bon appétit!",
                "Peel sweet potato and cut into ½\" dice. Place sweet potato on prepared baking sheet and toss with 2 tsp. olive oil, ¼ tsp. salt, and a pinch of pepper. Massage oil, salt, and pepper into sweet potato. Spread into a single layer. Roast in hot oven until tender, 18-20 minutes. While sweet potato roasts, prepare ingredients. | Halve lime. Cut one half into wedges and juice other half. Peel and mince shallot. Stem poblano pepper, seed, and cut into ½\" dice. Poblano peppers can vary in spice level; most are mild, but a few can be quite hot. Wash hands and cutting board after prepping. | Place a medium pot over medium heat and add 2 tsp. olive oil. Add shallot and poblano pepper to hot pot and stir occasionally until softened, 3-4 minutes. Stir in seasoning blend and corn until aromatic, 30-45 seconds. | Add 2 cups water, mirepoix base, ¼ tsp. salt, and a pinch of pepper to hot pot. Bring to a simmer. Once simmering, stir occasionally until vegetables are tender, 3-4 minutes. Stir in roasted sweet potato. Remove from burner. While soup simmers, make avocado crema. | In a mixing bowl, combine sour cream, guacamole, and 1 tsp. lime juice. Plate dish as pictured on front of card, topping soup with tortilla strips and avocado crema. Squeeze lime wedges over to taste. Bon appétit!",
                "Bring a small pot with rice and 1½ cups water to a boil. Reduce to a simmer, cover, and cook until rice is tender, 18-20 minutes. Remove from burner and fluff rice. Set aside. While rice cooks, prepare ingredients. | Line a plate with a paper towel. Cut tofu into 1" + "dice and place on towel-lined plate. Top with paper towels, then press gently but firmly to remove excess moisture. Set aside, 5 minutes. While tofu sits, trim and thinly slice white portions of green onions. Thinly slice remaining green onions on an angle. Keep white and green portions separate. Halve lime. Quarter one half and juice other half. Combine slaw mix, white portions of green onions, mayonnaise, 1 tsp. lime juice, 1 tsp. olive oil, and a pinch of salt and pepper in a mixing bowl. Set aside. | Place a medium non-stick pan over medium-high heat and add 2 tsp. olive oil. Pat pineapple rings dry, and add to hot pan. Cook undisturbed until charred, 2-4 minutes per side. Transfer pineapple rings to a clean cutting board. Reserve pan; no need to wipe clean. | Line another plate with a paper towel. In another mixing bowl, toss or gently combine tofu, cornstarch, and a pinch of pepper until tofu is coated. Return pan used to cook pineapple to medium-high heat and add 3 Tbsp. olive oil. Add tofu to hot pan and stir occasionally until golden brown, 6-8 minutes. Don't rush cooking the tofu; it will need the complete cooking time for the correct crispness. Remove from burner. Transfer tofu to towel-lined plate. | Coarsely chop pineapple. Plate dish as pictured on front of card, topping rice with slaw, tofu, and pineapple. Garnish with teriyaki glaze, red pepper flakes (to taste), and green portions of green onions. Squeeze lime wedges over bowl to taste. Bon appétit!",
                "Halve any large butternut squash pieces to roughly match smaller pieces. Combine squash, half the seasoning blend (reserve remaining for walnuts), 2 tsp. olive oil, and ¼ tsp. salt in a mixing bowl until squash is coated. Transfer squash to prepared baking sheet and spread into a single layer on one half. Reserve bowl; no need to wipe clean. Roast in hot oven until mostly tender, 20-25 minutes. While squash roasts, cook pasta. | Once water is boiling, add pasta and cook until al dente, 12-13 minutes. Reserve ½ cup pasta cooking water. Drain pasta in a colander and set aside. While pasta cooks, prepare ingredients. | Coarsely chop spinach. Coarsely chop walnuts. Mince garlic. In bowl used for butternut squash, combine walnuts, 1 tsp. olive oil, and remaining seasoning blend. Set aside. | Carefully place ciabatta in empty space on baking sheet, cut side up. Top ciabatta evenly with 2 tsp. olive oil, garlic, and Parmesan. Baking sheet will be hot! Use an oven mitt. Bake in hot oven until garlic bread is golden brown and squash is tender, 5-7 minutes. While garlic bread and butternut squash bake, finish pasta. | Place a large non-stick pan over medium heat. Add pasta, Alfredo sauce, and ¼ cup pasta cooking water to hot pan. Stir until sauce coats pasta, 1-2 minutes. Stir in spinach until wilted, 1-2 minutes. If sauce is too thick, add additional pasta cooking water, 1 tsp. at a time, until desired consistency is reached. Remove from burner. Plate dish as pictured on front of card, topping pasta with butternut squash, goat cheese (crumbling if necessary), and walnuts. Bon appétit!",
                "Cut potatoes into ½\" wedges and pat dry. Place wedges on prepared baking sheet and toss with 2 tsp. olive oil, seasoning blend, and a pinch of pepper. Massage oil, seasoning blend, and pepper into wedges. Spread into a single layer and roast in hot oven until lightly browned, 15-18 minutes, tossing wedges halfway through. While wedges roast, prepare ingredients. | Coarsely chop mushrooms. Trim and thinly slice green onions, keeping white and green portions separate. Core tomato and cut into ½ rounds. | Place a large non-stick pan over medium-high heat. Add buns to hot, dry pan, cut-side down. Toast buns until golden-brown, 2-3 minutes. Remove buns to a plate. Reserve pan; no need to wipe clean. | Return pan used to toast buns to medium-high heat and add 2 tsp. olive oil. Add mushrooms, white portions of green onions, ¼ tsp. salt, and a pinch of pepper to hot pan. Stir occasionally until mushrooms are browned, 4-6 minutes. Remove from burner. Stir in BBQ sauce until mushrooms are coated. | Plate dish as pictured on front of card, topping bottom bun with tomato, mushroom mixture, cheese, crispy jalapeños (to taste), and top bun. Garnish potatoes with green portions of green onions. Bon appétit!",
                "Place gnocchi on one prepared baking sheet and toss with 1 Tbsp. olive oil. Spread into a single layer and bake in hot oven until crispy, 20-25 minutes, stirring once halfway through. While gnocchi bakes, prepare ingredients. | Stem, seed, remove ribs, and cut red bell pepper into ½\" strips. Peel and halve shallot. Slice halves into thin strips. Halve lemon. Cut one half into wedges and juice the other half. | Place red bell pepper and shallot on second prepared baking sheet and toss with 2 tsp. olive oil and a pinch of salt and pepper. Spread into a single layer and roast in hot oven until beginning to get tender, 12-14 minutes. Carefully remove from oven. Toss or gently stir in peas. Baking sheet will be hot! Use a utensil. Spread into a single layer and roast again until tender, 5-6 minutes. | Mix pesto, 1 Tbsp. lemon juice, seasoning blend, and cream sauce in a mixing bowl until combined. Transfer gnocchi to baking sheet with vegetables and stir or toss to combine. Pour pesto-cream sauce over gnocchi and vegetables and stir until coated. Top evenly with cheese. Roast again in hot oven until cheese is melted, 5-6 minutes. | Plate dish as pictured on front of card, squeezing lemon wedges over to taste. Bon appétit!",
                "Cut sweet potato into ½\" dice. Place sweet potato on prepared baking sheet and toss with 2 tsp. olive oil, ¼ tsp. salt, and a pinch of pepper. Massage oil, salt, and pepper into sweet potatoes. Spread into a single layer and roast in hot oven until tender, 25-30 minutes. While sweet potato roasts, cook rice. | Bring a small pot with 1½ cups water, rice, and a pinch of salt to a boil. Reduce to a simmer, cover, and cook until rice is tender, 18-20 minutes. Remove from burner. Cover and set aside. While rice cooks, prepare ingredients. | If desired, pull strings from snap peas. If string is hard to find and remove, make a very thin cut lengthwise along the string. Quarter lime. Combine garlic sesame sauce, Sriracha (to taste), and 2 Tbsp. water in a mixing bowl. Set aside. | Place a large non-stick pan over medium-high heat. Add 1 tsp. olive oil, snap peas, and carrots to hot pan. Stir constantly until peas are tender but still crisp, 2-4 minutes. Stir in 1 Tbsp. garlic sesame-Sriracha sauce (reserve remaining for sweet potato). Bring to a simmer. Once simmering, cook until sauce thickens slightly, 30-60 seconds. Transfer vegetables to a plate. Reserve pan; no need to wipe clean. Halve avocado and remove pit by carefully tapping pit with the blade of your knife so it sticks. Gently twist knife to release pit. Scoop out the flesh with a spoon. Cut into ¼\" slices. | Return pan used to cook vegetables to medium-high heat. Add sweet potato, remaining garlic sesame-Sriracha sauce, and half the sesame seeds (reserve remaining for garnish) to hot pan. Stir to combine. Bring to a simmer. Once simmering, stir constantly until sauce thickens, 1-2 minutes. Remove from burner. Season with a pinch of salt and pepper. Plate dish as pictured on front of card, placing sweet potato, vegetables, and avocado on rice. Garnish with remaining sesame seeds. Squeeze lime wedges over meal to taste. Bon appétit!",
                "Bring a small pot with rice, seasoning blend, enchilada sauce, and 1 cup water to a boil. Reduce to a simmer, cover, and cook until rice is tender, 14-17 minutes. Remove from burner and set aside. While rice cooks, prepare ingredients. | Core tomatoes and cut into ½\" dice. Coarsely chop cilantro (no need to stem). Halve and juice lime. Drain black beans in a wire-mesh strainer and rinse. Stem poblano peppers, halve lengthwise, and seed. Poblano peppers can vary in spice level; most are mild, but a few can be quite hot. Wash hands and cutting board after prepping. | Place poblano peppers on prepared baking sheet, cut side down. Spray with cooking spray and season with a pinch of salt. Roast in hot oven until peppers are tender, but not completely cooked, 10-12 minutes. Don't worry if peppers char a bit; this adds flavor to the dish. | In a mixing bowl, combine rice, ⅔ the cheese (reserve remaining for topping), beans, 1 tsp. lime juice (reserve remaining for pico de gallo), and ¼ tsp. salt. Carefully, flip peppers cut-side up and fill halves evenly with rice-beans mixture. Top with remaining cheese. Roast in hot oven until cheese is melted, 5-7 minutes. While peppers roast, make pico de gallo. | In another mixing bowl, combine tomatoes, cilantro, 1 Tbsp. remaining lime juice, 1 tsp. olive oil, and ¼ tsp. salt. Plate dish as pictured on front of card, garnishing with pico de gallo and sour cream. Bon appétit!",
                "Line a plate with a paper towel. Cut tofu into 1\" dice. Place on towel-lined plate, and top with more paper towels and a second plate. Set aside to press, at least 10 minutes. While tofu presses, prepare ingredients. | Mince cilantro (no need to stem). Coarsely chop pineapple. Trim and thinly slice white portions of green onions. Thinly slice remaining green onions on an angle. Keep white and green portions separate. Stem jalapeño, halve, seed, remove ribs, and mince. Wash hands and cutting board after working with jalapeño. | Combine pineapple, jalapeño (to taste), white portions of green onions, cilantro, 1 tsp. olive oil, and a pinch of pepper in a mixing bowl. Set aside to allow flavors to marry. | In another mixing bowl, toss or gently combine tofu, cornstarch, and a pinch of salt until tofu is completely coated. Place a large non-stick pan over medium-high heat and add 3 Tbsp. olive oil. Add tofu to hot pan and stir occasionally until golden brown, 6-8 minutes. Don't rush cooking the tofu; it will need the complete cooking time for the correct crispness. Remove from burner. Transfer tofu to another mixing bowl and toss or gently combine with half the seasoning blend. Taste, and add remaining seasoning blend if desired. | Wrap tortillas in a damp paper towel and microwave until warm, 30-60 seconds. Alternatively, place a medium non-stick pan over medium-high heat. Add tortillas, one at a time, to hot, dry pan. Heat undisturbed, 30-45 seconds per side. Remove from pan. Plate dish as pictured on front of card, filling tortillas with tofu and drizzling with teriyaki glaze. Top with pineapple salsa and garnish with green portions of green onions. Bon appétit!",
                "Using a spoon, scoop out black undersides (gills) of portobello mushrooms. Remove stems. Reserve 1 Tbsp. flour and set aside. Place remaining flour , ⅓ cup water, and a pinch of salt in a mixing bowl and stir until a thin batter forms, like a pancake batter. If too thick, stir in 1 tsp. water until desired consistency is reached. Place panko on a plate. Dip mushrooms in batter, coating completely. Then transfer to plate with panko, gently flipping until coated. | Once water is boiling, add pasta and cook until al dente, 8-10 minutes. Reserve ½ cup pasta cooking water. Drain in a colander and rinse with cold water. Set aside. While pasta boils, cook mushrooms. | Line a plate with a paper towel. Place a medium non-stick pan over medium heat and add canola oil. Let heat, 5 minutes. After 5 minutes, test oil temperature by adding a pinch of flour batter to it. It should sizzle gently. If it browns immediately, turn heat down and let oil cool. If it doesn't brown, increase heat. Cooking in batches if necessary, add mushrooms to hot oil and cook until golden brown, 2-3 minutes per side. Remove from burner. Transfer mushrooms to towel-lined plate and season with a pinch of salt. | Place another medium non-stick pan over medium heat and add 2 tsp. olive oil. Add reserved 1 Tbsp. flour to hot pan and stir until no dry flour remains in pan. Add half the reserved pasta cooking water, cream cheese, pesto, and ½ tsp. salt. Bring to a simmer. Once simmering, stir until creamy, combined, and starting to thicken, 2-3 minutes. Stir in cooked pasta. Remove from burner. If too thick, add remaining pasta cooking water, 1 Tbsp. at at time, until desired consistency is reached. | Halve mushroom if desired. Plate dish as pictured on front of card, topping pasta with mushroom and garnishing with Parmesan and red pepper flakes (to taste). Bon appétit!",
        };

        String[] vegetarianMainImages = {
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F15050%2F941087.001.01CheesySmokedGoudaPortobelloFlautas_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=1369f3f89f45a7eb0ff4600fb08da31a",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F16195%2F4796MexicaliCheesyPenneReshoot2__1_of_1_-54f622992f618a012c460efb5c04560b-54f622992f618a012c460efb5c04560b.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=245d8871e90e7cc0243c35312e5d2dbf",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F16199%2F005085.002.01PearAndBlueCheesePizza_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=89959e0c8f39fe7aeaf8ddbc75895ecc | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F16199%2F5085PearandBlueCheesePizzaSteps__1_of_5_2.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=f91af049d7ced52a70208f0b06c37eef",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14929%2F480689.001.01CheeseTortelliniPeperonata_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=06fffea19a81ebdc43700c84d8ee326c",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F16464%2F6720Mushroomkalebiscuitpie_Ecomm__1_of_1_-c516cfad1cd7036aca8e409ebd2b4400-c516cfad1cd7036aca8e409ebd2b4400.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=92471a46e338e448b42e3e65afe8b56a",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14737%2F880027.001.01CrispyTofuAndTzatzikiGyros_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=627ee7c77dd5de3d410d7b0795c870da | ",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F13343%2F5078ElotesRisotto__1_of_1_-9dcef3de4c58362183db19a5835c3818-9dcef3de4c58362183db19a5835c3818.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=3164b3342eddd634024d6bb8d0fb0bd2 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F13343%2F005078TortillaElotesRisottoINGStep1%252B2Final.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=478fb0801f1625dfbfe1d2a95f5fbf0a",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14770%2F3526TeriyakiCharredBroc_Shiitake__1_of_1_-ea204baed03ae5ca67eaf869f42c971d-ea204baed03ae5ca67eaf869f42c971d.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=067da517af1fe0b7af41043707ee2379 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F14770%2F003526TeriyakiCharredBroccoliandShiitakeMushroomsINGFinal2.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=822a183f795237ac5a47c03fccca6ea2",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14787%2F499181.001.01SesameTeriyakiImpossibleBurger_Ecomm2_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=f378ea19692a2ed2252bb3289e4da4d7",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F13155%2F451756.001.01SpinachAndArtichokeRisotto_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=6ccef495c34830aa36bc16214918a1d2",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F13149%2F743365.001.01ButternutSquashWhiteLasagnaSkillet_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=9f31ad0848dd3f36b483da3087ffdfcd",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14918%2F909746.001.01SpicyOrangeBrusselsSproutsFritters_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=e966013132df9292da664f6b19268ad5",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14478%2F6728RoastedSweetPotatoTortillaSoup_Ecomm__1_of_1_-1bfae04c51db8edab3854e44f7374f14-1bfae04c51db8edab3854e44f7374f14.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=8acc301ca41b173e0d100239f2df23d5 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F14478%2F6728RoastedSweetPotatoTortillaSoupStepsFinal.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=de50e071d7827b898ca9faaad774b3af",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F15145%2F006730.003.01HuliHuliTofuRiceBowl_Ecomm_copy.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=af98297c438b3c38edcef547e13e07fd",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F15162%2F006379ButternutSquashAlfredoPenne_Ecomm.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=0a91a2272127ec254636904c190c3687 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F15162%2F006379ButternutSquashAlfredoPenneStepsFinal.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=d3691adca70191dfea9e0c2dd7fed5eb",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F11908%2F157001.001.01Smoky-SweetMushroomSandwich_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=38634eafc2fe508204b8499ac050e583",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14774%2F830198.001.01Oven-RoastedGnocchiWithPestoCream_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=cd28a822737207641f0f1bdaa254c76e",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F15143%2F3952SrirachaSweetPotatoes_Avocado3__1_of_1_-1436821a0f1b565813c7f7cb88c208d8-1436821a0f1b565813c7f7cb88c208d8.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=8dd3423b287fa916689f2cd9fac9f5a3 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F15143%2F3952SesameSweetPotatoesandAvocadoStepsReshootFinal-014899305f75d4100ae3d91512089859-014899305f75d4100ae3d91512089859.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=dd547e309380763735833418c30806bd",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F12747%2F6114CheesySpanishRiceStuffedPoblanosFinal-3c8be90564b52eeee550228d96585cba-3c8be90564b52eeee550228d96585cba.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=f19b105a340683e6215e75676a86645e | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fsupply%2F12747%2F6114CheesySpanishRiceStuffedPoblanosStepsFinal-2-6079effe6828a04594f788ea3c9afd16-6079effe6828a04594f788ea3c9afd16.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=ca310ec57f2e7563c73ba8dd7be6700c",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F11082%2F5370CrispyTeriyakiTofuTacos__1_of_1_-a4726a84387af0f28545dd48e780e7eb-a4726a84387af0f28545dd48e780e7eb.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=f56c134370708d6a0496a2231283b6cb",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14919%2F655155.001.01CrispyPortobelloParmesan_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=850&auto=format&s=4194de0f2de306e20352a50fa547b52f"
        };

        String[] vegetarianRecipeImages = {
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F57847%2F941087.001.01Philly-StyleCheesePortobelloFlautasWithSmokedGoudaCheeseSauce_StepShots.JPG?ixlib=rails-1.1.0&w=1500&auto=format&s=1ab998927a34b3c58263dd2a48ae727b | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F57848%2F941087.001.01Philly-StyleCheesePortobelloFlautasWithSmokedGoudaCheeseSauce_StepShots-2.JPG?ixlib=rails-1.1.0&w=1500&auto=format&s=eb73ea5221a9fd54f2403ecb0cfc526d | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F57849%2F941087.001.01Philly-StyleCheesePortobelloFlautasWithSmokedGoudaCheeseSauce_StepShots-3.JPG?ixlib=rails-1.1.0&w=1500&auto=format&s=4fe37defa424573d6422c15a4afd498f | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F57850%2F941087.001.01Philly-StyleCheesePortobelloFlautasWithSmokedGoudaCheeseSauce_StepShots-4.JPG?ixlib=rails-1.1.0&w=1500&auto=format&s=29c62646942b5aa82bb7060352e7a2bf | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F57851%2F941087.001.01Philly-StyleCheesePortobelloFlautasWithSmokedGoudaCheeseSauce_StepShots-5.JPG?ixlib=rails-1.1.0&w=1500&auto=format&s=a24b85cc45d5ef735b8937643d0b2c72",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59454%2F4796MexicaliMacandCheeseSteps__2_of_5_-dff01d6e0e51eafbc01672cbd55295da-dff01d6e0e51eafbc01672cbd55295da.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=3d92ff8c121605ac76798082c8863d73 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59455%2F4796MexicaliMacandCheeseSteps__1_of_5_.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=e8b3ada88aff646cbe21694c475e5466 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59457%2F4796MexicaliMacandCheeseSteps__3_of_5_-0f045ba229ba741863af47ed5e4b3c6e-0f045ba229ba741863af47ed5e4b3c6e.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=75d36a77e038696963a94c5d4a296d69 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59459%2F4796MexicaliMacandCheeseSteps__4_of_5_-84955987ba25ab4db3b193a3406dbf9e-84955987ba25ab4db3b193a3406dbf9e.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=56c6afd9ce4c79d377d310f31d4e9bde | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F16195%2F4796MexicaliCheesyPenneReshoot2__1_of_1_-54f622992f618a012c460efb5c04560b-54f622992f618a012c460efb5c04560b.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=2f0e163dbd51247cae6790ad4107f0f2",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59479%2F5085PearandBlueCheesePizzaSteps__4_of_5_-c3df63603add0021e198e3199c896eae-c3df63603add0021e198e3199c896eae.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=126a73132f1d6ab2c9fcea7874591a2a | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59480%2F5085PearandBlueCheesePizzaSteps__2_of_5_-71782d1aa25b266e597d9aa0ee7e02c6-71782d1aa25b266e597d9aa0ee7e02c6.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=a713608c023ffe898c1e468b2366a9ee | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59481%2F5085PearandBlueCheesePizzaSteps__3_of_5_-a38936afb9aaa546bdf835ab2c16b025-a38936afb9aaa546bdf835ab2c16b025.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=672233ca2033f2daef9c068bc79e3567 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F59482%2F5085PearandBlueCheesePizzaSteps__5_of_5_-b2c9448d910edd5ede763460fd7b8578-b2c9448d910edd5ede763460fd7b8578.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=8cbfb9758b90b0d89af96522fcc731fc | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F16199%2F005085.002.01PearAndBlueCheesePizza_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=1500&auto=format&s=1a4b492b32ab83f663cef1eb1e379047",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56288%2F480689.001.01CheeseTortelliniPeperonata_StepShots.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=b3adfc117bed517df7340ea506f0dfa1 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56289%2F480689.001.01CheeseTortelliniPeperonata_StepShots-2.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=29bdadced96f1d69642f4bd98288bad6 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56291%2F480689.001.01CheeseTortelliniPeperonata_StepShots-4.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=0b616219f97d268cfc91fe8c0762df50 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56290%2F480689.001.01CheeseTortelliniPeperonata_StepShots-3.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=a9d9d4e4f1a68eb5e612718c29fab745 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14929%2F480689.001.01CheeseTortelliniPeperonata_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=2d1c8ee1b1b23a367107b082d130c257 | ",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F60190%2F6720CreamyMushroomandKaleWhiteCheddarBiscuitPieStepsFinal-2.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=cba7220cdf1491dbe7d462ee6afd7bae | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F60191%2F6720CreamyMushroomandKaleWhiteCheddarBiscuitPieStepsFinal-3.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=f4c464ca47ec28b7d402cf0da735e9bf | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F60192%2F6720CreamyMushroomandKaleWhiteCheddarBiscuitPieStepsFinal-4.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=26b130b99b170d208344b3b9f22c990f | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F60193%2F6720CreamyMushroomandKaleWhiteCheddarBiscuitPieStepsFinal-5.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=4b83e8057e39f56661e2cd63f3fd73a7 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F60194%2F6720CreamyMushroomandKaleWhiteCheddarBiscuitPieStepsFinal-6.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=be2c190c5934c5798b288f15b888b505",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56578%2F880027.001.01CrispyTofuAndTzatzikiGyros_StepShots.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=365e19f794810bfba636fc697afa686c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56579%2F880027.001.01CrispyTofuAndTzatzikiGyros_StepShots-2.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=38d2bae39b461e42d46ae36f366fd855 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56580%2F880027.001.01CrispyTofuAndTzatzikiGyros_StepShots-3.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=d72f0c16286dcbf805f2ff63debc5c41 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56581%2F880027.001.01CrispyTofuAndTzatzikiGyros_StepShots-4.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=a67bdd7711c9d16171339006900c377a | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14737%2F880027.001.01CrispyTofuAndTzatzikiGyros_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=98830c62bdfc43db3c83649c796531eb",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50063%2F005078TortillaElotesRisottoINGStep1%252B2Final-2.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=21e5c4b8f065c5e78234ea1282851021 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50064%2F005078TortillaElotesRisottoINGStep1%252B2Final-3.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=c50ba6018a2bb9e59a6976e8b8bedc48 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50065%2F5078TortillaElotesRisottoStepsFinal-4.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=8b83fd0e94b297e466a42118f0c47050 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50066%2F5078TortillaElotesRisottoStepsFinal-5.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=f5713437ce468a4b502f22c4cfc4895b | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F13343%2F5078ElotesRisotto__1_of_1_-9dcef3de4c58362183db19a5835c3818-9dcef3de4c58362183db19a5835c3818.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=5c1f4896a7e5fc6524281cafedce5919",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54922%2Fhomechef_Teriyaki_Charred_Broccoli_and_Sesame_Noodles__2_of_10_-078ce3394a22fa9fc15a4d8e5216ea03-078ce3394a22fa9fc15a4d8e5216ea03.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=887514930f8652f39f1ac9ef6adf5da3 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54923%2Fhomechef_Teriyaki_Charred_Broccoli_and_Sesame_Noodles__7_of_10_-17b1c8b80dd4e0d89d1cc73b9f4461b0-17b1c8b80dd4e0d89d1cc73b9f4461b0.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=7387ae292720a8d77c03cd680e09076e | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54924%2Fhomechef_Teriyaki_Charred_Broccoli_and_Sesame_Noodles_Step__1_of_1_-17701632a790d39245aa555ca25a1de3-17701632a790d39245aa555ca25a1de3.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=e21174aca58d705acfc2b2e53474fecb | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54925%2Fhomechef_Teriyaki_Charred_Broccoli_Noodles_Step__1_of_1_-c88affc285cbe04b53fa865a9199d00f-c88affc285cbe04b53fa865a9199d00f.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=820e9458d610d386ee3be30ef0065819 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14770%2F3526TeriyakiCharredBroc_Shiitake__1_of_1_-ea204baed03ae5ca67eaf869f42c971d-ea204baed03ae5ca67eaf869f42c971d.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=a8a4b72cc6839facc273eb062fbfbf22",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55627%2F499181.001.01SesameTeriyakiImpossibleBurger_StepShots-2.JPG?ixlib=rails-1.1.0&w=750&auto=format&s=9542c9752b167495ea2fda04590cbf6b | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55628%2F499181SesameTeriyakiImpossibleBurgerStepShotsFinal_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=a97c7fa3dfa40f8e63ded8cf41dfb887 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55629%2F499181SesameTeriyakiImpossibleBurgerStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=6516ab8d16c7a6500086016a05b4b8f7 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55630%2F499181SesameTeriyakiImpossibleBurgerStepShotsFinal-3_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=4c7c5f792b173f501605cd41488c7536 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55631%2F499181SesameTeriyakiImpossibleBurgerStepShotsFinal-5_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=13bd186822a081dfa023d27d6ffd5c6e",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50497%2F451756SpinachandArtichokeRisottoStepShotsFinal_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=23369101b7deb108c9ee5364e005c00c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50498%2F451756SpinachandArtichokeRisottoStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=c44c50cfc6380f09bbebb5b69679931c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50499%2F451756SpinachandArtichokeRisottoStepShotsFinal-3_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=f85369301ff0bcf2e9fc440a19be1873 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50500%2F451756SpinachandArtichokeRisottoStepShotsFinal-4_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=68f098d2cc708d40e9c26c3d9be87db0 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F13155%2F451756.001.01SpinachAndArtichokeRisotto_Ecomm_1_of_1_.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=c613239f0957d3a28c9631fd55859984",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F52896%2F743365Step1Reshoot-2.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=3de28ecb88b15459f143351e11204c3a | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F50498%2F451756SpinachandArtichokeRisottoStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=c44c50cfc6380f09bbebb5b69679931c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F52898%2F743365ButternutSquashWhiteLasagnaSkilletStepShotsFinal-3_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=bd9d8e674cff3c557f7ca9f6dc207113 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F52899%2F743365ButternutSquashWhiteLasagnaSkilletStepShotsFinal-4_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=6689ec0315fe0519dce1c909aba566e0 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F52900%2F743365ButternutSquashWhiteLasagnaSkilletStepShotsFinal-5_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=427feeda93e537e4340e495fdb262576",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55861%2F909746SpicyOrangeBrusselsSproutsFrittersReshootFinal_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=580fb5343ad3f3f2c8053126ed2dfc5e | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55862%2F909746SpicyOrangeBrusselsSproutsFrittersReshootFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=a704d741413a3c2f13b67b514379a8d4 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55860%2F909746SpicyOrangeBrusselsSproutsFrittersStepShotsFinal_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=33c2ead7124768481c6edb064cb3550c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F55858%2F909746SpicyOrangeBrusselsSproutsFrittersStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=ba175cd3b60339e0475f4598e2ace8f2 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14918%2F909746.001.01SpicyOrangeBrusselsSproutsFritters_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=45e6fc0b9f3f1cfeb1796c742f7c69aa",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54004%2F6728RoastedSweetPotatoTortillaSoupStepsFinal-3-5caf07e37a65938d8379d85ed0caa943-5caf07e37a65938d8379d85ed0caa943.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=3e55982e63433eca281358f622160204 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54005%2F6728RoastedSweetPotatoTortillaSoupStepsFinal-2.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=db373f4dc2bd3022c6aa8f0080a32ad5 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54006%2F6728RoastedSweetPotatoTortillaSoupStepsFinal-4-ae2f9330f8638bdc2e0c0eff6743d00d-ae2f9330f8638bdc2e0c0eff6743d00d.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=e9e3aea7bce4223d2491a5ad8fbb2c69 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54007%2F6728RoastedSweetPotatoTortillaSoupStepsFinal-5-f045f41c5a30d37fee85deea79e67034-f045f41c5a30d37fee85deea79e67034.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=41ef074d2414b40b59361fcaefd98160 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F54008%2F6728RoastedSweetPotatoTortillaSoupStepsFinal-6-d223f7953195c94accbd3ff2237c881d-d223f7953195c94accbd3ff2237c881d.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=b611e5dd152d4dce0206c8beaaaa8e70",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56173%2F5840ShrimpFlorentinePastaStepsReshoot__5_of_6_.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=fcdb2bba8e4ecda80f7d99244714253c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56174%2F6730HuliHuliTofuRiceBowlStepsFinal-2.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=ff88b5e3b4cd19bb4cf5bdd1c97d6005 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56175%2F6730HuliHuliTofuRiceBowlStepsFinal-3.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=e7385026c5c470a8b7836a97d7d4f4e2 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56176%2F5840ShrimpFlorentinePastaStepsReshoot__3_of_6_.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=f4026d9bc2978bfc4d937d2dad01d8a2 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F15145%2F006730.003.01HuliHuliTofuRiceBowl_Ecomm_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=4afc5f1b2e42a6b8aaa25b776bede12d",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56244%2F006379ButternutSquashAlfredoPenneStepsFinal-2.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=b0730c14655fd477ea7d334bd92954bf | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56245%2FPenne_with_pasta_water.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=d9a0e0363f8ff8c0c52e7724464e6335 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56246%2F006379ButternutSquashAlfredoPenneStepsFinal-3.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=0908492bd5eae74d45ca8a2ad58385da | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56247%2F006379ButternutSquashAlfredoPenneStepsFinal-4.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=b7a3ca088acae80fb8315fca6a4b16fa | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56248%2F006379ButternutSquashAlfredoPenneStepsFinal-5.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=faec08d8afb4517017252b90c910822a",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F48659%2F157001SmokySweetMushroomSandwichStepShotsFinal-3_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=8136d472e05c5d23a46100c98168eccc | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F48658%2F157001SmokySweetMushroomSandwichStepShotsFinal_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=45c7556c98991e5f92aa266070258b2c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F48660%2F157001SmokySweetMushroomSandwichStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=7bffe747f66f8e32bbbbb5ed62283616 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F48661%2F157001SmokySweetMushroomSandwichStepShotsFinal-4_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=2250defe195e754d666b66d2bb51d749 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F11908%2F157001.001.01Smoky-SweetMushroomSandwich_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=31ed0bfe3001e8229b1f3d6f50a7b18f",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56274%2F830198OvenRoastedGnocchiwithPestoCreamStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=572884e9bf18c59e6d28c9eb94dfe9dd | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56273%2F830198Step2Edit_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=326ef4facc705ab66e46cdea9393950c | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56275%2F830198OvenRoastedGnocchiwithPestoCreamStep3Final_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=89d47bb8b982a025e1b209f8a4110fc6 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56276%2F830198OvenRoastedGnocchiwithPestoCreamStepShotsFinal-3_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=6c8e68a619228d8d77133353c80a4b96 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14774%2F830198.001.01Oven-RoastedGnocchiWithPestoCream_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=6de2cc7a13f9e8971e1ebd8851efbfee",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56163%2F3952SesameSweetPotatoesandAvocadoStepsReshootFinal-6-cd4a194cf7e5a48f8748f9630f0a6c58-cd4a194cf7e5a48f8748f9630f0a6c58.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=5f2305b432c3e2093b65e6a02883fb34 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56164%2F3952SesameSweetPotatoesandAvocadoStepsReshootFinal-4-59030358c923f7f863a7257b14145300-59030358c923f7f863a7257b14145300.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=4cab371197bafdfc7461b0ee98bfa5cc | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56165%2F003952SesameSweetPotatoesandAvocadoStep2Final.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=2f52582b44704ede7ca977f9daadd945 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56166%2F3952SesameSweetPotatoesandAvocadoStepsReshootFinal-3-17cbc918fa4e7cab3dd1ceb4923a78ec-17cbc918fa4e7cab3dd1ceb4923a78ec.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=b5addbebfc83f6fc0e5d9c82474599e9 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56168%2F3952SesameSweetPotatoesandAvocadoStepsReshootFinal-5-0404f58bfd0c6c6f8a60131addf0ca1f-0404f58bfd0c6c6f8a60131addf0ca1f.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=452eaf14e2461395363b0d213d73a085",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F47741%2F6114CheesySpanishRiceStuffedPoblanosStepsFinal-4-20d775b12ac5f58293474c5546300638-20d775b12ac5f58293474c5546300638.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=0bae6cb349ae3444c9de5eb5ab8f3cd5 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F47742%2F6114CheesySpanishRiceStuffedPoblanosStepsFinal-3-1a1ccaf451701959e2ce01b642bbee41-1a1ccaf451701959e2ce01b642bbee41.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=1541227c9112eede6f03e3a30b4b257b | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F47743%2F6114CheesySpanishRiceStuffedPoblanosStepsFinal-5-b45319c93d225cd4ea6a88f526c1b58a-b45319c93d225cd4ea6a88f526c1b58a.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=a2bca36c1ee0f22a32579c546aa6bdea | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F47744%2F6114CheesySpanishRiceStuffedPoblanosStepsFinal-6c4f9f4ab07b6deda974665493ca0097-6c4f9f4ab07b6deda974665493ca0097.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=2bf8886ed6377b2ec4fedc1932e668ee | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F47745%2F6114CheesySpanishRiceStuffedPoblanosStepsFinal-6-c4e128a27625584c78e9ea149f83746b-c4e128a27625584c78e9ea149f83746b.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=1bc9c81a24c2745191b304b8f720f8f3",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F42308%2F5370CrispyTeriyakiTofuTacosFinal__2_of_6_-6163c0e4ec067324bbcc07e0ea408386-6163c0e4ec067324bbcc07e0ea408386.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=9698f9fc7d8aa6e924366a11b91594f7 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F42309%2F5370CrispyTeriyakiTofuTacosFinal__3_of_6_-f7b7685e084ad94bfe40b481c319a0c8-f7b7685e084ad94bfe40b481c319a0c8.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=0639a4cb316828b44aebdb49862ab320 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F42310%2F5370CrispyTeriyakiTofuTacosFinal__4_of_6_-5f792362e5af67a432a36a88753f1eb4-5f792362e5af67a432a36a88753f1eb4.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=f5e0be1634ccbd7cde4953af7732158a | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F42311%2F5370CrispyTeriyakiTofuTacosFinal__5_of_6_-08e4c5debac3adb5275527acda1c1a78-08e4c5debac3adb5275527acda1c1a78.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=73ece3481bd0e549ec6a95313c7267f5 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F42312%2F4975GrilledChickenGyroTacosSteps__6_of_6_-7285a39f3f576d9327ee9e5cce3356d1-7285a39f3f576d9327ee9e5cce3356d1.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=2d728b733ebb5d9914775b09442a3a35",
                "https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56257%2F655155Step1Edit.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=521564ae8205440cdecc9fb0372e873b | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56284%2F655155CrispyPortobelloParmesanStepShotsFinal-2_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=75fd8d65dadb313439e44753b5495fba | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56285%2F655155CrispyPortobelloParmesanStepShotsFinal-3_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=7ce478c6bd8db09c278f459144904c3a | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Frecipe%2Fimage%2F56286%2F655155CrispyPortobelloParmesanStepShotsFinal-4_copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=e9c38345a4332d82307c5d9b58afb376 | https://homechef.imgix.net/https%3A%2F%2Fasset.homechef.com%2Fuploads%2Fmeal%2Fplated%2F14919%2F655155.001.01CrispyPortobelloParmesan_Ecomm_1_of_1__copy.jpg?ixlib=rails-1.1.0&w=750&auto=format&s=cc3e4d5113263f77483502dbae5dd39b",

        };

        String[] vegetarianCustomizeOptions = {
                "No Protein | Ground Beef | USDA Choice Sliced Flank Steak | Impossible Burger | Boneless Skinless Chicken Breasts",
                "Boneless Skinless Chicken Breasts | No Protein | Impossible Burger | USDA Choice Sliced Flank Steak | Ground Beef",
                "No Protein | Impossible Burger | USDA Choice Sliced Flank Steak | Diced Boneless Skinless Chicken Breasts | Steak Strips",
                "Diced Boneless Skinless Chicken Breasts | Shrimp | USDA Choice Sliced Flank Steak | Impossible Burger | No Protein",
                "Antibiotic-Free Boneless Skinless Chicken Breasts | Diced Boneless Skinless Chicken Breasts | Organic Boneless Skinless Chicken Breasts | No Protein",
                "Antibiotic-Free Boneless Skinless Chicken Breasts | Diced Boneless Skinless Chicken Breasts | Organic Boneless Skinless Chicken Breasts | No Protein",
                "Shrimp | Impossible Burger | Boneless Skinless Chicken Breasts | USDA Choice Sliced Flank Steak | No Protein",
                "Impossible Burger | USDA Choice Sliced Flank Steak | Shrimp | No Protein | Boneless Skinless Chicken Breasts",
                "Impossible Burger | Ground Turkey | Ground Pork",
                "No Protein | Filets Mignon | Boneless Skinless Chicken Breasts | Salmon Fillets",
                "Salmon Fillets | USDA Choice New York Strip Steak (1 Steak, Serves 2) | Beyond Sausage Hot Italian Links | Boneless Skinless Chicken Breasts | No Protein",
                "No Protein | USDA Choice New York Strip Steak (1 Steak, Serves 2) | Salmon Fillets | Boneless Skinless Chicken Breasts",
                "No Protein | Diced Boneless Skinless Chicken Breasts | Impossible Burger",
                "No Protein | Diced Boneless Skinless Chicken Breasts | Impossible Burger",
                "Shrimp | Diced Boneless Skinless Chicken Breasts | USDA Choice Sliced Flank Steak | Impossible Burger | No Protein",
                "Impossible Burger | USDA Choice Sliced Flank Steak | Diced Boneless Skinless Chicken Breasts | No Protein",
                "Salmon Fillets | USDA Choice Boneless Ribeye Steak (1 Steak, Serves 2) | Antibiotic-Free Boneless Skinless Chicken Breasts | Boneless Skinless Chicken Breasts | No Protein",
                "USDA Choice Sliced Flank Steak | Boneless Skinless Chicken Breasts | Shrimp | No Protein | Impossible Burger",
                "Diced Boneless Skinless Chicken Breasts | No Protein | Beyond Sausage Hot Italian Links | Shrimp",
                "Impossible Burger | Ground Chicken | USDA Choice Sliced Flank Steak | No Protein",
                "Impossible Burger | USDA Choice Sliced Flank Steak | Shrimp | Ground Chicken | No Protein"
        };


        for (int i = 0; i < 21; i++) {
            Meal meal = new Meal();
            meal.setMealName(vegetarianMealNames[i]);
            meal.setMealDescription(vegetarianMealDescriptions[i]);
            meal.setMealTimeTag(vegetarianMealTimeTags[i]);
            meal.setMealIngredientTag(vegetarianMealIngredientsTags[i]);
            meal.setPrice(6.99);
            Optional<MealCategory> vegetarianMealCategory = mealCategoryRepository.findMealCategoryByCategory("Vegetarian");
            meal.setMealCategory(vegetarianMealCategory.get());
            mealRepository.save(meal);

            MealOverview mealOverview = new MealOverview();
            if (vegetarianMealDifficultyLevel[i] == 1) {
                mealOverview.setDifficultyLevel(DifficultyLevelEnum.ONE);

            } else if (vegetarianMealDifficultyLevel[i] == 2) {
                mealOverview.setDifficultyLevel(DifficultyLevelEnum.TWO);

            } else if (vegetarianMealDifficultyLevel[i] == 3) {
                mealOverview.setDifficultyLevel(DifficultyLevelEnum.THREE);
            }

            if (vegetarianMealSpiceLevel[i] == 1) {
                mealOverview.setSpiceLevel(SpiceLevelEnum.ONE);

            } else if (vegetarianMealDifficultyLevel[i] == 2) {
                mealOverview.setSpiceLevel(SpiceLevelEnum.TWO);

            } else if (vegetarianMealDifficultyLevel[i] == 3) {
                mealOverview.setSpiceLevel(SpiceLevelEnum.THREE);
            } else {
                mealOverview.setSpiceLevel(SpiceLevelEnum.ONE);
            }

            mealOverview.setCookWithin(vegetarianCookWithin[i]);
            mealOverview.setPrepCookTime(vegetarianMealTimeTags[i]);

            mealOverview.setMeal(meal);
            mealOverviewRepository.save(mealOverview);

            MealChef mealChef = new MealChef();
            mealChef.setFullName(vegetarianChefName);
            mealChef.setChefMealDescription(vegetarianChefMealDescription[i]);
            mealChef.setMeal(meal);
            mealChefRepository.save(mealChef);

            MealBox mealBox = new MealBox();
            mealBox.setMealIngredients(vegetarianMealIngredients[i]);
            mealBox.setServeQuantity(vegetarianServeQuantity);

            mealBox.setMeal(meal);
            mealBoxRepository.save(mealBox);

            MealBoxNutrition mealBoxNutrition = new MealBoxNutrition();
            mealBoxNutrition.setCalories(vegetarianCalories[i]);
            mealBoxNutrition.setProtein(vegetarianProtein[i]);
            mealBoxNutrition.setCarbohydrates(vegetarianCarbohydrates[i]);
            mealBoxNutrition.setFat(vegetarianFat[i]);

            mealBoxNutrition.setMeal(meal);
            mealBoxNutritionRepository.save(mealBoxNutrition);

            RecipeSteps recipeSteps = new RecipeSteps();
            recipeSteps.setMealUtensilsRow1(vegetarianMealUtensilsRow1[i]);
            recipeSteps.setMealUtensilsRow2(vegetarianMealUtensilsRow2[i]);

            recipeSteps.setMeal(meal);
            recipeStepsRepository.save(recipeSteps);

            RecipeInstructions recipeInstructions = new RecipeInstructions();

            recipeInstructions.setCookSteps(vegetarianCookSteps[i]);

            recipeInstructions.setGuidelines(guidelines);

            recipeInstructions.setCustomizeInstructions(vegetarianCustomizeOptions[i]);

            recipeInstructions.setMeal(meal);
            recipeInstructionsRepository.save(recipeInstructions);

            CookingSteps cookingSteps = new CookingSteps();

            cookingSteps.setStepNumber(1);

            cookingSteps.setStepTitle(vegetarianStepTitles[i]);

            cookingSteps.setStepDescription(vegetarianStepDescription[i]);

            cookingSteps.setMeal(meal);
            cookingStepsRepository.save(cookingSteps);

//
            String[] mainImages = vegetarianMainImages[i].split("\\|");
            Image mainImg = new Image(mainImages[0].trim(), vegetarianMealNames[i].trim(), false, true, 9999);
            mainImg.setMeal(meal);


//            for (String mainImage : mainImages) {
//                Image mainImg = new Image(mainImage.trim(), vegetarianMealNames[i].trim(), false, true, 9999);
//                mainImg.setMeal(meal);
//                imageRepository.save(mainImg);
//
//            }
            Image image2 = new Image("", "Chef Img", true, false, 9999);

            String[] cookStepImages = vegetarianRecipeImages[i].split("\\|");
            String[] stepTitles = vegetarianStepTitles[i].split("\\|");

            Image imageCookStep1 = new Image(cookStepImages[0].trim(), stepTitles[0].trim(), false, false, 1);
            Image imageCookStep2 = new Image(cookStepImages[1].trim(), stepTitles[1].trim(), false, false, 2);
            Image imageCookStep3 = new Image(cookStepImages[2].trim(), stepTitles[2].trim(), false, false, 3);
            Image imageCookStep4 = new Image(cookStepImages[3].trim(), stepTitles[3].trim(), false, false, 4);
            Image imageCookStep5 = new Image(cookStepImages[4].trim(), stepTitles[4].trim(), false, false, 5);

            image2.setMeal(meal);
            imageCookStep1.setMeal(meal);
            imageCookStep2.setMeal(meal);
            imageCookStep3.setMeal(meal);
            imageCookStep4.setMeal(meal);
            imageCookStep5.setMeal(meal);

            List<Image> images = Arrays.asList(mainImg, imageCookStep1, imageCookStep2, imageCookStep3, imageCookStep4, imageCookStep5);
            imageRepository.saveAll(images);

            MealCustomizeOption option = new MealCustomizeOption();
            option.setMealCustomizeOption(vegetarianCustomizeOptions[i]);
            option.setMeal(meal);

            mealCustomizeOptionRepository.save(option);

        }


        System.out.println("DONEEE");

    }

//    SendEmail sendEmail = new SendEmail();


}
