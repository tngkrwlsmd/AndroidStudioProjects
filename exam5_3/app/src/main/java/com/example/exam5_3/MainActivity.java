package com.example.exam5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        EditText editText = new EditText(this);
        Button button = new Button(this);
        TextView textView = new TextView(this);

        button.setText("버튼입니다");
        button.setBackgroundColor(Color.rgb(255, 255, 0));
        button.setOnClickListener(arg0 -> {
            String text = String.valueOf(editText.getText());
            textView.setText(text);
        });

        baseLayout.addView(editText);
        baseLayout.addView(button);
        baseLayout.addView(textView);
    }
}