package project.scu.edu.chew.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import project.scu.edu.chew.R;

// Shows the cart details
public class CartActivity10 extends BaseActivity {

    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart10);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();


        TopToolbarFragment toolbarFragment = new TopToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.toptoolbarcontainer, toolbarFragment).commit();

        CartContentFragment cartContentFragment = new CartContentFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainContentcontainer, cartContentFragment).commit();


    }

    public void showNotification(View view)
    {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setSmallIcon(R.drawable.gobble_logo).setColor(Color.rgb(255,153,0));
        mBuilder.setVibrate(new long[] {100,250}).setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Your order has been successfully placed!");

        Intent resultIntent = new Intent(this, OrderStausActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(OrderStausActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(3, mBuilder.build());
    }


}
