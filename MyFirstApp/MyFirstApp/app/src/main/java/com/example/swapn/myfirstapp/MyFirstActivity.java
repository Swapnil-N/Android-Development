package com.example.swapn.myfirstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyFirstActivity extends AppCompatActivity /*implements View.OnClickListener */{

    Button myButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first);

        myButton1 = (Button)findViewById(R.id.Button1);
//        myButton1.setOnClickListener(this);   **This is for the implemets way***


        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myButton1.setBackgroundColor(Color.BLUE);
            }
        });
    }

 /*   public void AClicked(View view){    **Set Onclick in XML file**
        myButton1.setTextColor(Color.RED);
    }*/

 /*   public void onClick(View view) {  **This is for the implements way**
        myButton1.setText("Worked");
    } */
}
