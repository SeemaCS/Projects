package project.scu.edu.chew.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.CartItem;
import project.scu.edu.chew.models.FoodItem;
import project.scu.edu.chew.models.UserSession;

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

    FoodItem foodItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details9);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        Intent i = getIntent();
        foodItem = (FoodItem)i.getSerializableExtra("foodItem");

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

//                badgeButton = (TextView) findViewById(R.id.badgeButton);
//                badgeButton.setVisibility(View.VISIBLE);
//                badgeCount = Integer.parseInt((String) badgeButton.getText());
//                int quantityCount = Integer.parseInt((String) quantity.getText());
//                badgeCount = badgeCount + quantityCount;
//                badgeButton.setText(badgeCount+"");




                ///NEw logic
                CartItem cartItem = new CartItem();
                cartItem.setName(foodItem.getName());
                cartItem.setQuantity(Integer.parseInt(quantity.getText().toString()));
                cartItem.setPrice(cartItem.getQuantity() * foodItem.getPrice());

                SharedPreferences gobblePreferences = getSharedPreferences("GOBBLE_PREFS", MODE_PRIVATE);
                Gson gson = new Gson();
                String json = gobblePreferences.getString("currentSession", "");
                UserSession userSession = gson.fromJson(json, UserSession.class);
                userSession.getCartItems().add(cartItem);

                userSession.setBadgeCount(userSession.getBadgeCount() + cartItem.getQuantity());
                badgeButton = (TextView) findViewById(R.id.badgeButton);
                badgeButton.setText(userSession.getBadgeCount() + "");
                if(userSession.getBadgeCount() > 0) {
                    badgeButton.setVisibility(View.VISIBLE);
                } else {
                    badgeButton.setVisibility(View.INVISIBLE);
                }

                double totalValue = userSession.getTotalValueInCart() + (cartItem.getPrice() * cartItem.getQuantity());
                System.out.println("Setting total in cart:" + totalValue);
                userSession.setTotalValueInCart(totalValue);

                SharedPreferences.Editor editor = gobblePreferences.edit();
                String writeJson = gson.toJson(userSession);
                editor.putString("currentSession", writeJson);
                editor.commit();



            }
        });
//
//        try {
//            foodpic = (ImageView) findViewById(R.id.foodPic);
//            InputStream inputStream = getBaseContext().getAssets().open("food11.jpg");
//            Drawable drawable = Drawable.createFromStream(inputStream, null);
//            foodpic.setImageDrawable(drawable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        foodpic = (ImageView) findViewById(R.id.foodPic);
        String imagePath = "@drawable/" + foodItem.getImagePath();
        int imageResource = getResources().getIdentifier(imagePath, null, getPackageName());
        Drawable drawable = getDrawable(imageResource);
        foodpic.setImageDrawable(drawable);

        TextView fname = (TextView) findViewById(R.id.fname);
        fname.setText(foodItem.getName());

        TextView fPrice = (TextView) findViewById(R.id.fPrice);
        fPrice.setText(fPrice.getText() + Double.toString(foodItem.getPrice()));

        TextView fDescription = (TextView) findViewById(R.id.fDescription);
        fDescription.setText(foodItem.getLongDescription());

        TextView fCalories = (TextView) findViewById(R.id.fCalories);
        fCalories.setText(foodItem.getNutritionTable().get("Calories"));
        TextView fCarbs = (TextView) findViewById(R.id.fCarbs);
        fCarbs.setText(foodItem.getNutritionTable().get("Carbohydrates"));
        TextView fProtein = (TextView) findViewById(R.id.fProtein);
        fProtein.setText(foodItem.getNutritionTable().get("Protein"));
        TextView fFat = (TextView) findViewById(R.id.fFat);
        fFat.setText(foodItem.getNutritionTable().get("Fat"));
        TextView fFiber = (TextView) findViewById(R.id.fFiber);
        fFiber.setText(foodItem.getNutritionTable().get("Fiber"));

        TextView fServe = (TextView) findViewById(R.id.fServe);
        fServe.setText("Serves " + foodItem.getServing());

        TextView fReadyTime = (TextView) findViewById(R.id.fReadyTime);
        fReadyTime.setText("Ready in " + foodItem.getReadyTime() +" mins");




    }

}
