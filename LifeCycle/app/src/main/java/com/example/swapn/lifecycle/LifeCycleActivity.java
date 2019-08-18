package com.example.swapn.lifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LifeCycleActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int counter;

    public static final String COUNTER_KEY = "counter key";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("lifeCycle", "onSaveInstanceState");
        outState.putInt(COUNTER_KEY,counter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeCycle", "onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d("lifeCycle", "onCreate");

        textView = (TextView) findViewById(R.id.id_textview);
        button = (Button) findViewById(R.id.id_button);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_KEY);
            textView.setText("Counter: " + counter);
        }

        if(button!=null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter++;
                    textView.setText("Counter: " + counter);
                }
            });
        }
    }
}
