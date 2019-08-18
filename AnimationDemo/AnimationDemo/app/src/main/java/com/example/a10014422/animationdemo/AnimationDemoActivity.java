package com.example.a10014422.animationdemo;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class AnimationDemoActivity extends AppCompatActivity {

    TextView textView;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);

        textView = (TextView)findViewById(R.id.id_text);
        constraintLayout = (ConstraintLayout) findViewById(R.id.layoutid);

        final ScaleAnimation scale = new ScaleAnimation(0.5f,1.5f,0.5f,1.5f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scale.setDuration(200);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(scale);
            }
        });

        TextView textViewInCode;
        textViewInCode = new TextView(this);
        textViewInCode.setId(View.generateViewId());
        textViewInCode.setText("Hello Again");

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        textViewInCode.setLayoutParams(params);

        constraintLayout.addView(textViewInCode);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(textViewInCode.getId(),ConstraintSet.TOP,textView.getId(),ConstraintSet.BOTTOM);
        constraintSet.connect(textViewInCode.getId(),ConstraintSet.BOTTOM,constraintLayout.getId(),ConstraintSet.BOTTOM);
        constraintSet.connect(textViewInCode.getId(),ConstraintSet.RIGHT,constraintLayout.getId(),ConstraintSet.RIGHT);
        constraintSet.connect(textViewInCode.getId(),ConstraintSet.LEFT,constraintLayout.getId(),ConstraintSet.LEFT);
        constraintSet.setHorizontalBias(textViewInCode.getId(), 0.5f);
        constraintSet.setVerticalBias(textViewInCode.getId(), 0.5f);

        constraintSet.applyTo(constraintLayout);

    }
}
