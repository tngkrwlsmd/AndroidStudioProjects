package com.example.exam10_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Objects;

public class ResultActivity extends Activity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView[] tv = new TextView[Objects.requireNonNull(imageName).length];
        RatingBar[] rbar = new RatingBar[imageName.length];

        Integer[] tvID = {R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9};
        Integer[] rbarID = {R.id.rbar1, R.id.rbar2, R.id.rbar3,
                R.id.rbar4, R.id.rbar5, R.id.rbar6,
                R.id.rbar7, R.id.rbar8, R.id.rbar9};
        Integer[] imageFildId = {R.drawable.renoir01, R.drawable.renoir02, R.drawable.renoir03,
                                 R.drawable.renoir04, R.drawable.renoir05, R.drawable.renoir06,
                                 R.drawable.renoir07, R.drawable.renoir08, R.drawable.renoir09};

        for (int i = 0; i< Objects.requireNonNull(voteResult).length; i++) {
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }

        int max = voteResult[0];
        for (int i : voteResult) {
            if (i > max) max = i;
        }

        TextView txt = findViewById(R.id.txt);
        ImageView img = findViewById(R.id.img);

        txt.setText(imageName[max]);
        img.setImageResource(imageFildId[max]);

        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(view -> finish());
    }
}
