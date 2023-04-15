package com.hackbattle.learnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hackbattle.learnit.adapter.CourseAdapter;
import com.hackbattle.learnit.model.Course;
import com.hackbattle.learnit.model.RewardDialog;
import com.hackbattle.learnit.model.StreakDialog;

import java.util.ArrayList;
import java.util.List;


public class Homepage extends AppCompatActivity {
    RecyclerView coursesRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homepage);

        coursesRecyclerView = findViewById(R.id.course_recycler);
        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        RewardDialog dialog = new RewardDialog(this);
//
//        dialog.show();

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("UX Design"));
        courses.add(new Course("Devops"));
        courses.add(new Course("Java Full Stack"));
        courses.add(new Course("DevOps"));
        courses.add(new Course("Data Science"));
        courses.add(new Course("Cloud Computing"));
        courses.add(new Course("Embedded Systems"));
        courses.add(new Course("Web Development"));
        CourseAdapter adapter = new CourseAdapter(courses);
        coursesRecyclerView.setAdapter(adapter);

        StreakDialog sd = new StreakDialog(this);
        sd.show();
    }
}