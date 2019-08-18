package com.example.swapn.orientationdemo;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrientationDemoActivity extends AppCompatActivity {

    TextView landText;
    TextView portText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_demo);

        landText = (TextView) findViewById(R.id.id_landText);
        portText = (TextView) findViewById(R.id.id_portText);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            portText.setText("PORT MODE ENGAGED");

        if (landText != null)
            landText.setText("LAND MODE ENGAGED");


    }
}
