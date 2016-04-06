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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    String movieName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = new Intent();
        if (intent != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                movieName = extras.getString(MovieConstants.INTENT_KEY);
            }
        }


        if (movieName.equals(MovieConstants.MOVIE_NAME_1)) {
            TextView movieN = (TextView) findViewById(R.id.movieName);
            movieN.setText(movieName);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(MovieConstants.MOVIE_DESCRIPTION_1);

            ImageView image = (ImageView) findViewById(R.id.movieImage);
            image.setImageResource(R.drawable.tbs_big1);
        }

        if (movieName.equals(MovieConstants.MOVIE_NAME_2)) {
            TextView animalN = (TextView) findViewById(R.id.movieName);
            animalN.setText(movieName);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(MovieConstants.MOVIE_DESCRIPTION_2);

            ImageView image = (ImageView) findViewById(R.id.movieImage);
            image.setImageResource(R.drawable.tm_big);
        }

        if (movieName.equals(MovieConstants.MOVIE_NAME_3)) {
            TextView animalN = (TextView) findViewById(R.id.movieName);
            animalN.setText(movieName);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(MovieConstants.MOVIE_DESCRIPTION_3);

            ImageView image = (ImageView) findViewById(R.id.movieImage);
            image.setImageResource(R.drawable.bos_big1);
        }

        if (movieName.equals(MovieConstants.MOVIE_NAME_4)) {
            TextView animalN = (TextView) findViewById(R.id.movieName);
            animalN.setText(movieName);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(MovieConstants.MOVIE_DESCRIPTION_4);

            ImageView image = (ImageView) findViewById(R.id.movieImage);
            image.setImageResource(R.drawable.b_big);
        }

        if (movieName.equals(MovieConstants.MOVIE_NAME_5)) {
            TextView animalN = (TextView) findViewById(R.id.movieName);
            animalN.setText(movieName);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(MovieConstants.MOVIE_DESCRIPTION_5);

            ImageView image = (ImageView) findViewById(R.id.movieImage);
            image.setImageResource(R.drawable.s_big);
        }

        if (movieName.equals(MovieConstants.MOVIE_NAME_6)) {
            TextView animalN = (TextView) findViewById(R.id.movieName);
            animalN.setText(movieName);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(MovieConstants.MOVIE_DESCRIPTION_6);

            ImageView image = (ImageView) findViewById(R.id.movieImage);
            image.setImageResource(R.drawable.tr_big1);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent intent = new Intent(MovieDetailsActivity.this, InfoActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.action_uninstall) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MovieDetailsActivity.this);
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

}
