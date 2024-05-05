package com.example.exam7_1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RelativeLayout baseLayout;
    EditText input;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        setTitle("제주도 풍경");
        baseLayout = findViewById(R.id.baseLayout);
        input = findViewById(R.id.editRotate);
        img = findViewById(R.id.imgJeju);
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
        if (item.getItemId() == R.id.item0) {
            img.setRotation(Integer.parseInt(input.getText().toString()));
            return true;
        }
        else if (item.getItemId() == R.id.item1) {
            img.setImageResource(R.drawable.hanrasan);
            return true;
        } else if (item.getItemId() == R.id.item2) {
            img.setImageResource(R.drawable.chujado);
            return true;
        } else if (item.getItemId() == R.id.item3) {
            img.setImageResource(R.drawable.bumsum);
            return true;
        }
        return false;
    }
}