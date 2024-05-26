package com.example.exam10_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        Button btnReturn = findViewById(R.id.btnReturn2);
        btnReturn.setOnClickListener(v -> finish());
    }
}
