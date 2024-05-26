package com.example.exam10_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio = findViewById(R.id.Radio);

        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(v -> {
            int check = radio.getCheckedRadioButtonId();
            Intent intent = null;
            if (check == R.id.Second) intent = new Intent(getApplicationContext(), SecondActivity.class);
            else if (check == R.id.Third) intent = new Intent(getApplicationContext(), ThirdActivity.class);

            if (intent != null) startActivity(intent);
        });
    }
}