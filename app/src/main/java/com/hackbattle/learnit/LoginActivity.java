package com.hackbattle.learnit;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ProgressDialog loadingBar;
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
        forgotPswd.setOnClickListener(v -> showRecoverPasswordDialog());
    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");
        LinearLayout linearLayout=new LinearLayout(this);
        final EditText emailet= new EditText(this);

        emailet.setText("Email");
        emailet.setMinEms(16);
        emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        linearLayout.addView(emailet);
        linearLayout.setPadding(10,10,10,10);
        builder.setView(linearLayout);

        builder.setPositiveButton("Recover", (dialog, which) -> {
            String email=emailet.getText().toString().trim();
            beginRecovery(email);
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
    private void beginRecovery(String email) {
        loadingBar=new ProgressDialog(this);
        loadingBar.setMessage("Sending Email....");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();


        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            loadingBar.dismiss();
            if(task.isSuccessful())
            {
                Toast.makeText(LoginActivity.this,"Check you email for password recovery :)",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(LoginActivity.this,"Error!",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(e -> {
            loadingBar.dismiss();
            Toast.makeText(LoginActivity.this,"Error Failed",Toast.LENGTH_LONG).show();
        });
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