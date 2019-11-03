package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    int N = 10;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    boolean started;

    public MyView(Context context) {
        super(context);
    }
    long lastTime = System.currentTimeMillis();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
<<<<<<< HEAD
<<<<<<< HEAD
    Paint paint= new Paint(),paint1= new Paint();
        paint.setColor(Color.YELLOW);
    Paint.Style Fill;
        canvas.drawRect(100,200,500,500,paint);
=======
        Paint paint1 = new Paint(),paint2=new Paint(),paint3=new Paint(),paint4=new Paint();
        paint1.setColor(Color.YELLOW);
        paint2.setColor(Color.WHITE);
        paint3.setColor(Color.BLACK);
        canvas.drawCircle(500,500,500,paint1);
        canvas.drawCircle(250,250,100,paint2);
        canvas.drawCircle(750,250,100,paint2);
        canvas.drawCircle(250,210,40,paint3);
        canvas.drawCircle(750,210,40,paint3);
        canvas.drawRect(250,740,750,750,paint3);

>>>>>>> develop
}
=======
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        if (!started){
            for (int i = 0; i < N; i++){
                x[i] = (float)(Math.random() * getWidth());
                y[i] = (float)(Math.random() * getHeight());
                vx[i] = (float)(Math.random() * 6 - 3);
                vy[i] = (float)(Math.random() * 6 - 3);
            }
            started = true;
        }
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }
        invalidate();
    }
>>>>>>> develop
}
