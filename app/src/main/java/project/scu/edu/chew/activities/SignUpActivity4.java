package project.scu.edu.chew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import project.scu.edu.chew.R;
import project.scu.edu.chew.database.User;

// Sign up Screen - Activity to create a new account with Gobble
public class SignUpActivity4 extends AppCompatActivity {

    Button signupButton;
    EditText inputName;
    EditText inputEmail;
    EditText inputPassword;
    TextView linkLogin;

    TextView errorMsg;

    private Firebase mFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        errorMsg = (TextView) findViewById(R.id.errorMsg);
        linkLogin = (TextView) findViewById(R.id.link_login);

        signupButton = (Button) findViewById(R.id.btn_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                validateCredentials(name, email, password);
            }
        });

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity4.this, LoginActivity3.class);
                if(intent != null)
                    startActivity(intent);
                finish();
            }
        });

        Firebase.setAndroidContext(this);

    }

    public void validateCredentials(String name, String email, String password) {
        boolean cancel = false;
        View focusView = null;

        //Check for valid name
        if (TextUtils.isEmpty(name)) {
            inputName.setError(getString(R.string.error_field_required));
            focusView = inputName;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            inputPassword.setError(getString(R.string.error_invalid_password));
            focusView = inputPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            inputEmail.setError(getString(R.string.error_field_required));
            focusView = inputEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            inputEmail.setError(getString(R.string.error_invalid_email));
            focusView = inputEmail;
            cancel = true;
        }



        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            createUser(name, email, password);
        }
    }

    private void createUser(final String name, final String email, final String password) {
        mFirebaseRef = new Firebase("https://gobble.firebaseio.com");
        mFirebaseRef.createUser(email, password, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                errorMsg.setText("");
                User newUser = new User(name, email, password);
                Firebase userRef = mFirebaseRef.child("users").child(newUser.getId() + "");
                userRef.setValue(newUser);

                Intent intent = new Intent(SignUpActivity4.this, HCListActivity5.class);
                if(intent != null)
                    startActivity(intent);
                finish();

            }

            @Override
            public void onError(FirebaseError firebaseError) {
                errorMsg.setText("Login failed " + firebaseError.getMessage());
            }
        });
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
