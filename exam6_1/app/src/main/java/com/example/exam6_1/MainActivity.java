package com.example.exam6_1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = findViewById(R.id.chronometer1);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        dPicker = findViewById(R.id.datePicker1);
        tPicker = findViewById(R.id.timePicker1);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        chrono.setOnClickListener(v -> {
            rdoCal.setVisibility(View.VISIBLE);
            rdoTime.setVisibility(View.VISIBLE);
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            chrono.setTextColor(Color.RED);
        });

        rdoCal.setOnClickListener(v -> {
            dPicker.setVisibility(View.VISIBLE);
            tPicker.setVisibility(View.INVISIBLE);
        });

        rdoTime.setOnClickListener(v -> {
            dPicker.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.VISIBLE);
        });

        tvYear.setOnLongClickListener(v -> {
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
            rdoCal.setVisibility(View.INVISIBLE);
            rdoTime.setVisibility(View.INVISIBLE);
            dPicker.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.INVISIBLE);
            return true;
        });

        dPicker.setOnDateChangedListener((view, year, month, dayOfMonth) -> {
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