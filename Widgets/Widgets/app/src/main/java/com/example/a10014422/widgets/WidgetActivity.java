package com.example.a10014422.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class WidgetActivity extends AppCompatActivity {

    SeekBar mySeekBar;
    TextView mySeekText;

    Switch mySwitch;
    TextView mySwitchText;

    EditText myEditText;
    TextView myPlainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        mySeekBar = (SeekBar) findViewById(R.id.seekBar);
        mySwitch = (Switch) findViewById(R.id.switchBar);
        myEditText = (EditText) findViewById(R.id.editText);

        mySeekText = (TextView) findViewById(R.id.text_seek);
        mySwitchText = (TextView) findViewById(R.id.text_switch);
        myPlainText = (TextView) findViewById(R.id.text_plain);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mySeekText.setText(seekBar.getProgress()+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    mySwitchText.setText("ON");
                else
                    mySwitchText.setText("OFF");
            }
        });

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                myPlainText.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
