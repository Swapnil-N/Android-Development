package com.example.a10014422.rpsradiopractice;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RPSRadioPracticeActivity extends AppCompatActivity {

    TextView myVText;
    RadioGroup myRG1;

    RadioGroup myRG2;
    ImageView myPic;

    Button myButton;
    TextView myBText;
    int cpu;

    int playerchoice = 0;
    int cScore = 0;
    int pScore = 0;

    TextView myScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpsradio_practice);

        myButton = (Button) findViewById(R.id.PlayButton);
        myBText = (TextView) findViewById(R.id.BtextView);

        myVText = (TextView) findViewById(R.id.VTextView);
        myRG1 = (RadioGroup) findViewById(R.id.radioGroup1);
        myRG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.radioButton)
                    Toast.makeText(RPSRadioPracticeActivity.this, "WARNING May Damage Hearing", Toast.LENGTH_LONG).show();
            }
        });

        myPic = (ImageView)findViewById(R.id.imageView);

        myRG2 = (RadioGroup)findViewById(R.id.radioGroup2);
        myRG2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.RockB) {
                    playerchoice = 1;
                }
                if (i == R.id.PaperB) {
                    playerchoice = 2;
                }
                if (i == R.id.ScissorB) {
                    playerchoice = 3;
                }
            }
        });

        myScore = (TextView) findViewById(R.id.ScoreText);

    }

    public void OnClick(View view){

        cpu = (int) (Math.random()*3)+1;
        if (cpu == 1)
            myPic.setImageResource(R.drawable.rock);
        else if (cpu == 2)
            myPic.setImageResource(R.drawable.paper);
        else
            myPic.setImageResource(R.drawable.scissor);

        if (playerchoice == cpu)
            myBText.setText("Tie");
        else if (playerchoice == 1) {
            if (cpu == 2)
                myBText.setText("CPU Wins!");
            else
                myBText.setText("Player Wins!");
        }
        else if (playerchoice == 2){
            if (cpu == 3)
                myBText.setText("CPU Wins!");
            else
                myBText.setText("Player Wins!");
        }
        else {
            if (cpu == 1)
                myBText.setText("CPU Wins!");
            else
                myBText.setText("Player Wins!");
        }

        if (myBText.getText().equals("CPU Wins!"))
            cScore++;
        if (myBText.getText().equals("Player Wins!"))
            pScore++;

        myScore.setText("Player: "+pScore+" CPU: "+cScore);

    }
}