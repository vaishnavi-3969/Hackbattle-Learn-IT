package com.hackbattle.learnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homepage);

        coursesRecyclerView = findViewById(R.id.course_recycler);
        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        profileImage = (ImageView) findViewById(R.id.profile);
        seeall = findViewById(R.id.seeAll);

        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, AllCourses.class);
                startActivity(intent);
                Toast.makeText(Homepage.this, "Retrieving all courses list....", Toast.LENGTH_SHORT).show();
            }
        });
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Web Designing"));
        courses.add(new Course("Augmented Reality"));
        courses.add(new Course("Video Editing"));
        courses.add(new Course("Web3 Engineering"));
        courses.add(new Course("UX Design"));
        courses.add(new Course("Devops"));
        courses.add(new Course("Java Full Stack"));
        courses.add(new Course("DevOps"));
        courses.add(new Course("Data Science"));
        courses.add(new Course("Cloud Computing"));
        courses.add(new Course("Embedded Systems"));
        courses.add(new Course("Web Development"));
        courses.add(new Course("Data Analytics"));
        courses.add(new Course("Digital Marketing"));

        CourseAdapter adapter = new CourseAdapter(courses);
        coursesRecyclerView.setAdapter(adapter);

        StreakDialog sd = new StreakDialog(this);
        sd.show();
    }
}