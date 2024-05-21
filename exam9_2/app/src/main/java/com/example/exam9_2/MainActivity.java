package com.example.exam9_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibBlur, ibEmbos;
    MyGraphicView graphicView;
    static float scaleX = 1, scaleY = 1, angle = 0, color = 1, setBlur = 0, setEmbos;

    private void clickIcons() {
        ibZoomin = findViewById(R.id.ibZoomin);
        ibZoomout = findViewById(R.id.ibZoomout);
        ibRotate = findViewById(R.id.ibRotate);
        ibBright = findViewById(R.id.ibBright);
        ibDark = findViewById(R.id.ibDark);
        ibBlur = findViewById(R.id.ibBlur);
        ibEmbos = findViewById(R.id.ibEmbos);

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
        ibBlur.setOnClickListener(view -> {
            if (setBlur == 0) setBlur = 1;
            else setBlur = 0;
           graphicView.invalidate();
        });
        ibEmbos.setOnClickListener(view -> {
            if (setEmbos == 0) setEmbos = 1;
            else setEmbos = 0;
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
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            if (setBlur == 1) {
                BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
            } else if (setEmbos == 1) {
                EmbossMaskFilter eMask = new EmbossMaskFilter(new float[]{3, 3, 3}, 0.5f, 5, 10);
                paint.setMaskFilter(eMask);
            } else {
                paint.setMaskFilter(null);
            }

            if (setBlur == 1 && setEmbos == 1) {
                BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                EmbossMaskFilter eMask = new EmbossMaskFilter(new float[]{3, 3, 3}, 0.5f, 5, 10);
                paint.setMaskFilter(bMask);
                canvas.saveLayer(null, paint);
                paint.setMaskFilter(eMask);
            }
            @SuppressLint("DrawAllocation") Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.flower01);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}