package com.example.sweetgirl.customizeview.timeline;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sweetgirl.customizeview.R;
import com.example.sweetgirl.customizeview.timeline.ResourceUtil;

/**
 * Created by sweetgirl on 2017/9/13
 */

public class TimeLineMakerView extends View{

    private int mMarkerSize = 24; //圆点的大小
    private int mLineSize = 2;   //线段粗细
    private Drawable mBeginLine; //上面线段颜色
    private Drawable mEndLine;   //下面线段颜色
    private Drawable mMarkerDrawable; //圆点颜色
    private boolean orientation;   //竖屏false或横屏true

    public TimeLineMakerView(Context context){
        this(context,null);
    }

    public TimeLineMakerView(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }

    public TimeLineMakerView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context,attrs,defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        final TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.TimeLineMaker);

        mMarkerSize = array.getDimensionPixelSize(R.styleable.TimeLineMaker_makerSize,mMarkerSize);

        mLineSize = array.getDimensionPixelSize(R.styleable.TimeLineMaker_lineSize,mLineSize);

        mBeginLine = array.getDrawable(R.styleable.TimeLineMaker_beginLine);

        mEndLine = array.getDrawable(R.styleable.TimeLineMaker_endLine);

        mMarkerDrawable = array.getDrawable(R.styleable.TimeLineMaker_maker);

        orientation = array.getBoolean(R.styleable.TimeLineMaker_orientation,false);

        array.recycle();

        if (mBeginLine != null)
            mBeginLine.setCallback(this);
        if (mEndLine != null)
            mEndLine.setCallback(this);
        if (mMarkerDrawable != null)
            mMarkerDrawable.setCallback(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        if (orientation){
            if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(120, 80);  //针对wrap情况处理
            }
            else if (widthSpecMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(120, heightSpecSize);
            }
            else if (heightSpecMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(widthSpecSize, 80);
            }
        }
        else {
            if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(80, 120);  //针对wrap 情况处理
            }
            else if (widthSpecMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(80, heightSpecSize);
            }
            else if (heightSpecMode == MeasureSpec.AT_MOST){
                setMeasuredDimension(widthSpecSize, 120);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if (mBeginLine != null){
            mBeginLine.draw(canvas);
        }
        if (mEndLine != null){
            mEndLine.draw(canvas);
        }
        if (mMarkerDrawable != null){
            mMarkerDrawable.draw(canvas);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        initDrawableSize();

    }

    private void initDrawableSize(){
        int pLeft = getPaddingLeft();
        int pRight = getPaddingRight();
        int pTop = getPaddingTop();
        int pBottom = getPaddingBottom();
        int width = getWidth();
        int height = getHeight();
        int cWidth = width-pLeft-pRight;
        int cHeight = height-pTop-pBottom;
        Rect bounds;
        int mMarkerSizePx = ResourceUtil.dip2px(getContext(), mMarkerSize);
        int mLineSizePx = ResourceUtil.dip2px(getContext(), mLineSize);
        //横向
        if (orientation) {
            if (mMarkerDrawable != null) {
                int markSize = Math.min(Math.min(cWidth, cHeight), mMarkerSizePx);
                mMarkerDrawable.setBounds(pLeft + width / 2 - markSize / 2, pTop, pLeft + width / 2 - markSize / 2 + markSize, pTop + markSize);
                bounds = mMarkerDrawable.getBounds();
            } else {
                bounds = new Rect(pLeft + width / 2, pTop, pLeft + width / 2, pTop);
            }
            int halfLine = mLineSizePx >> 1;
            int lineTop = bounds.centerY() - halfLine;
            if (mBeginLine != null) {
                mBeginLine.setBounds(0, lineTop, bounds.left, lineTop + mLineSizePx);
            }
            if (mEndLine != null) {
                mEndLine.setBounds(bounds.right, lineTop, width, lineTop + mLineSizePx);
            }
        }
        //竖屏
        else{
            if (mMarkerDrawable != null){
                int markSize = Math.min(Math.min(cWidth,cHeight), mMarkerSizePx);
                mMarkerDrawable.setBounds(pLeft, pTop + height/2 -markSize/2, pLeft + markSize, pTop + height/2 - markSize/2 + markSize);
                bounds = mMarkerDrawable.getBounds();
            }
            else{
                bounds = new Rect(pLeft + mLineSizePx/2, pTop + height/2, pLeft + mLineSizePx/2, pTop + height/2);
            }
            int halfLine = mLineSizePx >> 1;
            int lineLeft = bounds.centerX() - halfLine;
            if (mBeginLine != null){
                mBeginLine.setBounds(lineLeft, 0, lineLeft + mLineSizePx, bounds.top);
            }
            if (mEndLine != null){
                mEndLine.setBounds(lineLeft, bounds.bottom, lineLeft + mLineSizePx, height);
            }

        }
    }
    public void setLineSize(int lineSize){
        if (this.mLineSize != lineSize){
            mLineSize = lineSize;
            initDrawableSize();
            invalidate();
        }
    }

    public void setMakerSize(int markerSize){
        if (this.mMarkerSize != markerSize){
            markerSize = markerSize;
            initDrawableSize();
            invalidate();
        }
    }

    public void setBeginLine(Drawable beginLine){
        if (this.mBeginLine != beginLine){
            this.mBeginLine = beginLine;
            if (mBeginLine != null){
                mBeginLine.setCallback(this);
            }
            initDrawableSize();
            invalidate();
        }
    }

    public void setEndLine(Drawable endLine) {
        if (this.mEndLine != endLine) {
            this.mEndLine = endLine;
            if (mEndLine != null) {
                mEndLine.setCallback(this);
            }
            initDrawableSize();
            invalidate();
        }
    }

    public void setMarkerDrawable(Drawable markerDrawable) {
        if (this.mMarkerDrawable != markerDrawable) {
            this.mMarkerDrawable = markerDrawable;
            if (mMarkerDrawable != null) {
                mMarkerDrawable.setCallback(this);
            }
            initDrawableSize();
            invalidate();
        }
    }


}
