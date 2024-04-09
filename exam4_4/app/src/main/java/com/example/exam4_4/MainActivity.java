package com.example.exam4_4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch swAgree;
    RadioGroup rGroup1;
    RadioButton and12, and13, and14;
    Button exit, reset;
    ImageView imgAnd;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.Text1);
        swAgree = findViewById(R.id.SwAgree);
        text2 = findViewById(R.id.Text2);
        rGroup1 = findViewById(R.id.Rgroup1);
        and12 = findViewById(R.id.And12);
        and13 = findViewById(R.id.And13);
        and14 = findViewById(R.id.And14);
        exit = findViewById(R.id.Reset);
        reset = findViewById(R.id.Reset);
        imgAnd = findViewById(R.id.ImaAnd);

        swAgree.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (swAgree.isChecked()) {
                text2.setVisibility(View.VISIBLE);
                rGroup1.setVisibility(View.VISIBLE);
                imgAnd.setVisibility(View.VISIBLE);

                rGroup1.setOnCheckedChangeListener((group, checkedId) -> {
                    if (checkedId == R.id.And12) imgAnd.setImageResource(R.drawable.t12);
                    else if (checkedId == R.id.And13) imgAnd.setImageResource(R.drawable.t13);
                    else if (checkedId == R.id.And14) imgAnd.setImageResource(R.drawable.t14);
                });
            } else {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgAnd.setVisibility(View.INVISIBLE);
            }
        });

        exit.setOnClickListener(arg0 -> {
            finish();
            System.exit(0);
        });

        reset.setOnClickListener((arg0 -> {
            swAgree.setChecked(false);
            text2.setVisibility(View.INVISIBLE);
            rGroup1.clearCheck();
            imgAnd.setVisibility(View.INVISIBLE);
        }));
    }
}