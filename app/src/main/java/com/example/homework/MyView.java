package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import static java.lang.Math.abs;
import static java.lang.Math.sin;

public class MyView extends View {
    double y=0;
    public MyView(Context context) {
        super(context);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setTextSize(30.0f);
        canvas.drawLine(0,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight()/2,paint);
        canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,canvas.getHeight(),paint);
        canvas.drawText("Y",canvas.getWidth()/2+15,30,paint);
        canvas.drawText("X",canvas.getWidth()-30,canvas.getHeight()/2-15,paint);

        Path path1 = new Path();
        boolean first=true;
        paint.setColor(Color.BLUE);
        for(double x=-2 * Math.PI;x<2 * Math.PI;x+=0.1){
            y=Math.pow(x,2);

            if (first) {
                path1.moveTo( (float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
                first = false;
            } else {
                path1.lineTo((float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
            }
            canvas.drawPath(path1, paint);
        }
        Path path2 = new Path();
        paint.setColor(Color.RED);
        first=true;
        for(double x=-2 * Math.PI;x<2 * Math.PI;x+=0.1){
            y=Math.abs(x);

            if (first) {
                path2.moveTo( (float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
                first = false;
            } else {
                path2.lineTo((float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
            }
            canvas.drawPath(path2, paint);
        }
        Path path3 = new Path();
        paint.setColor(Color.GREEN);
        first=true;
        for(double x=-1.5;x<1.6;x+=0.1){
            y=Math.tan(x);

            if (first) {
                path3.moveTo( (float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
                first = false;
            } else {
                path3.lineTo((float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
            }
            canvas.drawPath(path3, paint);
        }
        Path path4 = new Path();
        first=true;
        paint.setColor(Color.YELLOW);
        for(double x=-2 * Math.PI;x<2 * Math.PI;x+=0.1){
            y=3-Math.pow(x,2);

            if (first) {
                path4.moveTo( (float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
                first = false;
            } else {
                path4.lineTo((float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
            }
            canvas.drawPath(path4, paint);
        }
        Path path5 = new Path();
        first=true;
        paint.setColor(Color.BLACK);
        for(double x=-2 * Math.PI;x<2 * Math.PI;x+=0.1){
            y=sin(x);
            if (first) {
                path5.moveTo( (float)(getWidth()/2+x*100), (float)(getHeight()/2-y*100));
                first = false;
            } else {
                path5.lineTo((float)(getWidth()/2+x*100), (float)(getHeight()/2-y*300));
            }
            canvas.drawPath(path5, paint);
        }
    }
}
