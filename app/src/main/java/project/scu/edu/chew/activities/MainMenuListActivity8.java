package project.scu.edu.chew.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.HomeCook;

// Menu Item List Activity
public class MainMenuListActivity8 extends BaseActivity {

    HomeCook homeCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_menu_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        TopToolbarFragment toolbarFragment = new TopToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.toptoolbarcontainer, toolbarFragment).commit();

        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainContentcontainer, mainMenuFragment).commit();

        BottomToolbarFragment bottomToolbarFragment = new BottomToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottomToolbarcontainer, bottomToolbarFragment).commit();


//        Intent i = getIntent();
//        homeCook = (HomeCook)i.getSerializableExtra("homecook");
//
//        ListView listView = (ListView) findViewById(R.id.menu_list_view);
//
//        final List<FoodItem> foodItems = homeCook.getFoodItems();
//
//        listView.setAdapter(new MenuAdapter(this, R.layout.menu_list_row, foodItems));
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent = new Intent(getBaseContext(), FoodItemDetailsActivity9.class);
//                intent.putExtra("foodItem", foodItems.get(position));
//                if (intent != null)
//                    startActivity(intent);
//
//            }
//        });

    }

}
