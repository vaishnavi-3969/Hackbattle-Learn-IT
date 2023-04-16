//----------------------
package com.hackbattle.learnit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hackbattle.learnit.Leaderboard;
import com.hackbattle.learnit.R;
import com.hackbattle.learnit.adapter.CourseAdapter;
import com.hackbattle.learnit.model.Course;
import com.hackbattle.learnit.model.RewardDialog;
import com.hackbattle.learnit.model.StreakDialog;

import java.util.ArrayList;
import java.util.List;


public class Homepage extends AppCompatActivity {
    RecyclerView coursesRecyclerView;
    ImageView profileImage;
    TextView seeall;
    ImageView sidebarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        coursesRecyclerView = findViewById(R.id.course_recycler);
        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        profileImage = (ImageView) findViewById(R.id.profile);
        seeall = findViewById(R.id.seeAll);
        sidebarButton = (ImageView) findViewById(R.id.sidebar);
        seeall.setOnClickListener(v -> {
            Intent intent = new Intent(Homepage.this, AllCourses.class);
            startActivity(intent);
            Toast.makeText(Homepage.this, "Retrieving all courses list....", Toast.LENGTH_SHORT).show();
        });


        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this, ProfileActivity.class);
                startActivity(intent);

            }
        });

        List<Course> allcourses = new ArrayList<>();
        allcourses.add(new Course("Web Designing"));
        allcourses.add(new Course("Augmented Reality"));
        allcourses.add(new Course("Video Editing"));
        allcourses.add(new Course("Web3 Engineering"));
        allcourses.add(new Course("UX Design"));
        allcourses.add(new Course("Devops"));
        allcourses.add(new Course("Java Full Stack"));
        allcourses.add(new Course("DevOps"));
        allcourses.add(new Course("Data Science"));
        allcourses.add(new Course("Cloud Computing"));
        allcourses.add(new Course("Embedded Systems"));
        allcourses.add(new Course("Web Development"));
        allcourses.add(new Course("Data Analytics"));
        allcourses.add(new Course("Digital Marketing"));

        CourseAdapter adapter = new CourseAdapter(allcourses);
        coursesRecyclerView.setAdapter(adapter);

        StreakDialog sd = new StreakDialog(this);
        sd.show();
        sidebarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Leaderboard.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit LearnIt?")
                .setMessage("Are you sure you want to exit LearnIt?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }

}