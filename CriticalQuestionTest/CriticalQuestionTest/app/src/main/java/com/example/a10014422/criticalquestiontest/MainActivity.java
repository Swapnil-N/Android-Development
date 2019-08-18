package com.example.a10014422.criticalquestiontest;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView nameText;
    TextView blockText;
    RadioGroup radioGroup;
    Button runButton;
    Button launchButton;
    ConstraintLayout constraintLayout;

    int choice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (TextView) findViewById(R.id.NameTextView_id);
        blockText = (TextView) findViewById(R.id.blockTextView_id);
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup_id);
        runButton = (Button) findViewById(R.id.runButton_id);
        launchButton = (Button) findViewById(R.id.LaunchAppButton_id);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_id);

        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                if (choice == 1){
                    intent.putExtra("TEST","The Toast Radio Button was selected");
                }
                if (choice == 2){
                    intent.putExtra("TEST","The Change Color Radio Button was selected");
                }
                if (choice == 3){
                    intent.putExtra("TEST","The Uppercase Radio Button was selected");
                }
                else
                    intent.putExtra("Test","Please Select a choice");
                startActivity(intent);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radioButton1)
                    choice = 1;
                if (i == R.id.radioButton2)
                    choice = 2;
                if (i == R.id.radioButton3)
                    choice = 3;
            }
        });

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 1)
                    Toast.makeText(MainActivity.this, "Toast Selected",Toast.LENGTH_SHORT).show();
                if (choice == 2){
                    int rand = (int)(Math.random()*3)+1;

                    if (rand == 1)
                        constraintLayout.setBackgroundColor(Color.RED);
                    else if (rand == 2)
                        constraintLayout.setBackgroundColor(Color.GREEN);
                    else if (rand == 3)
                        constraintLayout.setBackgroundColor(Color.BLUE);
                    else
                        blockText.setText(rand+"");
                }
                if (choice == 3)
                    nameText.setAllCaps(true);

            }
        });

    }
}


