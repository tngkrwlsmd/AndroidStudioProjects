package com.example.project4_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRmd;
    TextView textResult;
    String num1, num2;
    Double result;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기(수정)");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnRmd = findViewById(R.id.BtnRmd);
        textResult = findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            try {
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnSub.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            try {
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnMul.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            try {
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnDiv.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            try {
                if (Double.parseDouble(num2) == 0) throw new ArithmeticException();
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            } catch (ArithmeticException e) {
                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnRmd.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            try {
                if (Double.parseDouble(num2) == 0) throw new ArithmeticException();
                result = Double.parseDouble(num1) % Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result);
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            } catch (ArithmeticException e) {
                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}