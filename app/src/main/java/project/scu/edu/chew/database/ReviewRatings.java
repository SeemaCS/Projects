package project.scu.edu.chew.database;

import android.widget.ImageView;

import java.io.Serializable;

public class ReviewRatings implements Serializable{

    public String userName;
    public float rating;
    public String review;
    String imageView;

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public ReviewRatings() {

    }

    public ReviewRatings(String userName, float rating, String review, String imageView) {

        this.userName = userName;
        this.rating = rating;
        this.review = review;
        this.imageView = imageView;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
