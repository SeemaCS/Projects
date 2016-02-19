package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.FoodItem;
import project.scu.edu.chew.models.HomeCook;

public class MainMenuListActivity8 extends AppCompatActivity {

    HomeCook homeCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        Intent i = getIntent();
        homeCook = (HomeCook)i.getSerializableExtra("homecook");

        ListView listView = (ListView) findViewById(R.id.menu_list_view);

        final List<FoodItem> foodItems = homeCook.getFoodItems();
        //LoadData.populateData(foodItems);

        listView.setAdapter(new MenuAdapter(this, R.layout.menu_list_row, foodItems));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getBaseContext(), FoodItemDetailsActivity9.class);
                intent.putExtra("foodItem", foodItems.get(position));
                if (intent != null)
                    startActivity(intent);

            }
        });

    }

}
