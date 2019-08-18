package com.example.swapn.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerDemoActivity extends AppCompatActivity {


    Spinner spinner;
    TextView leftText;
    TextView rightText;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        spinner = (Spinner) findViewById(R.id.id_spinner);
        leftText = (TextView) findViewById(R.id.LText);
        rightText = (TextView) findViewById(R.id.RText);

        list = new ArrayList<>();

        list.add("Mike");
        list.add("Bob");
        list.add("Joe");
        list.add("Steve");

        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(spinerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
//                leftText.setText(list.get(pos));
                leftText.setText(parent.getItemAtPosition(pos)+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                rightText.setText("");
            }//fill in at the end of the block
        });
    }
}
