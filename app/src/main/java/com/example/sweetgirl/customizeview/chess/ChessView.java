package com.example.sweetgirl.customizeview.chess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by sweetgirl on 2017/9/21
 */

public class ChessView extends View{

    Paint paint;
    public ChessView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
        paint.setTextSize(40);//设置字体大小
    }

    protected void onDraw(Canvas canvas) {
        //横线
        //top
        paint.setColor(Color.BLACK);
        canvas.drawLine(30, 30, 450, 30, paint);
        canvas.drawLine(30, 100, 450, 100, paint);
        canvas.drawLine(30, 170, 450, 170, paint);
        canvas.drawLine(30, 240, 450, 240, paint);
        canvas.drawLine(30, 310, 450, 310, paint);
        // bottom

        canvas.drawText(" 楚   河 ", 65, 355, paint);//使用画笔paint
        canvas.drawText(" 汉  界  ", 320, 355, paint);//使用画笔paint
        canvas.drawLine(30, 380, 450, 380, paint);
        canvas.drawLine(30, 450, 450, 450, paint);
        canvas.drawLine(30, 520, 450, 520, paint);
        canvas.drawLine(30, 590, 450, 590, paint);
        canvas.drawLine(30, 660, 450, 660, paint);
        //竖线

        //left
        canvas.drawLine(30, 30, 30, 660, paint);
        canvas.drawLine(83, 30, 83, 310, paint);
        canvas.drawLine(136, 30, 136, 310, paint);
        canvas.drawLine(189, 30, 189, 310, paint);
        canvas.drawLine(242, 30, 242, 310, paint);
        canvas.drawLine(294, 30, 294, 310, paint);
        canvas.drawLine(347, 30, 347, 310, paint);
        canvas.drawLine(398, 30, 398, 310, paint);

        //right

        canvas.drawLine(83, 380, 83,660, paint);
        canvas.drawLine(136, 380, 136,660, paint);
        canvas.drawLine(189, 380, 189,660, paint);
        canvas.drawLine(242, 380, 242,660, paint);
        canvas.drawLine(294, 380, 294,660, paint);
        canvas.drawLine(347, 380, 347,660, paint);
        canvas.drawLine(398, 380, 398,660, paint);

        canvas.drawLine(450,30 ,450,660, paint);
        //大营
        canvas.drawLine(189, 30, 294,170, paint);
        canvas.drawLine(294, 30, 189,170, paint);
        canvas.drawLine(189,520, 294,660, paint);
        canvas.drawLine(294,520, 189,660, paint);

        //topcircle

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(450, 240,20, paint);
        canvas.drawCircle(346, 240,20, paint);
        canvas.drawCircle(242, 240,20, paint);

        canvas.drawCircle(396, 170,20, paint);
        canvas.drawCircle(450, 30,20, paint);
        canvas.drawCircle(396, 30,20, paint);
        canvas.drawCircle(346, 30,20, paint);
        canvas.drawCircle(294, 30,20, paint);
        canvas.drawCircle(242, 30,20, paint);
        canvas.drawCircle(189, 30,20, paint);
        canvas.drawCircle(135, 30,20, paint);
        canvas.drawCircle(83, 30,20, paint);
        canvas.drawCircle(30, 30,20 , paint);
        canvas.drawCircle(83, 170,20, paint);

        canvas.drawCircle(135, 240,20, paint);
        canvas.drawCircle(30, 240,20, paint);

        //bottomcircle
        canvas.drawCircle(450, 450,20, paint);
        canvas.drawCircle(346, 450,20, paint);
        canvas.drawCircle(242, 450,20, paint);

        canvas.drawCircle(396, 520,20, paint);
        canvas.drawCircle(450, 660,20, paint);
        canvas.drawCircle(396, 660,20, paint);
        canvas.drawCircle(346, 660,20, paint);
        canvas.drawCircle(294, 660,20, paint);
        canvas.drawCircle(242, 660,20, paint);
        canvas.drawCircle(189, 660,20, paint);
        canvas.drawCircle(135, 660,20, paint);
        canvas.drawCircle(83, 660,20, paint);
        canvas.drawCircle(30, 660,20, paint);
        canvas.drawCircle(83, 520,20, paint);

        canvas.drawCircle(135, 450,20, paint);
        canvas.drawCircle(30, 450,20, paint);

        paint.setColor(Color.RED);

        paint.setTextSize(20);

        canvas.drawText("兵", 21,458, paint);
        canvas.drawText("兵", 127,458, paint);
        canvas.drawText("兵", 232,458 , paint);
        canvas.drawText("炮", 388,527, paint);
        canvas.drawText("车", 440,668 , paint);
        canvas.drawText("馬", 388,668 , paint);
        canvas.drawText("象", 335,668 , paint);
        canvas.drawText("仕", 285,668 , paint);
        canvas.drawText("帥", 232,668 , paint);
        canvas.drawText("仕", 180,668 , paint);
        canvas.drawText("象", 127,668 , paint);
        canvas.drawText("馬", 72,668 , paint);
        canvas.drawText("车", 21,668 , paint);
        canvas.drawText("炮", 72, 527, paint);
        canvas.drawText("兵", 335,458 , paint);
        canvas.drawText("兵", 440,458, paint);


        paint.setColor(Color.BLACK);
        canvas.drawText("卒", 21,245, paint);
        canvas.drawText("卒", 127,245, paint);
        canvas.drawText("卒", 232,245 , paint);
        canvas.drawText("炮", 72, 177, paint);
        canvas.drawText("车", 21,35 , paint);
        canvas.drawText("馬", 72,35 , paint);
        canvas.drawText("象", 127,35 , paint);
        canvas.drawText("士", 180,35 , paint);
        canvas.drawText("将", 232,35 , paint);
        canvas.drawText("士", 285,35 , paint);
        canvas.drawText("象", 335,35 , paint);
        canvas.drawText("馬", 388,35 , paint);
        canvas.drawText("车", 440,35 , paint);
        canvas.drawText("炮", 388, 177, paint);
        canvas.drawText("卒", 335,247 , paint);
        canvas.drawText("卒", 440,247, paint);


    }

}
