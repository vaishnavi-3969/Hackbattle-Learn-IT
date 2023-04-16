package com.hackbattle.learnit.model;

import static androidx.browser.customtabs.CustomTabsClient.getPackageName;

//import android.annotation.SuppressLint;
//import android.app.Dialog;
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.media.Image;
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.VideoView;
//
//import com.hackbattle.learnit.R;
//
//public class CertificateDialog extends Dialog {
//
//    public CertificateDialog(Context context) {
//        super(context);
//        setContentView(R.layout.certificate_dialog);
//
//        setCancelable(false);
//        setCanceledOnTouchOutside(false);
//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        VideoView videoView = findViewById(R.id.videoView);
//        String videoUrl = "https://github.com/vaishnavi-3969/Learn-IT/blob/21894bf8cff4361743c95a91ea5b2ae7f3d3f413/app/src/main/res/raw/pirateflag.mp4";
//        videoView.setVideoURI(Uri.parse(videoUrl));
//        videoView.start();
////        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
////            @Override
////            public void onCompletion(MediaPlayer mp) {
////                dismiss();
////            }
////        });
//
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView okButton = (ImageView) findViewById(R.id.reward_image);
//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });
//    }
//
//}

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.hackbattle.learnit.R;

public class CertificateDialog extends Dialog {

    private VideoView videoView;
    private ImageView claimBtn;

    public CertificateDialog(Context context) {
        super(context);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.certificate_dialog, null);
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
        String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.pirateflag;
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
}

