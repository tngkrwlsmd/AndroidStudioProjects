package com.example.project7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = findViewById(R.id.button2);
        registerForContextMenu(button2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if ( v == button2) {
            mInflater.inflate(R.menu.menu2, menu);
        }
    }
}