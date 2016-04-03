package project.scu.edu.chew.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

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

// Display kitchen details
public class KitchenDetailsActivity7 extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    HomeCook homeCook;
    ListView reviewsRatings;
    LinearLayout menuLayout;
    TextView reviewHint;

    LatLng currentUserLatLng = null;
    LatLng homeCookLatLng = null;

    private static final int LOCATION_PERMISSION = 2;
    private GoogleApiClient mGoogleApiClient;
    Button addMap;

    private final int REQUEST_CODE_CALL = 1;
    Integer images;

    ReviewRatings reviewDetails = new ReviewRatings();
    List<ReviewRatings> reviews = new ArrayList<ReviewRatings>();

    LinearLayout userPhotosLayout;
    private int image [] = {R.drawable.food11, R.drawable.lasagna, R.drawable.pasta2, R.drawable.risotto, R.drawable.food15, R.drawable.tiramisu};

    @Override
    protected void onResume() {
        super.onResume();
        reviews = MainKitchenActivity6.reviews;
        if(reviews != null) {
            String[] reviewList = new String[reviews.size()];
            //reviewList[0] = "hi";
            int j = 0;
            if (reviews != null) {
                for (ReviewRatings r : reviews) {
                    if (r.getReview() != null) {
                        reviewList[j] = r.getReview();
                        j++;
                    }
                }
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reviewList);

            reviewsRatings.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_details7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

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

        homeCookLatLng = (KitchenAddressMapsActivity.getAddressFromLocation1(homeCook.getAddress(), getApplicationContext()));

        populateImagesForHSV();
        addImagesToGallery();

        reviewsRatings = (ListView) findViewById(R.id.ratingsList);
        addMap = (Button)findViewById(R.id.addressMap);

        addMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KitchenDetailsActivity7.this, KitchenAddressMapsActivity.class);
                intent.putExtra("homecook", homeCook);
                if(intent != null)
                    startActivity(intent);
            }
        });



        //      reviewsRatings = (ListView) findViewById(R.id.ratingsList);
//        reviewsRatings.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LoadReviews.getReviews()));


        reviews = MainKitchenActivity6.reviews;
        // ReviewRatings review = new ReviewRatings();

        // reviews.add(review);
       /* for(ReviewRatings review : reviews) {
            if(reviews!=null) {
                reviewDetails.setImageView(review.getImageView());
                reviewDetails.setReview(review.getReview());
                reviewDetails.setRating(review.getRating());
                reviewDetails.setUserName(review.getUserName());
            }
        }*/
        if(reviews!=null) {

            String[] reviewList = new String[reviews.size()];
            //reviewList[0] = "hi";
            int j = 0;

            for (ReviewRatings r : reviews) {
                if (r.getReview() != null) {
                    reviewList[j] = r.getReview();
                    j++;
                }
            }


            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reviewList);

            reviewsRatings.setAdapter(arrayAdapter);
            reviewsRatings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    System.out.println("You clicked on:" + position);
                    System.out.println("Review list reviews size:" + reviews.size());

                    Intent intent = new Intent(getBaseContext(), ReviewDetailsActivity.class);
                    intent.putExtra("reviewDetails", reviews.get(position));
                    if (intent != null)
                        startActivity(intent);
                }
            });
        }
        menuLayout = (LinearLayout) findViewById(R.id.menuLayout);
        menuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainMenuListActivity8.class);
                intent.putExtra("homecook", homeCook);
                if (intent != null)
                    startActivity(intent);
            }
        });

        reviewHint = (TextView) findViewById(R.id.reviewHint);
        reviewHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ReviewActivity.class);
                intent.putExtra("homecook", homeCook);
                if (intent != null)
                    startActivity(intent);
            }
        });

        //Get button for call
        LinearLayout phoneLayout = (LinearLayout) findViewById(R.id.phoneLayout);
        phoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(KitchenDetailsActivity7.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // Request missing phone call permission
                    ActivityCompat.requestPermissions(KitchenDetailsActivity7.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + homeCook.getPhone()));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });

        //TOP BAR
        TextView nameView = (TextView) findViewById(R.id.iname);
        nameView.setText(homeCook.getName());

        RatingBar ratings = (RatingBar) findViewById(R.id.irating);
        ratings.setRating(homeCook.getRating());

        // Distance to be done

        TextView cuisineName = (TextView) findViewById(R.id.icuisine);
        cuisineName.setText(homeCook.getCuisine());

        TextView timings = (TextView) findViewById(R.id.itimings);
        timings.setText(homeCook.getTime());

        TextView address = (TextView) findViewById(R.id.iaddress);
        address.setText(homeCook.getAddress());

        TextView phone = (TextView) findViewById(R.id.iphone);
        phone.setText(homeCook.getPhone());



    }

    public void addImagesToGallery() {
        userPhotosLayout = (LinearLayout) findViewById(R.id.userPhotosLayout);
        for(final Integer images : image) {
            View singleImageView = getImageView(images);
            userPhotosLayout.addView(singleImageView);
            this.images = images;
            singleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), PhotoActivity.class);
                    if (intent != null)
                        intent.putExtra("image", images);
                        startActivity(intent);

                }
            });
        }
    }



    public View getImageView(Integer images) {
        ImageView imageView = new ImageView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 10, 0);
        imageView.setLayoutParams(lp);
        imageView.setImageResource(images);
        return imageView;
    }

    // Call back for requested permission
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == REQUEST_CODE_CALL) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(KitchenDetailsActivity7.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + homeCook.getPhone()));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        }

        if (requestCode == LOCATION_PERMISSION){
            startLocationTracking();
        }
    }

    public void populateImagesForHSV() {

        List<Integer> imageArray = new ArrayList<>();
        System.out.println("[7a]No of Food Items: " + homeCook.getFoodItems().size());

//        for(FoodItem foodItem: homeCook.getFoodItems()) {
//            System.out.println("[7b]Food Items image name: " + foodItem.getImagePath());
//            String imagePath = "@drawable/" + foodItem.getImagePath();
//            System.out.println("Image Path:" + imagePath);
//            int imageResource = getResources().getIdentifier(imagePath, null, getPackageName());
//            imageArray.add(imageResource);
//        }

        for(String imageName: homeCook.getHsvList()) {
            String imagePath = "@drawable/" + imageName;
            int imageResource = getResources().getIdentifier(imagePath, null, getPackageName());
            imageArray.add(imageResource);
        }

        int[] ret = new int[imageArray.size()];
        int i = 0;
        for (Integer e : imageArray)
            ret[i++] = e.intValue();

        image = ret;
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
    public void onLocationChanged(Location location) {
        System.out.println("MainKitchen: Curr" + "Location: " + location.getLatitude() + "," + location.getLongitude());
        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
        currentUserLatLng = loc;

        System.out.println("HomeCook LatLng:" + homeCookLatLng);
        System.out.println("User LatLng:" + currentUserLatLng);
        double distance = SphericalUtil.computeDistanceBetween(homeCookLatLng, currentUserLatLng);
        double distanceInMiles = Math.round(0.000621371192 * distance);
        System.out.println("Distance Calculated:" + distanceInMiles + " miles");

        TextView dTextView = (TextView) findViewById(R.id.kDistance);
        dTextView.setText(distanceInMiles + "mi");



    }

    @Override
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}

}
