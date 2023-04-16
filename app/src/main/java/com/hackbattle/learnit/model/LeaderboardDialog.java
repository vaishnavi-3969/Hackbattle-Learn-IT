package com.hackbattle.learnit.model;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.hackbattle.learnit.R;

public class LeaderboardDialog extends Dialog {

    private VideoView videoView;
    private ImageView claimBtn;

    public LeaderboardDialog(Context context) {
        super(context);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.leaderboard_dialog, null);
        setContentView(view);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        claimBtn = findViewById(R.id.reward_image);

        claimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        videoView = view.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.gems;
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        setOnShowListener(dialog -> {
            videoView.start();
        });
        videoView.setOnPreparedListener(mp -> mp.setLooping(true));
        setOnDismissListener(dialog -> {
            videoView.stopPlayback();
        });

    }
}

