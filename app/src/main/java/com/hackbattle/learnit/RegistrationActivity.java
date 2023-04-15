package com.hackbattle.learnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.util.Log;
import android.widget.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.text.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {
    EditText username, email, password;
    static final String TAG = "RegistrationActivity";
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
         username = findViewById(R.id.username);
         email = findViewById(R.id.email);
         password = findViewById(R.id.password);
        Button register = (Button) findViewById(R.id.registerBtn);
        Button login = (Button) findViewById(R.id.loginBtn);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name = String.valueOf(username.getText());
                String _email = String.valueOf(email.getText());
                String _password = String.valueOf(password.getText());
                if (TextUtils.isEmpty(_name) || TextUtils.isEmpty(_email) || TextUtils.isEmpty(_password)) {
                    username.setError("Enter username");
                    email.setError("Enter email");
                    password.setError("Enter password");
                    Toast.makeText(RegistrationActivity.this, "*All fields are mandatory", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    mAuth.createUserWithEmailAndPassword(_email, _password)
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(RegistrationActivity.this, "Authentication success.",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(RegistrationActivity.this, Homepage.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }
            }
            });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}