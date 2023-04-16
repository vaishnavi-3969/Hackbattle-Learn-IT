package com.hackbattle.learnit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    EditText username, email, password;
    ImageView register, login;
    static final String TAG = "RegistrationActivity";
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = (ImageView)findViewById(R.id.registerBtn);
        login = (ImageView)findViewById(R.id.loginBtn);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();

                if (TextUtils.isEmpty(emailText)) {
                    Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordText)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
//                                    progressBar.setVisibility(View.GONE);
                                    Intent intent = new Intent(RegistrationActivity.this, Homepage.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });
        login.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            Toast.makeText(RegistrationActivity.this, "Switching to Login...", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }


}