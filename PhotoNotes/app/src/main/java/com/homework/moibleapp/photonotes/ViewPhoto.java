package com.homework.moibleapp.photonotes;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.SQLException;

public class ViewPhoto extends AppCompatActivity {

    private int row;
    private ImageView photo;
    private TextView caption;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);
        photo = (ImageView) findViewById(R.id.imageView);
        caption = (TextView) findViewById(R.id.caption);
        Bundle bundle = getIntent().getExtras();
        if(bundle!= null) {
            row = bundle.getInt("ItemClicked");
        }
        dbHelper = new DBHelper(this);
        try {
            dbHelper.open();
            Cursor cur = dbHelper.getNote(row+1);
            String cap = cur.getString(1);
            caption.setText(cap);
            photo.setImageURI(Uri.parse(cur.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == R.id.action_uninstall) {
            Uri packageURI = Uri.parse("package:com.homework.moibleapp.photonotes");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
