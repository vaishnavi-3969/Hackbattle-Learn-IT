package com.hackbattle.learnit.model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackbattle.learnit.R;

public class RewardDialog extends Dialog {

    public RewardDialog(Context context) {
        super(context);
        setContentView(R.layout.reward_dialog);

        setCancelable(false);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView okButton = (ImageView) findViewById(R.id.reward_image);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

}
