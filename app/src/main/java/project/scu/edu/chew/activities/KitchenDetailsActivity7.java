package project.scu.edu.chew.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadReviews;
import project.scu.edu.chew.models.HomeCook;

public class KitchenDetailsActivity7 extends AppCompatActivity {

    HomeCook homeCook;
    ListView reviewsRatings;
    LinearLayout menuLayout;
    TextView reviewHint;

    private final int REQUEST_CODE_CALL = 1;

    LinearLayout userPhotosLayout;
    private Integer image [] = {R.drawable.food11, R.drawable.food12, R.drawable.food13, R.drawable.food14, R.drawable.food15, R.drawable.food16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_details7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        addImagesToGallery();

        Intent i = getIntent();
        homeCook = (HomeCook)i.getSerializableExtra("homecook");
        reviewsRatings = (ListView) findViewById(R.id.ratingsList);
        reviewsRatings.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LoadReviews.getReviews()));
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
                if (intent != null)
                    startActivity(intent);
            }
        });

        //Get button for call
        LinearLayout phoneLayout = (LinearLayout) findViewById(R.id.phoneLayout);
        phoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(KitchenDetailsActivity7.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    // Request missing phone call permission
                    ActivityCompat.requestPermissions(KitchenDetailsActivity7.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "888-888-8888"));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void addImagesToGallery() {
        userPhotosLayout = (LinearLayout) findViewById(R.id.userPhotosLayout);
        for(Integer images : image) {
            userPhotosLayout.addView(getImageView(images));
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
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "888-888-8888"));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        }
    }

}
