package com.example.sweetgirl.customizeview.tree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by sweetgirl on 2017/9/21
 */

public class TreeView extends View{
    Paint paint;
    public TreeView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
        paint.setTextSize(40);//设置字体大小
    }

    protected void onDraw(Canvas canvas) {


        //大营 交叉线
        //drawline（起始点轴坐标，起始点y轴坐标，终点轴坐标，终点y轴坐标）
        canvas.drawLine(242, 30, 136,170, paint);
        canvas.drawLine(242, 30, 347,170, paint);

        canvas.drawCircle(242, 30,20, paint);

        //drawcircle（圆心x轴坐标，圆心y轴坐标，半径，画布）
        canvas.drawCircle(136, 170,20, paint);
        canvas.drawCircle(347, 170,20, paint);

        canvas.drawLine(136, 170, 30,450, paint);
        canvas.drawLine(136, 170, 189,450, paint);
        canvas.drawLine(347, 170, 294,450, paint);
        canvas.drawLine(347, 170, 450,450, paint);

        //bottomcircle
        canvas.drawCircle(450, 450,20, paint);
        canvas.drawCircle(294, 450,20, paint);
        canvas.drawCircle(189, 450,20, paint);
        canvas.drawCircle(30, 450,20, paint);




        paint.setColor(Color.RED);

    }

}
