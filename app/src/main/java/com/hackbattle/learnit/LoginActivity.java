package com.hackbattle.learnit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ImageView login;
    EditText email, password;
    private FirebaseAuth mAuth;
    TextView forgotPswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (ImageView) findViewById(R.id.loginBtn2);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        forgotPswd = (TextView) findViewById(R.id.forgotPassword);
        login.setOnClickListener(v -> loginUserAccount());

    }

    private void loginUserAccount() {

        String emailText, passwordText;
        emailText = email.getText().toString();
        passwordText = password.getText().toString();

        if (TextUtils.isEmpty(emailText)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, Homepage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                    }
                });
    }
}