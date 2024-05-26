package com.example.exam10_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final Map<Integer, Class<?>> activityMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMap.put(R.id.Second, SecondActivity.class);
        activityMap.put(R.id.Third, ThirdActivity.class);

        RadioGroup radio = findViewById(R.id.Radio);

        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(v -> {
            int check = radio.getCheckedRadioButtonId();
            Class<?> activityClass = activityMap.get(check);

            if (activityClass != null) {
                Intent intent = new Intent(getApplicationContext(), activityClass);
                startActivity(intent);
            }
        });
    }
}