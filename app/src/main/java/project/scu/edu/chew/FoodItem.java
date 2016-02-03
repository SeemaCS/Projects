package project.scu.edu.chew;

import java.io.Serializable;

/**
 * Created by lakshitha on 2/2/16.
 */
public class FoodItem implements Serializable{

    private String name;
    private String imagePath;
    private String description;
    private double calories;

    public FoodItem(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
