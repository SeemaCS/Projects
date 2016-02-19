package project.scu.edu.chew.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import project.scu.edu.chew.R;

public class FoodItemDetailsActivity9 extends AppCompatActivity {

    ImageView foodpic;
    Button cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details9);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        try {
            foodpic = (ImageView) findViewById(R.id.foodPic);
            InputStream inputStream = getBaseContext().getAssets().open("food11.jpg");
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            foodpic.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


        cartButton = (Button) findViewById(R.id.cartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CartActivity10.class);
                if (intent != null)
                    startActivity(intent);
            }
        });

    }

}
