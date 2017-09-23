package com.example.sweetgirl.customizeview.start;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sweetgirl on 2017/9/14
 */

public class ShapeImageView extends View{
    private Context context;

    public ShapeImageView(Context context){
        super(context);
    }

    public ShapeImageView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public ShapeImageView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public ShapeImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int width = getWidth();
        int r = width / 8;
        canvas.translate(r, r);

        Path path = new Path();
        path.moveTo(0, -r);  //A
        path.lineTo(r * sin(36),r * cos(36)); //C
        path.lineTo(-r * sin(72),-r * cos(72)); //E
        path.lineTo(r * sin(72),-r * cos(72)); //B
        path.lineTo(-r * sin(36),r * cos(36)); //D

        path.close();

        Paint paint = new Paint();

        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawPath(path,paint);

        addCoordinateAndMark(canvas);

        ff2(canvas);

    }

    private void addCoordinateAndMark(Canvas canvas){
        int width = getWidth();
        int r = width / 8;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        canvas.drawLine(-r, 0 , r , 0, paint);
        canvas.drawLine(0, -r, 0, r, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(30);

        r = (int) (r * 0.9);
        canvas.drawText("A",0, -r, paint);
        canvas.drawText("B", r * sin(72), -r * cos(72), paint);
        canvas.drawText("C", r * sin(36), r * cos(36), paint);
        canvas.drawText("D", -r * sin(36), r * cos(36), paint);
        canvas.drawText("E", -r * sin(72), -r * cos(72), paint);


    }

    private void ff2(Canvas canvas){
        canvas.rotate(-18);

        float r = getWidth() / 8;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        Path path = new Path();
        path.moveTo(r * cos(72*0),r * sin(72*0));
        for (int i = 1; i<5 ; i++){
            canvas.drawText(""+i, r * cos(72*i), r * sin(72*i), paint);
            path.lineTo( r * cos(72*i), r * sin(72*i));
        }

        path.close();

        canvas.drawPath(path, paint);

        r = r * sin(18) / sin(180-36-18);
        paint.setColor(Color.WHITE);
        path = new Path();
        path.moveTo(r * cos(72*0+36),r * sin(72*0+36));
        for (int i =1; i<5 ; i++){
            canvas.drawText(""+ i, r* cos(72*i+36), r* sin(72*i+36),paint);
            path.lineTo(r * cos(72*i+36),r * sin(72*i+36));
        }
        path.close();
        canvas.drawPath(path,paint);


    }

    float sin(int num){
        return  (float)Math.sin(num*Math.PI/180);
    }
    float cos(int num){
        return  (float)Math.cos(num * Math.PI/180);
    }
}
