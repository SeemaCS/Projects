package project.scu.edu.chew.activities;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.gson.Gson;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.UserSession;

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
                    System.out.println("Position: " + position);

                    if(position == 0) {
                        Intent intent = new Intent(BaseActivity.this, HCListActivity5.class);
                        if (intent != null)
                            startActivity(intent);
                    }

                    if(position == 4) {
                        signOut();
                    }
                    //Toast.makeText(HCListActivity5.this, "", Toast.LENGTH_SHORT).show();
                }
            });


        }

        private void addDrawerItems() {
            String[] itemsArray = { "Home", "Feedback", "About", "Help", "Sign Out" };
            mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsArray);
            mDrawerList.setAdapter(mAdapter);
        }


    public void signOut() {
        SharedPreferences gobblePreferences = getSharedPreferences("GOBBLE_PREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = gobblePreferences.edit();
        UserSession newSession = new UserSession();
        Gson gson = new Gson();
        String json = gson.toJson(newSession);
        editor.putString("currentSession", json);
        editor.commit();

        Intent intent = new Intent(BaseActivity.this, LoginOptionsActivity2.class);
        if(intent != null)
            startActivity(intent);
        finish();
    }

    }



