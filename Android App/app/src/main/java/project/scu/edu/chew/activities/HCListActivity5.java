package project.scu.edu.chew.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;

import project.scu.edu.chew.R;

// Display home cook list
public class HCListActivity5 extends BaseActivity {

    Button searchButton;
    //Button mapButton;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    //private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    //Button navigationButton;
    Button user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hclist);

        TopToolbarFragment toolbarFragment = new TopToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.toptoolbarcontainer, toolbarFragment).commit();

        HCListFragment hcListFragment = new HCListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainContentcontainer, hcListFragment).commit();

        BottomToolbarFragment bottomToolbarFragment = new BottomToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottomToolbarcontainer, bottomToolbarFragment).commit();



//        ListView listView = (ListView) findViewById(R.id.home_cook_list_view);
//
//        final List<HomeCook> homeCooks = new ArrayList<>();
//        LoadData.populateData(homeCooks);
//
//        listView.setAdapter(new HomeCookListAdapter(this, R.layout.home_cook_list_row, homeCooks));
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent = new Intent(getBaseContext(), MainKitchenActivity6.class);
//                intent.putExtra("homecook", homeCooks.get(position));
//                if (intent != null)
//                    startActivity(intent);
//
//            }
//        });
//
//
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
