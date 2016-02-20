package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.HomeCook;

// Display the kitchen details in brief
public class MainKitchenActivity6 extends AppCompatActivity {

    LinearLayout kitchenLayout;
    HomeCook homeCook;

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


    }

}
