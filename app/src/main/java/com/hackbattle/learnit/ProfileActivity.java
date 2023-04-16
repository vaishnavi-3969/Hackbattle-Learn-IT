package com.hackbattle.learnit;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hackbattle.learnit.model.UpdateDialog;

 public class ProfileActivity extends AppCompatActivity {
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        button = (Button) findViewById(R.id.update);
        button.setOnClickListener(v -> {
            UpdateDialog updateDialog = new UpdateDialog(ProfileActivity.this);
            updateDialog.show();
        });
    }

 }