package com.example.administrator.testproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder mHolder;
    private boolean isDrawing;

    private Canvas mCanvas;
    private Paint mPaint;
    private RectF mRectF;

    private Bitmap mBitmap;

    public CustomSurfaceView(Context context) {
        super(context);
        init(context);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        mHolder = getHolder();
        mHolder.addCallback(this);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);

        mPaint = new Paint();

        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test);

    }

    @Override
    public void run() {

        while (isDrawing) {
            drawing();
        }

    }

    private void drawing() {
        try {
            mCanvas = mHolder.lockCanvas();
            if (mCanvas != null){
                mCanvas.drawBitmap(mBitmap, null, mRectF, mPaint);
//                mCanvas.drawBitmap(mBitmap, 0, 0, mPaint);
            }

        } finally {
            if (mCanvas != null)
                mHolder.unlockCanvasAndPost(mCanvas);

        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;

        int height = this.getWidth() * mBitmap.getHeight() / mBitmap.getWidth();
        mRectF = new RectF(0, (this.getHeight() - height) / 2, 540, (this.getHeight() + height) / 2);
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
    }
}
