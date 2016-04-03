package project.scu.edu.chew.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.models.UserSession;

public class BaseActivity extends AppCompatActivity {

    private Button mapButton;
    public ListView mDrawerList;
    public DrawerLayout mDrawerLayout;
    Button navigationButton;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;

    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

            // Inflate the layout for this fragment

             mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

            mDrawerList = (ListView)findViewById(R.id.navList);
            addDrawerItems();
            mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    System.out.println("Position: " + position);

                    if (position == 0) {
                        Intent intent = new Intent(BaseActivity.this, HCListActivity5.class);
                        if (intent != null)
                            startActivity(intent);
                    }

                    if (position == 1) {
//                        Intent shareIntent = new Intent();
//                        shareIntent.setAction(Intent.ACTION_SEND);
//                        shareIntent.setType("text/plain");
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, from tutorialspoint");
//                        startActivity(Intent.createChooser(shareIntent, "Share your thoughts"));

//                        List<Intent> targetShareIntents=new ArrayList<Intent>();
//                        Intent appIntent1 = new Intent(Intent.ACTION_SEND, Uri.parse("fb://page/"));
//                        appIntent1.setType("text/plain");
//                        if(appIntent1 != null)
//                            targetShareIntents.add(appIntent1);
//
//                        Intent appIntent2 = new Intent(Intent.ACTION_SEND, Uri.parse("https://www.facebook.com/"));
//                        appIntent2.setType("text/plain");
//                        if(appIntent2 != null)
//                            targetShareIntents.add(appIntent2);
//
//                        if(!targetShareIntents.isEmpty()) {
//                            Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Share your thoughts");
//                            chooserIntent.putExtra(Intent.EXTRA_TEXT, targetShareIntents.toArray(new Parcelable[]{}));
//                            startActivity(chooserIntent);
//                        }

                        List<Intent> targetShareIntents = new ArrayList<Intent>();
                        Intent appIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"));
                        appIntent1.putExtra(Intent.EXTRA_TEXT, "Hello, from gobble");
                        if (appIntent1 != null)
                            targetShareIntents.add(appIntent1);

                        Intent appIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                        appIntent2.putExtra(Intent.EXTRA_TEXT, "Hello, from gobble");
                        if (appIntent2 != null)
                            targetShareIntents.add(appIntent2);

                        if (!targetShareIntents.isEmpty()) {
                            Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Share your thoughts");
                            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
                            startActivity(chooserIntent);
                        }
                    }

                    if (position == 2) {
                        Intent intent = new Intent(BaseActivity.this, AboutActivity.class);
                        if (intent != null)
                            startActivity(intent);
                    }
                    if (position == 3) {
                        Intent intent = new Intent(BaseActivity.this, HelpActivity.class);
                        if (intent != null)
                            startActivity(intent);
                    }


                    if (position == 4) {
                        signOut();
                    }

                    //Toast.makeText(HCListActivity5.this, "", Toast.LENGTH_SHORT).show();
                }
            });

       // content = (LinearLayout)findViewById(R.id.commands);

//// The following 3 lines are needed in every onCreate method of a ListeningActivity
//        context = getApplicationContext(); // Needs to be set
//        VoiceRecognitionListener.getInstance().setListener(this); // Here we set the current listener
//        startListening(); // starts listening


        }

//    @Override
//    public void processVoiceCommands(String... voiceCommands) {
//        String finalCommand = null;
//        // content.removeAllViews();
//        for (String command : voiceCommands) {
//            TextView txt = new TextView(getApplicationContext());
//            txt.setText(command);
//            txt.setTextSize(20);
//            txt.setTextColor(Color.BLACK);
//            txt.setGravity(Gravity.CENTER);
//
//            if(command.equalsIgnoreCase("place order")) {
//                finalCommand = command;
//            }
//            // content.addView(txt);
//
//
//            //Toast.makeText(BaseActivity.this, txt.getText().toString(), Toast.LENGTH_SHORT).show();
//        }
//        System.out.println("Here....." + finalCommand);
//        restartListeningService();
//    }

    private void addDrawerItems() {
            String[] itemsArray = { "Home", "Feedback", "About", "Help", "Sign Out" };
            mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsArray);
            mDrawerList.setAdapter(mAdapter);
        }


    public void signOut() {
        SharedPreferences gobblePreferences = getSharedPreferences("GOBBLE_PREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = gobblePreferences.edit();
        UserSession newSession = new UserSession();
        Gson gson = new Gson();
        String json = gson.toJson(newSession);
        editor.putString("currentSession", json);
        editor.commit();

        Intent intent = new Intent(BaseActivity.this, LoginOptionsActivity2.class);
        if(intent != null)
            startActivity(intent);
        finish();
    }

    }



