package com.example.project8_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class myPictureView extends View {
    String imagePath = null;
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        if (imagePath != null) {
            @SuppressLint("DrawAllocation") Bitmap bitmap = BitmapFactory.decodeFile(imagePath);

            int canvasWidth = getWidth();
            int canvasHeight = getHeight();
            float bitmapWidth = bitmap.getWidth();
            float bitmapHeight = bitmap.getHeight();

            float scale = Math.min(canvasWidth / bitmapWidth, canvasHeight / bitmapHeight);
            float scaledWidth = bitmapWidth * scale;
            float scaledHeight = bitmapHeight * scale;

            float x = (canvasWidth - scaledWidth) / 2;
            float y = (canvasHeight - scaledHeight) / 2;

            canvas.drawBitmap(bitmap, null, new RectF(x, y, x + scaledWidth, y + scaledHeight), null);


            bitmap.recycle();
        }
    }
}
