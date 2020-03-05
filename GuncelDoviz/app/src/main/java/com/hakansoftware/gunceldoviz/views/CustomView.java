package com.hakansoftware.gunceldoviz.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.hakansoftware.gunceldoviz.R;

import static java.lang.Math.PI;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CustomView extends View {

    private Region mClipRegion;

    private Paint mArrowPaint;
    private Path mArrowPath;
    private Region mArrowRegion;

    private TextPaint mTextPaint;
    private Rect mBounds;
    private Region mTextRegion;

    private int mWidth;
    private int mHeight;

    private int mRotation;

    public boolean isLine = false;

    public CustomView(Context context) {
        this(context, null, 0);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mArrowPaint = new Paint();
        mArrowPaint.setColor(Color.RED);
        mArrowPaint.setStyle(Paint.Style.FILL);
        mArrowPaint.setAntiAlias(true);

        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mArrowPath = new Path();
        mBounds = new Rect();

        mClipRegion = new Region();
        mArrowRegion = new Region();
        mTextRegion = new Region();
    }

    public void setArrowRotation(int rotation) {
        mRotation = rotation;
    }

    public void swapColor(int color) {
        mArrowPaint.setColor(color);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w;
        mHeight = h;
        mClipRegion.set(0, 0, w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isLine == false) {
            canvas.save();
            canvas.rotate(mRotation, mWidth / 2, mHeight / 2);

            // Draw an arrow
            mArrowPath.rewind();
            mArrowPath.moveTo(0, mHeight / 2);
            mArrowPath.lineTo(mWidth / 2, 0);
            mArrowPath.lineTo(mWidth, mHeight / 2);
            mArrowPath.lineTo(mWidth * 3 / 4, mHeight / 2);
            mArrowPath.lineTo(mWidth * 3 / 4, mHeight);
            mArrowPath.lineTo(mWidth / 4, mHeight);
            mArrowPath.lineTo(mWidth / 4, mHeight / 2);
            mArrowPath.lineTo(0, mHeight / 2);

            canvas.drawPath(mArrowPath, mArrowPaint);

            canvas.restore();
        }
        else
        {
            Paint paint = new Paint();
            paint.setColor(Color.rgb(255, 165, 0));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(20);
            paint.setAntiAlias(true);
            canvas.drawLine(0, mHeight / 2, mWidth,mHeight / 2, paint);

            postInvalidate();
        }
    }
}
