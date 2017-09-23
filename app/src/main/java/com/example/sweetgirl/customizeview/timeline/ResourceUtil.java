package com.example.sweetgirl.customizeview.timeline;

import android.content.Context;

/**
 * Created by sweetgirl on 2017/9/13
 */

public class ResourceUtil {

    /**
     * dip 转化成 px
     */
    public static int dip2px(Context context, float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }
    /**
     * px 转化成dip
     */
    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
    /**
     * px 转化成sp
     */
    public static int px2sp(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
    /**
     * sp 转化成px
     */
    public static int sp2px(Context context, float spValue){
        final  float scale = context.getResources().getDisplayMetrics().density;
        return (int)(spValue / scale + 0.5f);
    }

}
