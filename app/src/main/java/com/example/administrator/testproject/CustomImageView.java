package com.example.administrator.testproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomImageView extends View {
    private Bitmap mBitmap;
    private Paint mPaint;
    private RectF mRectF;

    public CustomImageView(Context context) {
        super(context);
        init(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (this.getWidth() > 0 && this.getHeight() > 0 && mRectF == null) {
            int height = this.getWidth() * mBitmap.getHeight() / mBitmap.getWidth();
            mRectF = new RectF(0, (this.getHeight() - height) / 2, 540, (this.getHeight() + height) / 2);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mRectF != null && mBitmap != null && mPaint != null)
            canvas.drawBitmap(mBitmap, null, mRectF, mPaint);
    }
}
