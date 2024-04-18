package com.example.project5_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        textResult = findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });

        btnSub.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });

        btnMul.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });

        btnDiv.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) / Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });

        for(i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        for(i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(v -> {
                if (edit1.isFocused()) {
                    num1 = edit1.getText().toString() + numButtons[i].getText().toString();
                    edit1.setText(num1);
                } else if (edit2.isFocused()) {
                    num2 = edit2.getText().toString() + numButtons[i].getText().toString();
                    edit2.setText(num2);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}