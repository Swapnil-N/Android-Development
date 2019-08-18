package com.example.a10014422.radiogroupimagetoastexample;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioGroupImageToastActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group_image_toast);

        radioGroup = (RadioGroup)findViewById(R.id.id_radiogroup);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView1);

        imageView.setImageResource(R.drawable.basketball);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.id_buttonA)
                    textView.setText("A selected");
                if (i == R.id.id_buttonB)
                    textView.setText("B selected");
                if (i == R.id.id_buttonC) {
                    textView.setText("C selected");
                    Toast myMessage = Toast.makeText(RadioGroupImageToastActivity.this,"C is the best",Toast.LENGTH_LONG);
                    myMessage.show();
                }
            }
        });
    }
}
