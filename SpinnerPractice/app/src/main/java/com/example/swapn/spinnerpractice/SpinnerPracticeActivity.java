package com.example.swapn.spinnerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerPracticeActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    TextView myText;
    EditText editText;
    Button myButton;
    ArrayList<String> list;
    ArrayList<String> list2;
    String currentChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_practice);

        spinner = (Spinner) findViewById(R.id.ID_spinner);
        spinner2 = (Spinner) findViewById(R.id.ID_spinner2);
        myText = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.ID_editText);
        myButton = (Button) findViewById(R.id.ID_button);

        list = new ArrayList<>();
        list2 = new ArrayList<>();

        list.add("Mr ");
        list.add("Mrs ");

        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(spinerAdapter);

        ArrayAdapter<String> spinerAdapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list2);
        spinner2.setAdapter(spinerAdapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                currentChoice = list.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Onclick (View view){
        myText.setText(currentChoice + editText.getText() + "");
        list2.add(currentChoice + editText.getText() + "");
    }
}

//setNotifyData Change