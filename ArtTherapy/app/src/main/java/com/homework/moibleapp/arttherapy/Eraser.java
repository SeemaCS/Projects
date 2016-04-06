package com.homework.moibleapp.arttherapy;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by ssardesai on 2/24/2016.
 */
public class Eraser extends IntentService {
    private boolean flag = false;
    public Eraser() {
        super("This is Intent Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        MediaPlayer mp = MediaPlayer.create(Eraser.this, R.raw.eraser);
        mp.start();
        while(mp.isPlaying()) {
            Toast.makeText(this, "Erasing", Toast.LENGTH_SHORT).show();
        }
        mp.reset();
        mp.release();

    }
}
