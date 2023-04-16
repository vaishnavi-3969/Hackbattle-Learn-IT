package com.hackbattle.learnit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

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
