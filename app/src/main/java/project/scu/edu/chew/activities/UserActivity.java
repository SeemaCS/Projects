package project.scu.edu.chew.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.gson.Gson;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.User;
import project.scu.edu.chew.models.UserSession;

// Edit Profile Screen - Activity to edit user profile - name, email and change password
public class UserActivity extends AppCompatActivity {

    EditText inputName;
    EditText inputEmail;
    Button saveButton;
    EditText oldPassword;
    EditText newPassword;

    private Firebase mFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        inputName = (EditText) findViewById(R.id.uinput_name);
        inputEmail = (EditText) findViewById(R.id.uinput_email);
        oldPassword = (EditText) findViewById(R.id.uinput_password);
        newPassword = (EditText) findViewById(R.id.unew_password);

        SharedPreferences gobblePreferences = getSharedPreferences("GOBBLE_PREFS", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gobblePreferences.getString("currentSession", "");
        UserSession userSession = gson.fromJson(json, UserSession.class);
        System.out.println("User session:" + userSession);

        final User currentUser = userSession.getUser();
        System.out.println(currentUser.getId());
        System.out.println(currentUser.getName());

        inputName.setText(currentUser.getName());
        inputEmail.setText(currentUser.getEmail());

        saveButton = (Button) findViewById(R.id.ubtn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(oldPassword.getText().toString().equals(currentUser.getPassword().toString()))) {
                    Toast.makeText(UserActivity.this, "Old password is not correct", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(oldPassword.getText().toString().equals(newPassword.getText().toString())) {
                    Toast.makeText(UserActivity.this, "New password can not be same as old password", Toast.LENGTH_SHORT).show();
                    return;
                }

                resetPassword(currentUser.getName(), inputEmail.getText().toString(), oldPassword.getText().toString(), newPassword.getText().toString());
            }
        });

        Firebase.setAndroidContext(this);

    }

    private void resetPassword(final String name, final String email, final String oldPassword, final String newPassword) {
        mFirebaseRef = new Firebase("https://gobble.firebaseio.com/users/"+name+"/");
        mFirebaseRef.removeValue();
        createUser(name, email, oldPassword, newPassword);

    }

    private void createUser(final String name, final String email, final String oldpassword, final String newpassword) {
        mFirebaseRef = new Firebase("https://gobble.firebaseio.com");
        mFirebaseRef.removeUser(email, oldpassword, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(FirebaseError firebaseError) {

            }
        });
        mFirebaseRef.createUser(email, newpassword, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
               // errorMsg.setText("");
                User newUser = new User(name, email, newpassword);
                Firebase userRef = mFirebaseRef.child("users").child(name);
                userRef.setValue(newUser);

               // startUserSession(newUser);

//                Intent intent = new Intent(SignUpActivity4.this, HCListActivity5.class);
//                if (intent != null)
//                    startActivity(intent);
//                finish();

            }

            @Override
            public void onError(FirebaseError firebaseError) {
               // errorMsg.setText("Login failed " + firebaseError.getMessage());
            }
        });
    }


}
