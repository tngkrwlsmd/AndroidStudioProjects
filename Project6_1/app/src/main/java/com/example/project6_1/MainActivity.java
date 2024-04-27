package com.example.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        chrono = findViewById(R.id.chronometer1);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        tPicker = findViewById(R.id.timePicker1);
        calView = findViewById(R.id.calenderView1);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(v -> {
            tPicker.setVisibility(View.INVISIBLE);
            calView.setVisibility(View.VISIBLE);
        });

        rdoTime.setOnClickListener(v -> {
            tPicker.setVisibility(View.VISIBLE);
            calView.setVisibility(View.INVISIBLE);
        });

        btnStart.setOnClickListener(v -> {
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            chrono.setTextColor(Color.RED);
        });

        btnEnd.setOnClickListener(v -> {
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
        });

        calView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            selectYear = year;
            selectMonth = month + 1;
            selectDay = dayOfMonth;
        });

        tvYear.setText(Integer.toString(selectYear));
        tvMonth.setText(Integer.toString(selectMonth));
        tvDay.setText(Integer.toString(selectDay));
        tvHour.setText(Integer.toString(tPicker.getHour()));
        tvMinute.setText(Integer.toString(tPicker.getMinute()));
    }
}