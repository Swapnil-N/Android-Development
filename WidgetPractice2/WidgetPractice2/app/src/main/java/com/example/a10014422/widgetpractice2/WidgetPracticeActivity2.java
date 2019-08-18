package com.example.a10014422.widgetpractice2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class WidgetPracticeActivity2 extends AppCompatActivity {

    Switch mySwitch1;
    Switch mySwitch2;
    Switch mySwitch3;
    TextView myText1;

    EditText myEText1;
    Button myButton1;
    TextView myText2;

    EditText myEText2;
    Button myButton2;
    TextView myText3;

    TextView myText4;
    SeekBar myBar;

    boolean top;
    boolean middle;
    boolean bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_practice2);

        myText1 = (TextView) findViewById(R.id.textView);
        mySwitch1 = (Switch) findViewById(R.id.switch1);
        mySwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    top = true;
                else
                    top = false;

                if (top && middle && bottom)
                    myText1.setTextColor(Color.BLUE);
                if (top && bottom && !middle)
                    myText1.setTextColor(Color.RED);
                if (!top && !middle && bottom)
                    myText1.setTextColor(Color.GREEN);
            }
        });
        mySwitch2 = (Switch) findViewById(R.id.switch2);
        mySwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    middle = true;
                else
                    middle = false;

                if (top && middle && bottom)
                    myText1.setTextColor(Color.BLUE);
                if (top && bottom && !middle)
                    myText1.setTextColor(Color.RED);
                if (!top && !middle && bottom)
                    myText1.setTextColor(Color.GREEN);
            }
        });
        mySwitch3 = (Switch) findViewById(R.id.switch3);
        mySwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    bottom = true;
                else
                    bottom = false;

                if (top && middle && bottom)
                    myText1.setTextColor(Color.BLUE);
                if (top && bottom && !middle)
                    myText1.setTextColor(Color.RED);
                if (!top && !middle && bottom)
                    myText1.setTextColor(Color.GREEN);
            }
        });




        myEText1 = (EditText) findViewById(R.id.editText1);
        myText2 = (TextView) findViewById(R.id.textView2);
        myButton1 = (Button) findViewById(R.id.button1);
        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = myEText1.getText()+"";
                if (str.indexOf("@") > 0 && str.substring(str.length()-4).equals(".com"))
                    myText2.setText("Verified");
                else
                    myText2.setText("Not Verified");
            }
        });

        myEText2 = (EditText) findViewById(R.id.editText2);
        myButton2 = (Button) findViewById(R.id.button2);
        myText3 = (TextView) findViewById(R.id.textView3);

        myText4 = (TextView) findViewById(R.id.textView4);
        myBar = (SeekBar) findViewById(R.id.seekBar);
        myBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myText4.setTextSize(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

/*
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
*/
