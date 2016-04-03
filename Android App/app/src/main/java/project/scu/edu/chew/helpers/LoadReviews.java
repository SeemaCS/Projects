package project.scu.edu.chew.helpers;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.activities.ReviewActivity;
import project.scu.edu.chew.database.ReviewRatings;


// Helper class - to be linked to database later.
public class LoadReviews {

    public static String userName = "";
    public static String reviews = "";
    public static float rating = 0.0f;
    public static String image = "";

    public LoadReviews() {

    }

    public LoadReviews(String userName, String reviews, float rating, String image) {
        this.userName = userName;
        this.reviews = reviews;
        this.rating = rating;
        this.image = image;
    }

    private Firebase mFirebaseRef;

    public static List<ReviewRatings> getReviews() {

        ReviewRatings reviewRatingsDb = new ReviewRatings();
        reviewRatingsDb.setUserName(userName);
        reviewRatingsDb.setReview(reviews);
        reviewRatingsDb.setRating(rating);
        reviewRatingsDb.setImageView(image);
        List<ReviewRatings> listReview = new ArrayList<ReviewRatings>();
        listReview.add(reviewRatingsDb);



//        String[] reviews = new String[5];
//
//
//
//        reviews[0] = "This is a good kitchen";
//        reviews[1] = "Great Place";
//        reviews[2] = " ordered a cake from My Delicious Tiramisu for our 30th wedding anniversary. \n" +
//                "Oksana was very responsive and professional regarding the whole processes. \n" +
//                "You can feel how much she cares about her work and her desire to make it perfect.\n" +
//                "It is hard to call her creation a cake, it's an art! And she is talented and creative artist!\n" +
//                "The cake looked outstanding and was super delicious!";
//        reviews[3] = "Amazingly delicious cake. In addition, Oksana does an outstanding job on decorations.\n" +
//                "\n" +
//                "I ordered delicious tiramisu cakes for many occasions and my guests and colleagues always were blown away by the taste of the tiramisu cake.";
//        reviews[4] = "First time I tried tiramisu from \"My delicious tiramisu\" around year ago. It was deliciously tasty. I decided to prepare tiramisu for my family by myself.  I thought it's just 4 ingredients - biscuits, mascarpone cheese, eggs and coffee which are folded together. I was so naive. I tried several times and always failed. I never got a taste close to the taste of Oksana's tiramisu - a fluffy, light, flavored creamy cheese with a smell of coffee after bite of chocolate.\n" +
//                "I had tiramisu cakes for very important events for my family and cakes were always beautiful decorated.\n" +
//                "If you order Oksana's cake, you'll have not only a delicious cake made with love, but also communicate with very positive and pleasant person with whom you want to meet again and again.\n" +
//                "In one sentence \"My Delicious Tiramisu\" is \"heavenly taste in your mouth!\" which doesn't have an unmatched in authentic flavor & melt-in-your-mouth quality.";
//        return reviews;
        return listReview;
    }
}
