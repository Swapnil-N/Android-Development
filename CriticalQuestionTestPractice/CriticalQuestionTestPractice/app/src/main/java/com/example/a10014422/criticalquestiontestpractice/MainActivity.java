package com.example.a10014422.criticalquestiontestpractice;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView1;
    TextView textView2;
    ImageView imageView1;
    ImageView imageView2;

    Spinner spinner;
    ArrayList<String> list;

    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        list = new ArrayList<>();

        list.add("Mike");
        list.add("Bob");
        list.add("Joe");
        list.add("Steve");

        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(spinerAdapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView1.setText(list.get(i));
            }
        });

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
