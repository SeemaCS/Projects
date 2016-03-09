package lakshitha.homework4.com.cameraimagesave;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.io.ByteArrayOutputStream;

public class FirebaseSaveActivity extends AppCompatActivity {

    private final int RESULT_CODE_CAMERA=2;
    private Firebase mFirebaseRef;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_save);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);

        imageView = (ImageView) findViewById(R.id.image);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent != null)
                    startActivityForResult(takePictureIntent, RESULT_CODE_CAMERA);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RESULT_CODE_CAMERA && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();
            String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
            mFirebaseRef = new Firebase("https://torrid-fire-1695.firebaseio.com");
            Firebase imageRef = mFirebaseRef.child("images");
            imageRef.setValue(imageEncoded);




            imageRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String img = "";
                    img = (String) dataSnapshot.getValue();
                    Toast.makeText(FirebaseSaveActivity.this, img, Toast.LENGTH_SHORT).show();
                    byte[] decodedByte = Base64.decode(img, 0);
                    Bitmap photodecoded = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
                    imageView.setImageBitmap(photodecoded);


                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });


        }


    }
}
