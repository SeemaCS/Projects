package project.scu.edu.chew.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lakshitha on 2/2/16.
 */
public class HomeCook implements Serializable{

    private ArrayList<FoodItem> foodItems = new ArrayList<>();
    private String address;
    private String imagePath;
    private String phone;
    private String time;
    private String name;
    private String cuisine;
    private String largeImage;
    private float rating;

    private ArrayList<String> hsvList = new ArrayList<>();

    public ArrayList<String> getHsvList() {
        return hsvList;
    }

    public void setHsvList(ArrayList<String> hsvList) {
        this.hsvList = hsvList;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public HomeCook(String name, String phone, String imagePath) {
        this.name = name;
        this.phone = phone;
        this.imagePath = imagePath;
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }


    public HomeCook (HomeCook homeCook) {
        this.foodItems = homeCook.foodItems;
        this.address = homeCook.address;
        this.imagePath = homeCook.imagePath;
        this.phone = homeCook.phone;
        this.time = homeCook.time;
        this.name = homeCook.name;
        this.cuisine = homeCook.cuisine;
        this.largeImage = homeCook.largeImage;
        this.rating = homeCook.rating;
        this.hsvList = homeCook.hsvList;
    }
}
