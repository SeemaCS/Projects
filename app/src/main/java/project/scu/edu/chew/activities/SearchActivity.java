package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.helpers.LoadData;
import project.scu.edu.chew.models.HomeCook;

// Search Screen - Activity to search the home cook list based on filters
public class SearchActivity extends AppCompatActivity {

    ListView listView;
    SearchView cookSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        listView = (ListView) findViewById(R.id.listView);
        cookSearch = (SearchView)findViewById(R.id.searchView);
        final List<HomeCook> homeCooks = new ArrayList<>();
        LoadData.populateData(homeCooks);

        final SearchAdapter adapter = new SearchAdapter(this, homeCooks);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SearchActivity.this, MainKitchenActivity6.class);
                intent.putExtra("homecook", homeCooks.get(position));
                if (intent != null)
                    startActivity(intent);

            }
        });

        cookSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });




    }


}



