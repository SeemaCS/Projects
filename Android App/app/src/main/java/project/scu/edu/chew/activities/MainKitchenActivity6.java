package project.scu.edu.chew.activities;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.ReviewRatings;
import project.scu.edu.chew.models.HomeCook;

// Display the kitchen details in brief
public class MainKitchenActivity6 extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    LinearLayout kitchenLayout;
    HomeCook homeCook;
    LatLng currentUserLatLng = null;
    LatLng homeCookLatLng = null;

    private static final int LOCATION_PERMISSION = 1;
    private GoogleApiClient mGoogleApiClient;

    private Firebase mFirebaseRef;
    static List<ReviewRatings> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .enableAutoManage(this, this)
                    .build();
        }

        Intent i = getIntent();
        homeCook = (HomeCook)i.getSerializableExtra("homecook");

        System.out.println("Home cook name in MainKitchen" + homeCook.getName());
        System.out.println("Home cook address in MainKitchen" + homeCook.getAddress());

        homeCookLatLng = (KitchenAddressMapsActivity.getAddressFromLocation1(homeCook.getAddress(), getApplicationContext()));

        setContentView(R.layout.activity_main_kitchen6);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

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
                    if(dbReviewRating.getHomeCookName().equalsIgnoreCase(homeCook.getName())) {
                        reviews.add(dbReviewRating);
                    }
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

    @Override
    public void onConnected(Bundle bundle) {
        startLocationTracking();
    }

    private void startLocationTracking() {
        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION);
            return;
        }

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] result){
        super.onRequestPermissionsResult(requestCode, permissions, result);
        if (requestCode == LOCATION_PERMISSION){
            startLocationTracking();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        System.out.println("MainKitchen: Curr" + "Location: " + location.getLatitude() + "," + location.getLongitude());
        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
        currentUserLatLng = loc;

        System.out.println("HomeCook LatLng:" + homeCookLatLng);
        System.out.println("User LatLng:" + currentUserLatLng);
        double distance = SphericalUtil.computeDistanceBetween(homeCookLatLng, currentUserLatLng);
        double distanceInMiles = Math.round(0.000621371192 * distance);
        System.out.println("Distance Calculated:" + distanceInMiles + " miles");

        TextView dTextView = (TextView) findViewById(R.id.distanceMiles);
        dTextView.setText(distanceInMiles+"mi");



    }

    @Override
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}



}
