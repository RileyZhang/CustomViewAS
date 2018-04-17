package com.riley.testapp.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.riley.testapp.customview.R;

/**
 * Created by zhangqiang on 2018-04-12.
 */
public class PaintView extends View{

    private Paint mPaint;
    private Bitmap mBitmap;

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.kobe, options);
        Log.i("test", "1111options.outHeight = " + options.outHeight + " options.outWidth = "+ options.outWidth);
        options.inJustDecodeBounds = false;
        options.inSampleSize = options.outHeight/200;
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.kobe, options);
        Log.i("test", "222options.outHeight = " + options.outHeight + " options.outWidth = "+ options.outWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Shader linearShader = new LinearGradient(50, 50, 350, 350, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(linearShader);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(200, 200, 150, mPaint);

        Shader radiaShader = new RadialGradient(550, 200, 150, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(radiaShader);
        canvas.drawCircle(550, 200, 150, mPaint);

        Shader sweepShader = new SweepGradient(200, 550, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        mPaint.setShader(sweepShader);
        canvas.drawCircle(200, 550, 150, mPaint);

        Shader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
        canvas.drawCircle(125, 125, 125, mPaint);

//        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mBitmap, 400, 400, mPaint);


    }
}
