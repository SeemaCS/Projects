package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadReviews;
import project.scu.edu.chew.models.HomeCook;

public class KitchenDetailsActivity7 extends AppCompatActivity {

    HomeCook homeCook;
    ListView reviewsRatings;
    LinearLayout menuLayout;

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

}
