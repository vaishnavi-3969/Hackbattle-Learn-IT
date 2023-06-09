//----------------------
package com.hackbattle.learnit;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackbattle.learnit.adapter.CourseAdapter;
import com.hackbattle.learnit.model.Course;
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
        allcourses.add(new Course("Web3 Engineering"));
        allcourses.add(new Course("UX Design"));
        allcourses.add(new Course("Devops"));
        allcourses.add(new Course("Java Full Stack"));
        allcourses.add(new Course("Data Science"));
        allcourses.add(new Course("Cloud Computing"));
        allcourses.add(new Course("Data Analytics"));

        CourseAdapter adapter = new CourseAdapter(allcourses);
        coursesRecyclerView.setAdapter(adapter);

        StreakDialog sd = new StreakDialog(this);
        sd.show();
        sidebarButton.setOnClickListener(v -> {
            Intent intent = new Intent(Homepage.this, Leaderboard.class);
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.img)
                .setTitle("Exit LearnIt?")
                .setMessage("Are you sure you want to sail away from LearnIt?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }

}