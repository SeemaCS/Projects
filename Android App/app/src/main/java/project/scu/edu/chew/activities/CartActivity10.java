package project.scu.edu.chew.activities;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.CartItem;
import project.scu.edu.chew.models.UserSession;

// Shows the cart details
public class CartActivity10 extends BaseActivity implements IVoiceControl {

    Button orderButton;
    Context context;
    protected SpeechRecognizer sr;

    final static private long ONE_SECOND = 1000;
    final static private long TWENTY_SECONDS = ONE_SECOND * 20;
    PendingIntent pi;
    BroadcastReceiver br;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart10);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        setup();
        TopToolbarFragment toolbarFragment = new TopToolbarFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.toptoolbarcontainer, toolbarFragment).commit();

        CartContentFragment cartContentFragment = new CartContentFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainContentcontainer, cartContentFragment).commit();

//
//        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);

        // The following 3 lines are needed in every onCreate method of a ListeningActivity
        context = getApplicationContext(); // Needs to be set
        VoiceRecognitionListener.getInstance().setListener(this); // Here we set the current listener




    }

    public void showNotification()
    {

//        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setSmallIcon(R.drawable.gobble_logo).setColor(Color.rgb(255, 153, 0));
        mBuilder.setVibrate(new long[]{100, 250}).setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Your order is ready for pick up!");

        Intent resultIntent = new Intent(this, OrderStausActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(OrderStausActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(3, mBuilder.build());
    }


    // starts the service
    protected void startListening() {
        try {
            initSpeech();
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
            if (!intent.hasExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE))
            {
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                        "com.dummy");
            }
            sr.startListening(intent);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // stops the service
    protected void stopListening() {
        if (sr != null) {
            sr.stopListening();
            sr.cancel();
            sr.destroy();
        }
        sr = null;
    }

    protected void initSpeech() {
        if (sr == null) {
            sr = SpeechRecognizer.createSpeechRecognizer(this);
            if (!SpeechRecognizer.isRecognitionAvailable(context)) {
                Toast.makeText(context, "Speech Recognition is not available",
                        Toast.LENGTH_LONG).show();
                finish();
            }
            sr.setRecognitionListener(VoiceRecognitionListener.getInstance());
        }
    }

    @Override
    public void finish() {
        stopListening();
        super.finish();
    }

    @Override
    protected void onStop() {
        stopListening();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (sr != null) {
            sr.stopListening();
            sr.cancel();
            sr.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
//        AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        if(sr!=null){
            sr.stopListening();
            sr.cancel();
            sr.destroy();

        }
        sr = null;

        super.onPause();
    }

    @Override
    public void processVoiceCommands(String... voiceCommands) {
        String finalCommand = null;
        // content.removeAllViews();
        for (String command : voiceCommands) {
            TextView txt = new TextView(getApplicationContext());
            txt.setText(command);
            txt.setTextSize(20);
            txt.setTextColor(Color.BLACK);
            txt.setGravity(Gravity.CENTER);

            if(command.equalsIgnoreCase("place order")) {
                finalCommand = command;
                clearCart();
                showAlert();
                //showNotification();

            }
            // content.addView(txt);


            //Toast.makeText(BaseActivity.this, txt.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        System.out.println("Here....." + finalCommand);
        if(finalCommand != null && finalCommand.equalsIgnoreCase("place order")) {
//            if (sr != null) {
//                sr.stopListening();
//                sr.cancel();
//                sr.destroy();
//            }

        } else {
            restartListeningService();
        }
    }

    @Override
    public void restartListeningService() {
        stopListening();
        startListening();
    }

    public  void clearCart() {

        ListView listView = (ListView) findViewById(R.id.cart_list_view);
//        listView.clear

        // Remove from shared Preferences
        SharedPreferences gobblePreferences = getSharedPreferences("GOBBLE_PREFS", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gobblePreferences.getString("currentSession", "");
        UserSession userSession = gson.fromJson(json, UserSession.class);
        List<CartItem> items = userSession.getCartItems();
        items.clear();


        double totalValue = 0;
        System.out.println("Setting total in cart:" + totalValue);
        userSession.setTotalValueInCart(totalValue);

        TextView totalText = (TextView) findViewById(R.id.ctotal);
        TextView cartItemMsg = (TextView) findViewById(R.id.noItemMsg);

        totalText.setText("Total: $" + Double.toString(Math.round(userSession.getTotalValueInCart())));

        userSession.setBadgeCount(0);

        SharedPreferences.Editor editor = gobblePreferences.edit();
        String writeJson = gson.toJson(userSession);
        editor.putString("currentSession", writeJson);
        editor.commit();

        if(userSession.getBadgeCount() <= 0) {
            cartItemMsg.setVisibility(View.VISIBLE);
        } else {
            cartItemMsg.setVisibility(View.INVISIBLE);
        }


        CartAdapter adapter = (CartAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();
        listView.setAdapter(null);
    }

    public void showAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("NOTIFICATION");
        alertDialog.setMessage("Thank you for Placing order! Would you like to set a reminder once your order is ready for pick up?");
        alertDialog.setIcon(R.drawable.gobble_logo);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() +
                        TWENTY_SECONDS, pi);
                ;
            }
        });
        alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertDialog.show();
    }

    private void setup() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent i) {
                //Toast.makeText(c, "Your order has been placed", Toast.LENGTH_LONG).show();
               showNotification();
            }
        };
        registerReceiver(br, new IntentFilter("com.authorwjf.wakeywakey"));
        pi = PendingIntent.getBroadcast( this, 0, new Intent("com.authorwjf.wakeywakey"),
                0 );
        am = (AlarmManager)(getSystemService(Context.ALARM_SERVICE ));
    }

}
