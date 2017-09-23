package com.example.sweetgirl.customizeview.ball;


import android.graphics.Path;
import android.graphics.PointF;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;

/**
 * Created by sweetgirl on 2017/9/16
 * 模拟球体弹起时减速下落时加速动画插值器
 * 通过绘制若干次减速-加速path路径的构造器
 * 之后利用PathInterpolator将路径转为对应插值器函数
 */

public class MultiDecelerateAccelerateInterpolator {

    private float intervalX;
    private float intervalY;
    private PointF originStart;   //起点
    private PointF originEnd;   //终点

    private float bezierControlRationX;
    private float bezierControlRationY;

    public MultiDecelerateAccelerateInterpolator(){
        this(new PointF(0,0),
                new PointF(1,1),
                0.2f,
                0.55f);
    }

    /**
     * 用于构造PathInterpolator时，起点必须为[0,0]终点必须为[1,1]
     * 用于构造“先减速后加速”效果时，建议ratiox取值[0,0.5];ratioy取值范围[0,1]且ratiox < ratioy,
     * @param start 起点
     * @param end   终点
     * @param ratiox  x比例值
     * @param ratioy  y比例值
     */
    public MultiDecelerateAccelerateInterpolator(PointF start, PointF end, float ratiox, float ratioy){
        originStart = start;
        originEnd = end;
        intervalX = Math.abs(originEnd.x - originStart.x);
        intervalY = Math.abs(originEnd.y - originStart.y);
        bezierControlRationX = ratiox;
        bezierControlRationY = ratioy;
    }

    /**
     * 利用三次贝塞尔构造减速加速函数
     * @param segmentLength 从起点到每一段终点的长度集合
     * @return
     */
    public Path createPath(float[] segmentLength){
        Path path = new Path();
        float ratio;
        PointF start = new PointF();
        PointF con1 = new PointF();
        PointF con2 = new PointF();
        PointF end = new PointF();

        float totalLength = segmentLength[segmentLength.length - 1];

        for (int i =0; i < segmentLength.length; i++){
            ratio = segmentLength[i] / totalLength;
            if (i == 0){
                start.x = originStart.x;
                start.y = originStart.y;
                path.moveTo(originStart.x , originStart.y);
            }

            end.x = intervalX * ratio;
            end.y = intervalY * ratio;
            con1.x = start.x + (end.x - start.x) * bezierControlRationX;
            con1.y = start.y + (end.y - start.y) * bezierControlRationY;
            con2.x = end.x - (end.x - start.x) * (bezierControlRationX);
            con2.y = end.y - (end.x - start.y) * (bezierControlRationY);

            path.cubicTo(con1.x, con1.y,
                    con2.x, con2.y,
                    end.x, end.y);

            start.x = end.x;
            start.y = end.y;
        }
        return path;
    }

    /**
     * 构造PathInterpolator
     * @param segmentLength
     * @return
     */
    public Interpolator createInterpolator(float[] segmentLength){
        Path p = createPath(segmentLength);
        Interpolator inter = PathInterpolatorCompat.create(p);
        return inter;
    }


}
