package com.hackbattle.learnit;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.hackbattle.learnit.model.LeaderboardDialog;


public class Leaderboard extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        LeaderboardDialog ld = new LeaderboardDialog(this);
        ld.show();
    }
}
