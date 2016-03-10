package project.scu.edu.chew.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.ReviewRatings;
import project.scu.edu.chew.database.User;
import project.scu.edu.chew.models.UserSession;

// Add New Review Screen - Activity to add a new review, rating and upload pics.
public class ReviewActivity extends AppCompatActivity {

    private final int RESULT_CODE_CAMERA=2;
    private Firebase mFirebaseRef;
    ImageView imageView;
    Button saveButton;
    Bitmap photo;
    EditText review;
    RatingBar ratingBar;
    TextView userNameView;
    String imageEncoded = "";
    String dbUser;
    String dbReview;
    float dbRating;
    String dbImg = "";
    public static ReviewRatings reviewRating = new ReviewRatings();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        Firebase.setAndroidContext(this);

        SharedPreferences gobblePreferences = getSharedPreferences("GOBBLE_PREFS", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gobblePreferences.getString("currentSession", "");
        UserSession userSession = gson.fromJson(json, UserSession.class);
        User currentUser = userSession.getUser();

        imageView = (ImageView) findViewById(R.id.reviewImage);
        saveButton = (Button) findViewById(R.id.saveButton);
        review = (EditText) findViewById(R.id.editText2);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
        userNameView = (TextView) findViewById(R.id.userName);

        userNameView.setText(currentUser.getName());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent != null)
                    startActivityForResult(takePictureIntent, RESULT_CODE_CAMERA);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(ReviewActivity.this, "Coming to save", Toast.LENGTH_SHORT).show();
                if (photo != null) {
                    Toast.makeText(ReviewActivity.this, "Photo added", Toast.LENGTH_SHORT).show();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();
                    imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);


                }
                mFirebaseRef = new Firebase("https://gobble.firebaseio.com");
                Firebase reviewRef = mFirebaseRef.child("reviews");

                String reviews = review.getText().toString();
                float ratings = ratingBar.getRating();
                String userName = userNameView.getText().toString();

                final ReviewRatings reviewRatings = new ReviewRatings(userName, ratings, reviews, imageEncoded);
                reviewRef.push().setValue(reviewRatings);
                reviewRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        ReviewRatings dbReviewRating = new ReviewRatings();
                        for (DataSnapshot item : dataSnapshot.child("reviews").getChildren()) {
                            dbReviewRating = (ReviewRatings) item.getValue(ReviewRatings.class);
                            dbUser = dbReviewRating.getUserName();
                            dbReview = dbReviewRating.getReview();
                            dbRating = dbReviewRating.getRating();
                            dbImg = dbReviewRating.getImageView();

                            MainKitchenActivity6.reviews.add(dbReviewRating);

                            reviewRatings.setUserName(dbUser);
                            reviewRatings.setReview(dbReview);
                            reviewRatings.setRating(dbRating);
                            reviewRatings.setImageView(dbImg);

                        }

                        if (!dbImg.equals("")) {
                            // dbImg = reviewRating.getImageView();
                            //img = (String) dataSnapshot.getValue();
                            //Toast.makeText(ReviewActivity.this, img, Toast.LENGTH_SHORT).show();
                            byte[] decodedByte = Base64.decode(dbImg, 0);
                            Bitmap photodecoded = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
                            imageView.setImageBitmap(photodecoded);
                        }


                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
                finish();
            }
        });
    }

//    public List<ReviewRatings> populateReviewDetails(String userDb, String reviewDb, float ratingDb, String imgDb) {
//        ReviewRatings reviewRatingsDb = new ReviewRatings();
//        reviewRatingsDb.setUserName(userDb);
//        reviewRatingsDb.setReview(reviewDb);
//        reviewRatingsDb.setRating(ratingDb);
//        reviewRatingsDb.setImageView(imgDb);
//        List<ReviewRatings> listReview = new ArrayList<ReviewRatings>();
//        listReview.add(reviewRatingsDb);
//        return listReview;
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RESULT_CODE_CAMERA && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();
            imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

            byte[] decodedByte = Base64.decode(imageEncoded, 0);
            Bitmap photodecoded = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
            imageView.setImageBitmap(photodecoded);
        }


    }


}
