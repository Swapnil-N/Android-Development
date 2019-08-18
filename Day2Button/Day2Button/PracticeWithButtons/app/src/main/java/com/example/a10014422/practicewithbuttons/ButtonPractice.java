package com.example.a10014422.practicewithbuttons;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonPractice extends AppCompatActivity {

    Button myColorButton;
    Button mySizeButton;
    Button mySwapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_practice);

        myColorButton = (Button)findViewById(R.id.RandCButton);
        mySizeButton = (Button)findViewById(R.id.SizeButton);
        mySwapButton = (Button)findViewById(R.id.SwapButton);

        mySizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySizeButton.setTextSize((int)(Math.random()*50)+5);
            }
        });
    }

    public void ColorClicked (View view){
        int ranNumber = (int)(Math.random()*6);

        if (ranNumber == 0)
            myColorButton.setTextColor(Color.RED);
        if (ranNumber == 1)
            myColorButton.setTextColor(Color.BLUE);
        if (ranNumber == 2)
            myColorButton.setTextColor(Color.GREEN);
        if (ranNumber == 3)
            myColorButton.setTextColor(Color.YELLOW);
        if (ranNumber == 4)
            myColorButton.setTextColor(Color.CYAN);
        if (ranNumber == 5)
            myColorButton.setTextColor(Color.MAGENTA);
    }

    public void SwapCLicked (View view){
        if (myColorButton.getText().equals("Rand Color")) {
            myColorButton.setText("Rand Size");
            mySizeButton.setText("Rand Color");
        }
        else{
            myColorButton.setText("Rand Color");
            mySizeButton.setText("Rand Size");
        }
    }

}
