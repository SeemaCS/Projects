package project.scu.edu.chew.helpers;

/**
 * Created by lakshitha on 2/2/16.
 */
import java.util.List;

import project.scu.edu.chew.models.FoodItem;
import project.scu.edu.chew.models.HomeCook;


public class LoadData {


    public static void populateData(List<HomeCook> homeCooks) {


        // #1
        HomeCook homeCook = new HomeCook("Maria's Kitchen", "12345678", "pasta.jpg");
        homeCook.setCuisine("Italian");

        FoodItem foodItem = new FoodItem("Pizza", "food1.jpg");
        foodItem.setDescription("With mozzarella, roasted red peppers and basil with alfredo and garlic spread");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Pasta", "food1.jpg");
        foodItem.setDescription("Ziti, Prosciutto, Asiago Cheese & Red Pepper Cream Sauce");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Lasagne", "food1.jpg");
        foodItem.setDescription("Layered Lasagna noodles, italian sausage and beef, ricotta cheese, tomato sauce, and baked mozzarella and romano cheese");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Tiramisu", "food1.jpg");
        foodItem.setDescription("Traditional Italian coffee cake - Lady fingers dipped in expresso layered with marscapone cream and topped with cocca powder");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Chicken Parmigiana", "food1.jpg");
        foodItem.setDescription("Mama's tomato sauce, lightly fried chicken breast, romano and mozzarella cheese baked until it's golden brown");
        homeCook.getFoodItems().add(foodItem);

        foodItem = new FoodItem("Macaroni & Cheese", "food1.jpg");
        foodItem.setDescription("Elbow macaroni and yellow cheese");
        homeCook.getFoodItems().add(foodItem);
        homeCooks.add(homeCook);

        // #2
        homeCook = new HomeCook("Swathi's Kitchen", "57777788392", "paratha.jpg");
        homeCook.setCuisine("Indian");
        homeCook.getFoodItems().add(new FoodItem("Idli", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Dosa", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #3
        homeCook = new HomeCook("Albert's kitchen", "57777788392", "food12.jpg");
        homeCook.setCuisine("American");
        homeCook.getFoodItems().add(new FoodItem("Burger", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pizza", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #4
        homeCook = new HomeCook("Liliana's kitchen", "57777788392", "tacos.jpg");
        homeCook.setCuisine("Mexican");
        homeCook.getFoodItems().add(new FoodItem("Burrito", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Tacos", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #5
        homeCook = new HomeCook("Wang's Kitchen", "12345678", "food1.jpg");
        homeCook.setCuisine("Chinese");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #6
        homeCook = new HomeCook("Binh's Kitchen", "12345678", "pho.jpg");
        homeCook.setCuisine("Vietnamese");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #7
        homeCook = new HomeCook("Chiko's Kitchen", "12345678", "ramen.jpg");
        homeCook.setCuisine("Japanese");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #8
        homeCook = new HomeCook("Berta's Kitchen", "12345678", "meal.jpg");
        homeCook.setCuisine("Ethiopian");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #9
        homeCook = new HomeCook("Vaino's Kitchen", "12345678", "greek.jpg");
        homeCook.setCuisine("Greek");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #10
        homeCook = new HomeCook("Clara's Kitchen", "12345678", "paella.jpg");
        homeCook.setCuisine("Spanish");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

    }
}
