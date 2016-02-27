package com.homework.moibleapp.horizontalphotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PhotosActivity extends AppCompatActivity {

    LinearLayout imageGallery;
    private Integer image [] = {R.drawable.food12, R.drawable.food16, R.drawable.food19, R.drawable.food13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        addImagesToGallery();

    }
    public void addImagesToGallery() {
        imageGallery = (LinearLayout) findViewById(R.id.imageGallery);
        for(Integer images : image) {
            imageGallery.addView(getImageView(images));
        }
    }

    public View getImageView(Integer images) {
        ImageView imageView = new ImageView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 10, 0);
        imageView.setLayoutParams(lp);
        imageView.setImageResource(images);
        return imageView;
    }

}
