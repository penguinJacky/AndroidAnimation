package com.example.testanimation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.testanimation.R;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private Button pointButton;
    private Button alphaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.my_btn);
        pointButton = (Button) findViewById(R.id.point_btn);
        alphaButton = (Button) findViewById(R.id.alpha_btn);

        ValueAnimator valueAnimator = ValueAnimator.ofInt(myButton.getLayoutParams().width, 500);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(animation -> {
            int currentVal = (Integer) animation.getAnimatedValue();
            Log.i("MainActivity", "当前AnimatedValue->" + currentVal);
            myButton.getLayoutParams().width = currentVal;
            myButton.requestLayout();
        });
        valueAnimator.start();

        pointButton.setOnClickListener(mPointListener);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(alphaButton, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    private View.OnClickListener mPointListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, PointActivity.class);
            startActivity(intent);
        }
    };
}