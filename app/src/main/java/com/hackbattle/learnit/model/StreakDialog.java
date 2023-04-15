package com.hackbattle.learnit.model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;

import com.hackbattle.learnit.R;

public class StreakDialog extends Dialog {

    public StreakDialog(Context context) {
        super(context);
        setContentView(R.layout.streak);

        setCancelable(false);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView okButton = (ImageView) findViewById(R.id.reward_image);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

}
