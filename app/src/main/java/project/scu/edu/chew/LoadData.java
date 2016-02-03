package project.scu.edu.chew;

/**
 * Created by lakshitha on 2/2/16.
 */
import java.util.List;


public class LoadData {

    public static void populateData(List<HomeCook> homeCooks) {

        HomeCook homeCook = new HomeCook("ABC kitchen", "12345678", "pasta.jpg");
        homeCook.getFoodItems().add(new FoodItem("Paratha", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pasta", "pasta.jpg"));
        homeCooks.add(homeCook);

        homeCook = new HomeCook("Swathi's kitchen", "57777788392", "pasta.jpg");
        homeCook.getFoodItems().add(new FoodItem("Idli", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Dosa", "pasta.jpg"));
        homeCooks.add(homeCook);

        homeCook = new HomeCook("Albert's kitchen", "57777788392", "pasta.jpg");
        homeCook.getFoodItems().add(new FoodItem("Burger", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Pizza", "pasta.jpg"));
        homeCooks.add(homeCook);

        homeCook = new HomeCook("Maria's kitchen", "57777788392", "pasta.jpg");
        homeCook.getFoodItems().add(new FoodItem("Burrito", "pasta.jpg"));
        homeCook.getFoodItems().add(new FoodItem("Tacos", "pasta.jpg"));
        homeCooks.add(homeCook);

    }
}
