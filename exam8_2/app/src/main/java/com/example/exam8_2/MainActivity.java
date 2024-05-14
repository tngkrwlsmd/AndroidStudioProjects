package com.example.exam8_2;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum = 0;
    File[] imageFiles = new File[0];
    String imageFname;
    TextView imageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MODE_PRIVATE);
        } else startApp();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MODE_PRIVATE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startApp();
            } else {
                Toast.makeText(this, "파일 권한을 허용해야 앱을 사용할 수 있습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void startApp() {
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myPicture = findViewById(R.id.myPrictureView1);
        imageCount = findViewById(R.id.imageCount);

        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        for (File allFile : Objects.requireNonNull(allFiles)) {
            if (allFile.isFile()) {
                imageFiles = Arrays.copyOf(imageFiles, imageFiles.length + 1);
                imageFiles[imageFiles.length - 1] = allFile;
            }
        }

        if (imageFiles.length > 0) {
            imageFname = imageFiles[curNum].toString();
            myPicture.imagePath = imageFname;
            imageCount.setText((curNum + 1) + "/" + imageFiles.length);
        }

        btnPrev.setOnClickListener(v -> {
            if (imageFiles.length > 0) {
                curNum = (curNum - 1 + imageFiles.length) % imageFiles.length;
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                imageCount.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });

        btnNext.setOnClickListener(v -> {
            if (imageFiles.length > 0) {
                curNum = (curNum + 1) % imageFiles.length;
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                imageCount.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });
    }
}
