package com.hackbattle.learnit.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackbattle.learnit.CoursePage;
import com.hackbattle.learnit.R;
import com.hackbattle.learnit.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> implements View.OnClickListener {
    private List<Course> courses;

    public CourseAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_course, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.courseName.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), CoursePage.class);
        v.getContext().startActivity(intent);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;
        public ViewHolder(View view) {
            super(view);
            courseName = view.findViewById(R.id.course_name);
        }
    }
}
