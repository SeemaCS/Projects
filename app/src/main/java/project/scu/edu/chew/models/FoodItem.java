package project.scu.edu.chew.models;

import java.io.Serializable;
import java.util.HashMap;

public class FoodItem implements Serializable{

    private String name;
    private String imagePath;
    private String description;
    private double calories;
    private double price;
    private String serving;
    private String readyTime;

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public String getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(String readyTime) {
        this.readyTime = readyTime;
    }

    private HashMap<String, String> nutritionTable = new HashMap<>();

    public HashMap<String, String> getNutritionTable() {
        return nutritionTable;
    }

    public void setNutritionTable(HashMap<String, String> nutritionTable) {
        this.nutritionTable = nutritionTable;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    private String longDescription;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private int quantity;

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
