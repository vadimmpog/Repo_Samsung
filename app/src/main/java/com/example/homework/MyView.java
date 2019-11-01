package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    Paint paint= new Paint(),paint1= new Paint();
        paint.setColor(Color.BLUE);
    Paint.Style Fill;
        canvas.drawCircle(250,250,250,paint);

}
}
