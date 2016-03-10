package project.scu.edu.chew.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.User;

// Display Login options - home screen
public class LoginOptionsActivity2 extends AppCompatActivity {

    Button skipButton;
    Button loginButton;
    Button signUpButton;
    Button fbButton;
    Button instaButton;
    Button twiButton;
    Button googleButton;

    static List<User> users;

    private Firebase mFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options2);

        skipButton = (Button) findViewById(R.id.skipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginOptionsActivity2.this, HCListActivity5.class);
                if (intent != null)
                    startActivity(intent);

            }
        });

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginOptionsActivity2.this, LoginActivity3.class);
                if(intent != null)
                    startActivity(intent);
            }
        });

        signUpButton = (Button) findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginOptionsActivity2.this, SignUpActivity4.class);
                if(intent != null)
                    startActivity(intent);
            }
        });


        fbButton = (Button) findViewById(R.id.fbButton);
        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Intent> targetShareIntents=new ArrayList<Intent>();
                Intent appIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"));
                if(appIntent1 != null)
                    targetShareIntents.add(appIntent1);

                Intent appIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                if(appIntent2 != null)
                    targetShareIntents.add(appIntent2);

                if(!targetShareIntents.isEmpty()) {
                    Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Choose an app to Login");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
                    startActivity(chooserIntent);
                }
            }
        });

        instaButton = (Button) findViewById(R.id.instaButton);
        instaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Intent> targetShareIntents=new ArrayList<Intent>();
                Intent appIntent1 = new Intent(Intent.ACTION_VIEW);
                appIntent1.setPackage("com.instagram.android");
                if(appIntent1 != null)
                    targetShareIntents.add(appIntent1);

                Intent appIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
                if(appIntent2 != null)
                    targetShareIntents.add(appIntent2);

                if(!targetShareIntents.isEmpty()) {
                    Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Choose an app to Login");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
                    startActivity(chooserIntent);
                }

            }
        });

        twiButton = (Button) findViewById(R.id.twitterButton);
        twiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Intent> targetShareIntents=new ArrayList<Intent>();
                Intent appIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user"));
               // appIntent1.setPackage("com.twitter.android");
                if(appIntent1 != null)
                    targetShareIntents.add(appIntent1);

//                Intent appIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/"));
//                if(appIntent2 != null)
//                    targetShareIntents.add(appIntent2);

                if(!targetShareIntents.isEmpty()) {
                    Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Choose an app to Login");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
                    startActivity(chooserIntent);
                }

            }
        });

        googleButton = (Button) findViewById(R.id.gButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Intent> targetShareIntents=new ArrayList<Intent>();
                Intent appIntent1 = new Intent(Intent.ACTION_VIEW);
                appIntent1.setClassName("com.google.android.apps.plus",
                        "com.google.android.apps.plus.phone.UrlGatewayActivity");
                if(appIntent1 != null)
                    targetShareIntents.add(appIntent1);

                Intent appIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/"));
                if(appIntent2 != null)
                    targetShareIntents.add(appIntent2);

                if(!targetShareIntents.isEmpty()) {
                    Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Choose an app to Login");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
                    startActivity(chooserIntent);
                }

            }
        });

        Firebase.setAndroidContext(this);

        loadUsersFromFirebase();



}

    public void loadUsersFromFirebase() {
        Firebase ref = new Firebase("https://gobble.firebaseio.com/");


        ref.addValueEventListener(new ValueEventListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                DataSnapshot newSnap = snapshot.child("users");

                if(snapshot.getValue() != null) {
                    users = new ArrayList<User>();

                        for (DataSnapshot messageSnapshot: newSnap.getChildren()) {
                            User userObject = (User)messageSnapshot.getValue(User.class);
                            users.add(userObject);
                        }

                }
            }
            @Override
            public void onCancelled(FirebaseError arg0) {
                // TODO Auto-generated method stub
            }
        });

    }

    public static User getUser(String email){
        User user = null;

        for(User myUser: users) {
            if(myUser.getEmail().equals(email)) {
                user = myUser;
                break;
            }
        }

        return user;
    }
}
