package com.example.frontbutton;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setBackgroundColor(Color.GRAY);
        button1.setTextColor(Color.BLACK);
        button2.setBackgroundColor(Color.GREEN);
        button2.setTextColor(Color.BLACK);
        button3.setBackgroundColor(Color.RED);
        button3.setTextColor(Color.BLACK);
        button4.setBackgroundColor(Color.YELLOW);
        button4.setTextColor(Color.BLACK);

        button1.setOnClickListener(view -> {
            Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.nate.com"));
            startActivity(mlntent);
        });

        button2.setOnClickListener(view -> {
            Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
            startActivity(mlntent);
        });

        button3.setOnClickListener(view -> {
            Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            startActivity(mlntent);
        });

        button4.setOnClickListener(view -> finish());
    }
}