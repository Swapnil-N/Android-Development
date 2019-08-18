package com.example.a10014422.guessinggamequiz;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GuessingGameQuizActivity extends AppCompatActivity {

    RadioGroup myRG;
    Button myButton;
    ImageView myPic;
    TextView myT1;
    TextView myT2;
    int total;
    int you = 0;
    int cpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game_quiz);

        myRG = (RadioGroup) findViewById(R.id.radioGroup);
        myRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radioButton) {
                    you = 2;
                    myPic.setImageResource(R.drawable.cpuimage);
                    myT1.setText("Total");
                    myT2.setText("Result");
                }

                if (i == R.id.radioButton2) {
                    you = 1;
                    myPic.setImageResource(R.drawable.cpuimage);
                    myT1.setText("Total");
                    myT2.setText("Result");
                }
            }
        });
        myButton = (Button) findViewById(R.id.button);
        myPic = (ImageView) findViewById(R.id.imageView);
        myT1 = (TextView) findViewById(R.id.textView1);
        myT2 = (TextView) findViewById(R.id.textView2);
    }

    public void Onclick(View view){
        cpu = (int)(Math.random()*2)+1;

        total = cpu+you;
        if (you == 0) {
            Toast.makeText(GuessingGameQuizActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            return;
        }
        myT1.setText("Total is "+ total);
        if (cpu == 1)
            myPic.setImageResource(R.drawable.newnumber1);
        if (cpu == 2)
            myPic.setImageResource(R.drawable.number2);




        if (total == 2 || total == 4)
            myT2.setText("You Win!");
        else if (total == 3)
            myT2.setText("CPU Wins!");
        else
            Toast.makeText(GuessingGameQuizActivity.this,"ERROR", Toast.LENGTH_SHORT).show();
    }
}
