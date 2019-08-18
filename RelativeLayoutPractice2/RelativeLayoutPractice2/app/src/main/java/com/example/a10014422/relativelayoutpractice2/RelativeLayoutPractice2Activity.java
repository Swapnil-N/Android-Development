package com.example.a10014422.relativelayoutpractice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RelativeLayoutPractice2Activity extends AppCompatActivity {
    Button myButton1;
    Button myButton2;
    Button myButton3;
    Button myButton4;
    Button myButton5;
    TextView myTextView1;
    TextView myTextView2;
    TextView myTextView3;
    TextView myTextView4;
    TextView myTextView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_practice2);

        myButton1 = (Button)(findViewById(R.id.button1));
        myButton2 = (Button)(findViewById(R.id.button2));
        myButton3 = (Button)(findViewById(R.id.button3));
        myButton4 = (Button)(findViewById(R.id.button4));
        myButton5 = (Button)(findViewById(R.id.button5));

        myTextView1 = (TextView)(findViewById(R.id.textView1));
        myTextView2 = (TextView)(findViewById(R.id.textView2));
        myTextView3 = (TextView)(findViewById(R.id.textView3));
        myTextView4 = (TextView)(findViewById(R.id.textView4));
        myTextView5 = (TextView)(findViewById(R.id.textView5));
    }

    public void OnClick1(View view){
        if (myTextView1.getText().equals("On"))
            myTextView1.setText("Off");
        else
            myTextView1.setText("On");
    }
    public void OnClick2(View view){
        if (myTextView2.getText().equals("On"))
            myTextView2.setText("Off");
        else
            myTextView2.setText("On");
    }
    public void OnClick3(View view){
        if (myTextView3.getText().equals("On"))
            myTextView3.setText("Off");
        else
            myTextView3.setText("On");
    }
    public void OnClick4(View view){
        if (myTextView4.getText().equals("On"))
            myTextView4.setText("Off");
        else
            myTextView4.setText("On");
    }
    public void OnClick5(View view){
        if (myTextView5.getText().equals("On"))
            myTextView5.setText("Off");
        else
            myTextView5.setText("On");
    }

}
