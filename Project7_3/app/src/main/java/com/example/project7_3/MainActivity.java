package com.example.project7_3;

import android.os.Bundle;
import android.view.View;
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
    TextView toastText;
    View diglogView, toastView;
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
            dlg.setView(diglogView);
            dlg.setPositiveButton("확인", null);
            dlg.setNegativeButton("취소", null);
            dlg.show();

            dlg.setPositiveButton("확인", (dialogInterface, i) -> {
                dlgEdtName = diglogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = diglogView.findViewById(R.id.dlgEdt2);

                tvName.setText(dlgEdtName.getText());
                tvEmail.setText(dlgEdtEmail.getText());
            });

            dlg.setNegativeButton("취소", (dialogInterface, i) -> {
                Toast toast = new Toast(MainActivity.this);
                toastView = View.inflate(MainActivity.this, R.layout.toast1, null);
                toastText = toastView.findViewById(R.id.toastText1);
                toastText.setText("취소했습니다");
                toast.setView(toastView);
                toast.show();
            });
        });
    }
}