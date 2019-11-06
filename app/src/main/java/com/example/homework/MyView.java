package com.example.homework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    int N = 30;
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    int[] Red = new int[N];
    int[] Green = new int[N];
    float[] R = new float[N];
    int[] Blue = new int[N];
    boolean started;

    float rand(float min, float max) {
        return (float) (Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array, float min, float max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand(min, max);
        }
    }

    void fillRandomint(int[] array, float min, float max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) rand(min, max);
        }
    }

    void add(float[] array, float[] values) {
        for (int i = 0; i < array.length; i++) {
            array[i] += values[i];
        }
    }

    @SuppressLint("DrawAllocation")
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        if (!started) {
            fillRandom(x, 300, 900);
            fillRandom(y, 300, 900);
            fillRandom(vx, -5, 5);
            fillRandom(vy, -5, 5);
            fillRandomint(Green, 0, 255);
            fillRandomint(Blue, 0, 255);
            fillRandomint(Red, 0, 255);
            fillRandom(R, 30, 120);
            started = true;
        }
        for (int i = 0; i < N; i++) {
            paint.setColor(Color.argb(200, Red[i], Green[i], Blue[i]));
            canvas.drawCircle(x[i], y[i], R[i], paint);
        }
        for (int i = 0; i < N; i++){
            if (x[i] - R[i] < 0 || x[i] + R[i] > this.getWidth()) {
                vx[i] = -vx[i];
            }
        if (y[i] - R[i] < 0 || y[i] + R[i] > this.getHeight()) {
            vy[i] = -vy[i];
        }
        if (x[i] < 0 || x[i] > this.getHeight()) {
                vx[i] = rand(-5, 5);
                vy[i] = rand(-5, 5);
            }
    }
        add(x, vx);
        add(y, vy);
        invalidate();
    }
}
