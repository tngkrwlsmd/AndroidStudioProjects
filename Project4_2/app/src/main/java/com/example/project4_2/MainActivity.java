package com.example.project4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = findViewById(R.id.Text1);
        chkAgree = findViewById(R.id.ChkAgree);
        text2 = findViewById(R.id.Text2);
        rGroup1 = findViewById(R.id.Rgroup1);
        rdoDog = findViewById(R.id.RdoDog);
        rdoCat = findViewById(R.id.RdoCat);
        rdoRabbit = findViewById(R.id.RdoRabbit);
        btnOK = findViewById(R.id.BtnOK);
        imgPet = findViewById(R.id.ImaPet);

        chkAgree.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (chkAgree.isChecked()) {
                text2.setVisibility(View.VISIBLE);
                rGroup1.setVisibility(View.VISIBLE);
                btnOK.setVisibility(View.VISIBLE);
                imgPet.setVisibility(View.VISIBLE);
            } else {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                btnOK.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
            }
        });

        btnOK.setOnClickListener(arg0 -> {
            int checkedRadio = rGroup1.getCheckedRadioButtonId();
            if (checkedRadio == R.id.RdoDog) imgPet.setImageResource(R.drawable.dog);
            else if (checkedRadio == R.id.RdoCat) imgPet.setImageResource(R.drawable.cat);
            else if (checkedRadio == R.id.RdoRabbit) imgPet.setImageResource(R.drawable.rabbit);
            else {
                Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}