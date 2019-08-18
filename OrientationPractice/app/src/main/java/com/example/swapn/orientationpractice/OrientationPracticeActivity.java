package com.example.swapn.orientationpractice;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class OrientationPracticeActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textView;
    Button button;
    ArrayList<String> list;
    TextView landText;
    ArrayAdapter<String> spinerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_practice);

        spinner = (Spinner) findViewById(R.id.id_spinner);
        textView = (TextView) findViewById(R.id.id_textView);
        button = (Button) findViewById(R.id.id_button);
        landText = (TextView) findViewById(R.id.id_landText);


        list = new ArrayList<>();

        list.add("Mike");
        list.add("Bob");
        list.add("Joe");
        list.add("Steve");



        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            spinerAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
            spinner.setAdapter(spinerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setText(list.get(i));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    textView.setText("all elements removed");
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.clear();
                    spinerAdapter.notifyDataSetChanged();
                }
            });
        }

        if (landText != null)
            landText.setText("This app only works in portrait mode");


    }
}
