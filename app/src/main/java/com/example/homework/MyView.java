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

}
}
