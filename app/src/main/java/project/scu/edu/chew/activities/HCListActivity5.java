package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadData;
import project.scu.edu.chew.models.HomeCook;

// Proj names - Chew, Hook, Gobble, Hoober
public class HCListActivity5 extends AppCompatActivity {

    Button searchButton;
    Button mapButton;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    Button navigationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hclist);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.topToolbar);
//        setSupportActionBar(toolbar);
//
//        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.bottomToolbar);
//        bottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                return true;
//            }
//        });
        // Inflate a menu to be displayed in the toolbar
      //  bottomToolbar.inflateMenu(R.menu.menu_main);
//        setS(bottomToolbar);

        // List view of dishes + thumbnails + Home cook names
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        mDrawerList = (ListView)findViewById(R.id.navList);
        addDrawerItems();
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HCListActivity5.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            }
        });
        navigationButton = (Button) findViewById(R.id.navigationButton);
        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        });

        ListView listView = (ListView) findViewById(R.id.home_cook_list_view);

        final List<HomeCook> homeCooks = new ArrayList<>();
        LoadData.populateData(homeCooks);

        listView.setAdapter(new HomeCookListAdapter(this, R.layout.home_cook_list_row, homeCooks));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getBaseContext(), MainKitchenActivity6.class);
                intent.putExtra("homecook", homeCooks.get(position));
                if (intent != null)
                    startActivity(intent);

            }
        });

        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                if (intent != null)
                    startActivity(intent);

            }
        });

        mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), MapActivity.class);
                if (intent != null)
                    startActivity(intent);

            }
        });
    }

    private void addDrawerItems() {
        String[] itemsArray = { "Home", "Feedback", "About", "Help", "Sign Out" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsArray);
        mDrawerList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_launch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
