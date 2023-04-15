package com.hackbattle.learnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.hackbattle.learnit.adapter.CourseAdapter;
import com.hackbattle.learnit.model.Course;

import java.util.ArrayList;
import java.util.List;

public class AllCourses extends AppCompatActivity {
    RecyclerView coursesRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);
        coursesRecyclerView = findViewById(R.id.course_recycler);
        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
    }
}