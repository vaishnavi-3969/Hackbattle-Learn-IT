package com.hackbattle.learnit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.hackbattle.learnit.model.CertificateDialog;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        ImageView imageView = findViewById(R.id.claimCertificate);
        imageView.setOnClickListener(v -> {
            CertificateDialog dialog = new CertificateDialog(this);
            dialog.show();
        });
    }
}