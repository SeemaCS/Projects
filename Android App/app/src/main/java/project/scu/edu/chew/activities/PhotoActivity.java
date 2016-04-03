package project.scu.edu.chew.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import project.scu.edu.chew.R;

public class PhotoActivity extends AppCompatActivity {

    ImageView imageView;

    TextView myTouchEvent;
    ImageView myImageView;
    Bitmap bitmap;
    int bmpWidth, bmpHeight;

    int touchState;
    final int IDLE = 0;
    final int TOUCH = 1;
    final int PINCH = 2;
    double dist0, distCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Integer image = Integer.parseInt(intent.getExtras().get("image").toString());

        System.out.println("Image from intent:" + image);
        imageView = (ImageView) findViewById(R.id.imageView2);
        Drawable drawable = getDrawable(image);
        imageView.setImageDrawable(drawable);

        myTouchEvent = (TextView)findViewById(R.id.touchevent);
       // myImageView = (ImageView)findViewById(R.id.imageView);

        bitmap = BitmapFactory.decodeResource(getResources(), image);
        bmpWidth = bitmap.getWidth();
        bmpHeight = bitmap.getHeight();

        distCurrent = 1; //Dummy default distance
        dist0 = 1;   //Dummy default distance
        drawMatrix();

        imageView.setOnTouchListener(MyOnTouchListener);
        touchState = IDLE;




    }

    private void drawMatrix(){
        double curScale = distCurrent/dist0;
        if (curScale < 0.1){
            curScale = 0.1f;
        }

        Bitmap resizedBitmap;
        int newHeight = (int) (bmpHeight * curScale);
        int newWidth = (int) (bmpWidth * curScale);
        resizedBitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false);
        imageView.setImageBitmap(resizedBitmap);
    }

    OnTouchListener MyOnTouchListener  = new OnTouchListener(){

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            // TODO Auto-generated method stub

            float distx, disty;

            switch(event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    //A pressed gesture has started, the motion contains the initial starting location.
                    //myTouchEvent.setText("ACTION_DOWN");
                    touchState = TOUCH;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    //A non-primary pointer has gone down.
                    //myTouchEvent.setText("ACTION_POINTER_DOWN");
                    touchState = PINCH;

                    //Get the distance when the second pointer touch
                    distx = event.getX(0) - event.getX(1);
                    disty = event.getY(0) - event.getY(1);
                    dist0 = Math.sqrt(distx * distx + disty * disty);

                    break;
                case MotionEvent.ACTION_MOVE:
                    //A change has happened during a press gesture (between ACTION_DOWN and ACTION_UP).
                    //myTouchEvent.setText("ACTION_MOVE");

                    if(touchState == PINCH){
                        //Get the current distance
                        distx = event.getX(0) - event.getX(1);
                        disty = event.getY(0) - event.getY(1);
                        distCurrent = Math.sqrt(distx * distx + disty * disty);

                        drawMatrix();
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    //A pressed gesture has finished.
                   // myTouchEvent.setText("ACTION_UP");
                    touchState = IDLE;
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    //A non-primary pointer has gone up.
                   // myTouchEvent.setText("ACTION_POINTER_UP");
                    touchState = TOUCH;
                    break;
            }

            return true;
        }

    };

}
