package com.example.a10014422.linearlayoutpractice2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LinearLayoutPractice2Activity extends AppCompatActivity {

    Button myRed;
    Button myBlue;
    Button myGreen;
    Button myCyan;
    Button myGray;
    Button myMagenta;
    LinearLayout myLL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_practice2);

        myRed = (Button)(findViewById(R.id.Red));
        myBlue = (Button)(findViewById(R.id.Blue));
        myGreen = (Button)(findViewById(R.id.Green));

        myCyan = (Button)(findViewById(R.id.Cyan));
        myGray = (Button)(findViewById(R.id.Gray));
        myMagenta = (Button)(findViewById(R.id.Magenta));

        myLL = (LinearLayout)(findViewById(R.id.LL));

    }

    public void OnClickC(View view){
        myLL.setBackgroundColor(Color.CYAN);
    }
    public void OnClickGY(View view){
        myLL.setBackgroundColor(Color.GRAY);
    }
    public void OnClickM(View view){
        myLL.setBackgroundColor(Color.MAGENTA);
    }
    public void OnClickR(View view){
        myCyan.setTextColor(Color.RED);
        myGray.setTextColor(Color.RED);
        myMagenta.setTextColor(Color.RED);
    }
    public void OnClickB(View view){
        myCyan.setTextColor(Color.BLUE);
        myGray.setTextColor(Color.BLUE);
        myMagenta.setTextColor(Color.BLUE);
    }
    public void OnClickG(View view){
        myCyan.setTextColor(Color.GREEN);
        myGray.setTextColor(Color.GREEN);
        myMagenta.setTextColor(Color.GREEN);
    }



}
