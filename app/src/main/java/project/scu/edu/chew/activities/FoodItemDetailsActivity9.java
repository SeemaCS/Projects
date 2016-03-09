package project.scu.edu.chew.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import project.scu.edu.chew.R;

// Display menu item details.
public class FoodItemDetailsActivity9 extends AppCompatActivity {

    ImageView foodpic;
    Button cartButton;
    Button minusButton;
    Button plusButton;
    public static int quantityCounter = 1;
    public static int badgeCount = 0;
    TextView quantity;
    Button addToCartButton;
    TextView badgeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details9);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        minusButton = (Button) findViewById(R.id.minus);
        plusButton = (Button) findViewById(R.id.plus);
        quantity = (TextView) findViewById(R.id.quantity);

        addToCartButton = (Button) findViewById(R.id.addToCart);


        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityCounter--;
                badgeCount--;
                if(quantityCounter <= 0) {
                    quantityCounter = 0;
                    quantity.setText(String.valueOf(quantityCounter));
                }
                quantity.setText(String.valueOf(quantityCounter));
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityCounter++;
                quantity.setText(String.valueOf(quantityCounter));
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                badgeButton = (TextView) findViewById(R.id.badgeButton);
                badgeButton.setVisibility(View.VISIBLE);
                badgeCount = Integer.parseInt((String) badgeButton.getText());
                int quantityCount = Integer.parseInt((String) quantity.getText());
                badgeCount = badgeCount + quantityCount;
                badgeButton.setText(badgeCount+"");

            }
        });

        try {
            foodpic = (ImageView) findViewById(R.id.foodPic);
            InputStream inputStream = getBaseContext().getAssets().open("food11.jpg");
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            foodpic.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
