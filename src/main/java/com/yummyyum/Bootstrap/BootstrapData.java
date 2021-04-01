package com.yummyyum.Bootstrap;

import com.yummyyum.Model.*;
import com.yummyyum.Model.MealOverviewEnum.DifficultyLevelEnum;
import com.yummyyum.Model.MealOverviewEnum.SpiceLevelEnum;
import com.yummyyum.Model.MealRecipe.*;
import com.yummyyum.Repositories.*;
import com.yummyyum.Repositories.MealRecipe.*;
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

    public BootstrapData(EmailRepository emailRepository, UserRepository userRepository, LoginRepository loginRepository,
                         SubscribeEmailRepository subscribeEmailRepository, MealRepository mealRepository,
                         MealOverviewRepository mealOverviewRepository, MealChefRepository mealChefRepository,
                         MealBoxRepository mealBoxRepository, MealBoxNutritionRepository mealBoxNutritionRepository,
                         RecipeStepsRepository recipeStepsRepository,
                         RecipeInstructionsRepository recipeInstructionsRepository,
                         CookingStepsRepository cookingStepsRepository,
                         MealCategoryRepository mealCategoryRepository, MenuRepository menuRepository, ImageRepository imageRepository) {
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
            mealOne.ifPresent(meal -> {image1.setMeal(meal);
            image2.setMeal(meal);
            image3.setMeal(meal);
            image4.setMeal(meal);
            image5.setMeal(meal);
            image6.setMeal(meal);
            image7.setMeal(meal);});

            List<Image> images = Arrays.asList(image1, image2, image3, image4, image5, image6, image7);
            imageRepository.saveAll(images);
        }


        System.out.println("Sending Email...");


//        sendEmail();


        System.out.println("Done");


    }

//    SendEmail sendEmail = new SendEmail();


}
