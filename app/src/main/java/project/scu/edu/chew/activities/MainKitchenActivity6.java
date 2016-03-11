package project.scu.edu.chew.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.ReviewRatings;
import project.scu.edu.chew.models.HomeCook;

// Display the kitchen details in brief
public class MainKitchenActivity6 extends AppCompatActivity {

    LinearLayout kitchenLayout;
    HomeCook homeCook;

    private Firebase mFirebaseRef;
    static List<ReviewRatings> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kitchen6);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        Intent i = getIntent();
        homeCook = (HomeCook)i.getSerializableExtra("homecook");

        kitchenLayout = (LinearLayout) findViewById(R.id.kitchenLayout);
        kitchenLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), KitchenDetailsActivity7.class);
                intent.putExtra("homecook", homeCook);
                if (intent != null)
                    startActivity(intent);
            }
        });

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.backgroundMain);

        String imagePath = "@drawable/" + homeCook.getLargeImage();
        System.out.println("Image:" + imagePath);
        int imageResource = getResources().getIdentifier(imagePath, null, getPackageName());
        System.out.println("Image ID:" + imageResource);
        Drawable drawable = getDrawable(imageResource);
        relativeLayout.setBackground(drawable);

        TextView mainNameView = (TextView) findViewById(R.id.mainName);
        mainNameView.setText(homeCook.getName());

        RatingBar ratings = (RatingBar) findViewById(R.id.ratingBar1);
        ratings.setRating(homeCook.getRating());

        // Distance to be done

        TextView cuisineName = (TextView) findViewById(R.id.mainCuisine);
        cuisineName.setText(homeCook.getCuisine());

        TextView timings = (TextView) findViewById(R.id.timings);
        timings.setText(homeCook.getTime());

        System.out.println("[6]No of Food Items: " + homeCook.getFoodItems().size());

        Firebase.setAndroidContext(this);
        loadReviews();



    }

    public void loadReviews() {
        mFirebaseRef = new Firebase("https://gobble.firebaseio.com");
        Firebase reviewRef = mFirebaseRef.child("reviews");



        //  final ReviewRatings reviewRatings = new ReviewRatings(userName, ratings, reviews, imageEncoded);
        //reviewRef.setValue(reviewRatings);
        reviewRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ReviewRatings dbReviewRating = new ReviewRatings();
                reviews = new ArrayList<ReviewRatings>();
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    dbReviewRating = (ReviewRatings) item.getValue(ReviewRatings.class);
                    reviews.add(dbReviewRating);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public Drawable getAndroidDrawable(String pDrawableName){
        int resourceId= Resources.getSystem().getIdentifier(pDrawableName, "drawable", "android");
        if(resourceId==0){
            return null;
        } else {
            return Resources.getSystem().getDrawable(resourceId);
        }
    }


}
