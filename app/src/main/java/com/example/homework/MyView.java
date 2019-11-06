package com.example.homework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.CountDownTimer;
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
    void colorballs(){
        for (int i = 0; i < N; i++) {
            Green[i] = (int) (Math.random() * 206 + 50);
            Red[i] = (int) (Math.random() * 206 + 50);
            Blue[i] = (int) (Math.random() * 206 + 50);
            R[i] = (float) (Math.random() * 80 + 30);

        }
    }
    @SuppressLint("DrawAllocation")
    public MyView(Context context) {
        super(context);
        colorballs();
    }
    void makeBalls() {
        fillArrayRandom(x, 50, 250);
        fillArrayRandom(y, 50, 250);
        fillArrayRandom(vx, -50, 100);
        fillArrayRandom(vy, -50, 100);
        fillArrayRandom(L, 3, 10);
        fillArrayRandom(Red, 50, 255);
        fillArrayRandom(Green, 50, 255);
        fillArrayRandom(Blue, 50, 255);
        fillArrayRandom(R, 20, 40);
    }

    void moveBalls() {
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                x[i] = this.getWidth() / 2 + (int) (L[i] * vx[i] * Math.cos(a));
                y[i] = this.getHeight() / 2 + (int) (z * L[i] * vy[i] * Math.sin(a));
            } else {
                x[i] = this.getWidth() / 2 + (int) (L[i] * vx[i] * Math.cos(a));
                y[i] = this.getHeight() / 2 + (int) (L[i] * vy[i] * Math.sin(a));
            }
        }
        a = a + ha;
    }

    MyView(Context context) {
        super(context);
        makeBalls();
        MyTimer timer = new MyTimer();
        timer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        if (!started){
            for (int i = 0; i < N; i++){
                x[i] = (float)(Math.random() * (getWidth()-200)+160);
                y[i] = (float)(Math.random() * (getHeight()-200)+160);
                vx[i] = (float)(Math.random() * 8 + 2);
                vy[i] = (float)(Math.random() * 8 + 2);

            }
            started = true;
        }
        for (int i = 0; i < N; i++) {
            paint.setColor(Color.argb(200,Red[i],Green[i],Blue[i]));
            canvas.drawCircle(x[i], y[i], R[i], paint);
        }
        for (int i = 0; i < N; i++) {
            if (x[i]-R[i] < 0 || x[i]+R[i] > this.getWidth()) {
                vx[i] = -vx[i];
            }
            if (y[i]-R[i] < 0 || y[i]+R[i] > this.getHeight()) {
                vy[i] = -vy[i];
            }
            if (x[i] < 0 || x[i] > this.getHeight()) {
                vx[i] = (float) (Math.random() * 8 + 2);
                vy[i] = (float) (Math.random() * 8 + 2);
            }
            x[i] += vx[i];
            y[i] += vy[i];
        }
        invalidate();
    }
    class MyTimer extends CountDownTimer {
        MyTimer() {
            super(1000000, 1);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            nextFrame();
        }
        @Override
        public void onFinish() {
        }
    }
}
