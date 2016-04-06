package com.homework.moibleapp.oscars;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private int moviePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        final List<Movies> movies = new ArrayList<>();

        adapter = new CustomAdapter(this, R.layout.custom_row, movies);

        movies.add(new Movies(MovieConstants.MOVIE_NAME_1, MovieConstants.MOVIE_IMAGE_1));
        movies.add(new Movies(MovieConstants.MOVIE_NAME_2, MovieConstants.MOVIE_IMAGE_2));
        movies.add(new Movies(MovieConstants.MOVIE_NAME_3, MovieConstants.MOVIE_IMAGE_3));
        movies.add(new Movies(MovieConstants.MOVIE_NAME_4, MovieConstants.MOVIE_IMAGE_4));
        movies.add(new Movies(MovieConstants.MOVIE_NAME_5, MovieConstants.MOVIE_IMAGE_5));
        movies.add(new Movies(MovieConstants.MOVIE_NAME_6, MovieConstants.MOVIE_IMAGE_6));

        ListView listView = (ListView) findViewById(R.id.custom_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                moviePos = position;
                Movies movie = (Movies)adapter.getItem(moviePos);

                if(position == movies.size() - 1) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MovieListActivity.this);
                    alertDialog.setTitle("WARNING!!");
                    alertDialog.setMessage("THIS MOVIE CONTAINS GRAPHIC VIOLENCE \n DO YOU WISH TO PROCEED?");
                    alertDialog.setIcon(R.drawable.alerticon);
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            getMovieDetails();
                        }
                    });
                    alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });

                    alertDialog.show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), MovieDetailsActivity.class);
                    i.putExtra(MovieConstants.INTENT_KEY, movie.getName());
                    startActivity(i);
                }

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // action Information
        if (id == R.id.action_info) {
            Intent intent = new Intent(MovieListActivity.this, InfoActivity.class);
            startActivity(intent);
        } else if(id==R.id.action_uninstall) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MovieListActivity.this);
            alertDialog.setTitle("ALERT");
            alertDialog.setMessage("DO YOU WANT TO UNINSTALL");
            alertDialog.setIcon(R.drawable.alerticon);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Uri packageURI = Uri.parse("package:com.homework.moibleapp.oscars");
                    Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                    startActivity(uninstallIntent);
                }
            });
            alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void getMovieDetails() {
        Movies movie = (Movies)adapter.getItem(moviePos);
        Intent i = new Intent(getApplicationContext(), MovieDetailsActivity.class);
        i.putExtra(MovieConstants.INTENT_KEY,movie.getName());
        startActivity(i);
    }
}
