package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadReviews;
import project.scu.edu.chew.models.HomeCook;

public class KitchenDetailsActivity7 extends AppCompatActivity {

    HomeCook homeCook;
    ListView reviewsRatings;
    LinearLayout menuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_details7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

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

}
