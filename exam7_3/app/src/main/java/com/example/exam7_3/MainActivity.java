package com.example.exam7_3;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    View diglogView, toastView;
    @SuppressLint("RtlHardcoded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(v -> {
            diglogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setIcon(R.drawable.ic_launcher_foreground);
            dlgEdtName = diglogView.findViewById(R.id.dlgEdt1);
            dlgEdtEmail = diglogView.findViewById(R.id.dlgEdt2);
            dlgEdtName.setText(tvName.getText());
            dlgEdtEmail.setText(tvEmail.getText());
            dlg.setView(diglogView);

            dlg.setPositiveButton("확인", (dialogInterface, i) -> {
                tvName.setText(dlgEdtName.getText());
                tvEmail.setText(dlgEdtEmail.getText());
            });

            dlg.setNegativeButton("취소", (dialogInterface, i) -> {
                Toast toast = new Toast(MainActivity.this);
                toastView = View.inflate(MainActivity.this, R.layout.toast1, null);
                toast.setText("취소했습니다.");
                toast.setView(toastView);

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int x = (int) (Math.random() * size.x);
                int y = (int) (Math.random() * size.y);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, x, y);
                toast.show();
            });
            dlg.show();
        });
    }
}