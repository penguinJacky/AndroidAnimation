package com.example.testanimation.presenter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.testanimation.bean.MyPoint;
import com.example.testanimation.model.MyPointEvaluator;

public class MyPointView extends View {

    private Paint myPaint;
    private MyPoint currentPoint;
    public static final float RADIUS = 70f;

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint == null) {
            currentPoint = new MyPoint(RADIUS, RADIUS);
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, myPaint);

            MyPoint startPoint = new MyPoint(RADIUS, RADIUS);
            MyPoint endPoint = new MyPoint(700, 1000);

            ValueAnimator animator = ValueAnimator.ofObject(new MyPointEvaluator(), startPoint,
                    endPoint);
            animator.setDuration(5000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    currentPoint = (MyPoint) animation.getAnimatedValue();
                    invalidate();

                }
            });
            animator.start();
        } else {
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, myPaint);
        }
    }
}
