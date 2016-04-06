package com.homework.moibleapp.photonotes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddPhoto extends AppCompatActivity {

    private ImageButton capture;
    private ImageButton save;
    private ImageButton cancel;
    private ImageView imageView;
    private EditText caption;
    String captionText = null;
    private DBHelper db = new DBHelper(this);;
    private Uri file = null;
    private static final String IMAGE_DIRECTORY_NAME = "PHOTOS";
    static final int REQUEST_TAKE_PHOTO = 1;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        capture = (ImageButton) findViewById(R.id.capture);
        save = (ImageButton) findViewById(R.id.save);
        imageView = (ImageView)findViewById(R.id.imageView);
        cancel = (ImageButton) findViewById(R.id.cancel);
        caption = (EditText)findViewById(R.id.caption);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caption.setText("");
                Toast.makeText(AddPhoto.this,"Take another pic", Toast.LENGTH_SHORT).show();
            }
        });


        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraLaunch();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captionText = String.valueOf(caption.getText());
                try {
                    db.open();
                    if(captionText.isEmpty() || file == null) {
                       Toast.makeText(AddPhoto.this,"Enter Caption and/or Click Image", Toast.LENGTH_SHORT).show();
                    } else {
                        db.insert(captionText, file.toString());
                        finish();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void cameraLaunch() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = getOutputMediaFileUri(REQUEST_TAKE_PHOTO);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private File getOutputMediaFile(int type) {
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);
        if (!storageDir.exists()) {
            if (!storageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyy_MMdd_HHmmss", Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == REQUEST_TAKE_PHOTO) {
            mediaFile = new File(storageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return mediaFile;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // successfully captured the image
                // display it in image view
                previewImage();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(), "User cancelled image capture", Toast.LENGTH_SHORT).show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(), "Sorry! Failed to capture image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void previewImage() {
        try{
            imageView.setVisibility(View.VISIBLE);
            BitmapFactory.Options options = new BitmapFactory.Options();
            // downsizing image as it throws OutOfMemory Exception for larger images
            options.inSampleSize = 16;
            final Bitmap bitmap = BitmapFactory.decodeFile(file.getPath(), options);
            imageView.setImageBitmap(bitmap);
            //textPreview.setVisibility(View.INVISIBLE);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save file url in bundle as it will be null on screen orientation changes
        outState.putParcelable("file_uri", file);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // get the file url
        file = savedInstanceState.getParcelable("file_uri");
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
           /* if (mediaStorageDir.exists()) {
                DeleteAction(mediaStorageDir);
            }*/
            startActivity(uninstallIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
