package com.example.project9_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;
    static float scaleX = 1, scaleY = 1, angle = 0, color = 1, satur = 1;

    private void clickIcons() {
        ibZoomin = findViewById(R.id.ibZoomin);
        ibZoomout = findViewById(R.id.ibZoomout);
        ibRotate = findViewById(R.id.ibRotate);
        ibBright = findViewById(R.id.ibBright);
        ibDark = findViewById(R.id.ibDark);
        ibGray = findViewById(R.id.ibGray);

        ibZoomin.setOnClickListener(view -> {
            scaleX = scaleX + 0.2f;
            scaleY = scaleY + 0.2f;
            graphicView.invalidate();
        });
        ibZoomout.setOnClickListener(view -> {
            scaleX = scaleX - 0.2f;
            scaleY = scaleY - 0.2f;
            graphicView.invalidate();
        });
        ibRotate.setOnClickListener(view -> {
            angle = angle + 20;
            graphicView.invalidate();
        });
        ibBright.setOnClickListener(view -> {
            color = color + 0.2f;
            graphicView.invalidate();
        });
        ibDark.setOnClickListener(view -> {
            color = color - 0.2f;
            graphicView.invalidate();
        });
        ibGray.setOnClickListener(view -> {
            if (satur == 0) satur = 1;
            else satur = 0;
            graphicView.invalidate();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = findViewById(R.id.pictureLayout);
        graphicView = new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        clickIcons();
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth()/ 2;
            int cenY = this.getHeight()/ 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = {color, 0, 0, 0, 0,
                            0, color, 0, 0, 0,
                            0, 0, color, 0, 0,
                            0, 0, 0, 1, 0};
            ColorMatrix cm = new ColorMatrix(array);
            if (satur == 0) cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            @SuppressLint("DrawAllocation") Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.renoir01);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}