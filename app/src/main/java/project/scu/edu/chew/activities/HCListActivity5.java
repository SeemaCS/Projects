package project.scu.edu.chew.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadData;
import project.scu.edu.chew.models.HomeCook;

// Proj names - Chew, Hook, Gobble, Hoober
public class HCListActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hclist);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // List view of dishes + thumbnails + Home cook names
        ListView listView = (ListView) findViewById(R.id.home_cook_list_view);

        final List<HomeCook> homeCooks = new ArrayList<>();
        LoadData.populateData(homeCooks);

        listView.setAdapter(new HomeCookListAdapter(this, R.layout.home_cook_list_row, homeCooks));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Start from here
                   /* Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                    intent.putExtra("animal", animals.get(position));
                    if (intent != null)
                        startActivity(intent); */


            }
        });
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
