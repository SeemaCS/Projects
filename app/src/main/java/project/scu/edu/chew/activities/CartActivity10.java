package project.scu.edu.chew.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.FoodItem;

public class CartActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart10);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        ListView listView = (ListView) findViewById(R.id.cart_list_view);

        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Food1", "food11.jpg"));
        foodItems.add(new FoodItem("Food1", "food11.jpg"));
        foodItems.add(new FoodItem("Food1", "food11.jpg"));
        foodItems.add(new FoodItem("Food1", "food11.jpg"));
        foodItems.add(new FoodItem("Food1", "food11.jpg"));
        foodItems.add(new FoodItem("Food1", "food11.jpg"));


        listView.setAdapter(new CartAdapter(this, R.layout.cart_list_row, foodItems));


    }

}
