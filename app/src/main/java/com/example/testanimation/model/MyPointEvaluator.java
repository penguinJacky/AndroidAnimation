package com.example.testanimation.model;

import android.animation.TypeEvaluator;

import com.example.testanimation.bean.MyPoint;

public class MyPointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {

        MyPoint startPoint = (MyPoint) startValue;
        MyPoint endPoint = (MyPoint) endValue;

        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());

        MyPoint myPoint = new MyPoint(x, y);

        return myPoint;
    }
}
