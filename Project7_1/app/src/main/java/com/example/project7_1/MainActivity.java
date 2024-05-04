package com.example.project7_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.button1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemRed) {
            baseLayout.setBackgroundColor(Color.RED);
            return true;
        } else if (item.getItemId() == R.id.itemGreen) {
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        } else if (item.getItemId() == R.id.itemBlue) {
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        } else if (item.getItemId() == R.id.subRotate){
            button1.setRotation(45);
            return true;
        } else if (item.getItemId() == R.id.subSize) {
            button1.setScaleX(2);
            return true;
        }
        return false;
    }
}