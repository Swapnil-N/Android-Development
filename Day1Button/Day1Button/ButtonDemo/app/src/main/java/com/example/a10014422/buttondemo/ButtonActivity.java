package com.example.a10014422.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity {

    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        myButton = (Button)findViewById(R.id.first_button);
        /*
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myButton.setText("CLICKED");
            }
        });*/
    }
    public void onClickGo (View view){
        //myButton.setText("CLICKED");
        ((Button)view).setText("Clicked");
    }

}
