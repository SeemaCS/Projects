package project.scu.edu.chew.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import project.scu.edu.chew.R;

public class BaseActivity extends AppCompatActivity {

    private Button mapButton;
    public ListView mDrawerList;
    public DrawerLayout mDrawerLayout;
    Button navigationButton;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

            // Inflate the layout for this fragment

             mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

            mDrawerList = (ListView)findViewById(R.id.navList);
            addDrawerItems();
            mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(HCListActivity5.this, "", Toast.LENGTH_SHORT).show();
                }
            });


        }

        private void addDrawerItems() {
            String[] itemsArray = { "Home", "Feedback", "About", "Help", "Sign Out" };
            mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsArray);
            mDrawerList.setAdapter(mAdapter);
        }

    }



