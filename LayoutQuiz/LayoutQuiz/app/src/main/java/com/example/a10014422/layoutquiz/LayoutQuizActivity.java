package com.example.a10014422.layoutquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LayoutQuizActivity extends AppCompatActivity implements View.OnClickListener {

    Button myButton1;
    Button myButton2;

    TextView myTextView1;
    TextView myTextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_quiz);

        myButton1 = (Button)(findViewById(R.id.button1));
        myButton2 = (Button)(findViewById(R.id.button2));

        myButton2.setOnClickListener(this);

        myTextView1 = (TextView)(findViewById(R.id.textView1));
        myTextView2 = (TextView)(findViewById(R.id.textView2));

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myTextView1.getText().equals("Clicked"))
                    myTextView1.setText("Not Clicked");
                else
                    myTextView1.setText("Clicked");
            }
        });

        for (int i=0;i<10;i++){
            Log.d("Swapnil","Message"+i);
        }

    }

    public void onClick(View view){
        if (myTextView2.getText().equals("Clicked"))
            myTextView2.setText("Not Clicked");
        else
            myTextView2.setText("Clicked");
    }

}
