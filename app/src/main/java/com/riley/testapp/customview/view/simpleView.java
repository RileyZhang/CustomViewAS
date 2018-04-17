package com.riley.testapp.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangqiang on 2018-04-11.
 */
public class simpleView extends View{
    Paint mPaint;
    TextPaint mTextPaint;
    String mText;

    public simpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public simpleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public simpleView(Context context) {
        super(context);
    }

    private void init() {
        mPaint = new Paint();
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(20);
        canvas.drawCircle(200, 200, 100, mPaint);
        super.onDraw(canvas);


        mPaint.reset();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(200, 200, mPaint);

        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(200, 250, mPaint);

        mPaint.reset();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
//        Path dashPath = ;
//        PathEffect pathEffect = new PathDashPathEffect(dashPath, 40, 0, PathDashPathEffect.Style.TRANSLATE);
//        mPaint.setPathEffect(pathEffect);
        canvas.drawRoundRect(400, 100, 700, 300, 50, 50, mPaint);

        mPaint.reset();
        mPaint.setColor(Color.RED);
        canvas.drawOval(200, 400, 600, 700, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(200, 400, 600, 700, -60, 120, true, mPaint);
        canvas.drawArc(200, 400, 600, 700, -120, -80, false, mPaint);

        mPaint.setTextSize(50);
        mPaint.setShadowLayer(5, 0, 0, Color.RED);
        canvas.drawText("hello riley, life is good", 200, 750, mPaint);

        mTextPaint.setTextSize(50);
        StaticLayout staticLayout = new StaticLayout(mText, mTextPaint, 750, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        canvas.save();
        canvas.translate(50, 780);
        staticLayout.draw(canvas);
//        canvas.translate(0, 200);
//        staticLayout.draw(canvas);
        canvas.restore();
    }
}
