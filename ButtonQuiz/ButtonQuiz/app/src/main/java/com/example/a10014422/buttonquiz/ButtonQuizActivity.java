package com.example.a10014422.buttonquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonQuizActivity extends AppCompatActivity {

    Button myRButton;
    Button myBButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_quiz);

        myRButton = (Button)findViewById(R.id.RButton);
        myBButton = (Button)findViewById(R.id.BButton);

        myRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRButton.setTextColor(Color.RED);
            }
        });

    }

    public void BClick(View view){
        myBButton.setTextColor(Color.BLUE);
        myRButton.setText(myBButton.getText());
    }
}
