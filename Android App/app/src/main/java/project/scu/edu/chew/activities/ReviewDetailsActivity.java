package project.scu.edu.chew.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.ReviewRatings;

public class ReviewDetailsActivity extends AppCompatActivity {

    ReviewRatings reviewRatings;
    TextView duserName;
    RatingBar drating;
    TextView dreview;
    ImageView dimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        duserName = (TextView) findViewById(R.id.rusername);
        drating = (RatingBar) findViewById(R.id.rrating);
        dreview = (TextView) findViewById(R.id.rreview);
        dimage = (ImageView)findViewById(R.id.rreviewImage);


        Intent i = getIntent();
        reviewRatings = (ReviewRatings)i.getSerializableExtra("reviewDetails");

        duserName.setText(reviewRatings.getUserName());
        drating.setRating(reviewRatings.getRating());
        dreview.setText(reviewRatings.getReview());

        String img = reviewRatings.getImageView();
        byte[] decodedByte = Base64.decode(img, 0);
        Bitmap photodecoded = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        dimage.setImageBitmap(photodecoded);


    }

}
