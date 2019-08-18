package com.example.a10014422.widgetquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class WidgetQuizActivity extends AppCompatActivity {

    EditText myText1;
    EditText myText2;

    TextView myTextView;
    Button myButton;

    Switch mySwitch;
    ArrayList<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_quiz);

        myText1 = (EditText) findViewById(R.id.editText1);
        myText2 = (EditText) findViewById(R.id.editText2);


        myTextView = (TextView) findViewById(R.id.textView);
        myButton = (Button) findViewById(R.id.button);

        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setTextOn("Match");
        mySwitch.setTextOff("Not Match");
        mySwitch.setTextColor(Color.BLACK);
        mySwitch.setEnabled(false);

        list.add("123");
        list.add("test");
        list.add("password");
        list.add("abc");

        myText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                for (String item: list){
                    if (item.equals(charSequence+"")){
                        myTextView.setText("Password already used");
                    }
                    else
                        myTextView.setText("Password not used");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        for (int i=0;i<list.size();i++){
            if (myText1.getText().toString().equals(list.get(i)))
                myTextView.setText("Password already used");
            else
                myTextView.setText("Password not used");

        }

    }

    public void Onclick(View view){



        if (myText1.getText().toString().equals(myText2.getText().toString())) {
            mySwitch.setChecked(true);
        }

        else{
            mySwitch.setChecked(false);
        }


    }
}
