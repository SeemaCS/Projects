package project.scu.edu.chew.database;

import java.io.Serializable;

public class ReviewRatings implements Serializable{

    public String userName;
    public float rating;
    public String review;
    String imageView;
    public String homeCookName;

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public ReviewRatings() {

    }

    public ReviewRatings(String userName, float rating, String review, String imageView, String homeCookName) {

        this.userName = userName;
        this.rating = rating;
        this.review = review;
        this.imageView = imageView;
        this.homeCookName = homeCookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHomeCookName() {
        return homeCookName;
    }

    public void setHomeCookName(String homeCookName) {
        this.homeCookName = homeCookName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


}
