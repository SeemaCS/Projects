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
        HomeCook homeCook = new HomeCook("Kitchen 1", "12345678", "food1.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #2
        homeCook = new HomeCook("Swathi's kitchen", "57777788392", "food11.jpg");
        homeCook.getFoodItems().add(new FoodItem("Idli", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Dosa", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #3
        homeCook = new HomeCook("Albert's kitchen", "57777788392", "food12.jpg");
        homeCook.getFoodItems().add(new FoodItem("Burger", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pizza", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #4
        homeCook = new HomeCook("Maria's kitchen", "57777788392", "food13.jpg");
        homeCook.getFoodItems().add(new FoodItem("Burrito", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Tacos", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #5
        homeCook = new HomeCook("Kitchen 5", "12345678", "food14.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #6
        homeCook = new HomeCook("Kitchen 6", "12345678", "food15.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #7
        homeCook = new HomeCook("Kitchen 7", "12345678", "food16.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #8
        homeCook = new HomeCook("Kitchen 8", "12345678", "food2.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #9
        homeCook = new HomeCook("Kitchen 9", "12345678", "food3.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        // #10
        homeCook = new HomeCook("Kitchen 10", "12345678", "food4.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "food1.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

    }
}
