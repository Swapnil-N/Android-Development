package com.example.a10014422.calculator;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    Button my0;
    Button my1;
    Button my2;
    Button my3;
    Button my4;
    Button my5;
    Button my6;
    Button my7;
    Button my8;
    Button my9;
    Button myAdd;
    Button myMinus;
    Button myMultiply;
    Button myDivide;
    Button myEqual;
    Button myClear;

    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        my0 = (Button)(findViewById(R.id.zero));
        my1 = (Button)(findViewById(R.id.one));
        my2 = (Button)(findViewById(R.id.two));
        my3 = (Button)(findViewById(R.id.three));
        my4 = (Button)(findViewById(R.id.four));
        my5 = (Button)(findViewById(R.id.five));
        my6 = (Button)(findViewById(R.id.six));
        my7 = (Button)(findViewById(R.id.seven));
        my8 = (Button)(findViewById(R.id.eight));
        my9 = (Button)(findViewById(R.id.nine));
        myAdd = (Button)(findViewById(R.id.add));
        myMinus = (Button)(findViewById(R.id.minus));
        myMultiply = (Button)(findViewById(R.id.multiply));
        myDivide = (Button)(findViewById(R.id.divide));
        myEqual = (Button)(findViewById(R.id.equal));
        myClear = (Button)(findViewById(R.id.clear));

        my0.setOnClickListener(this);
        my1.setOnClickListener(this);
        my2.setOnClickListener(this);
        my3.setOnClickListener(this);
        my4.setOnClickListener(this);
        my5.setOnClickListener(this);
        my6.setOnClickListener(this);
        my7.setOnClickListener(this);
        my8.setOnClickListener(this);
        my9.setOnClickListener(this);
        myAdd.setOnClickListener(this);
        myMinus.setOnClickListener(this);
        myMultiply.setOnClickListener(this);
        myDivide.setOnClickListener(this);
        myEqual.setOnClickListener(this);
        myClear.setOnClickListener(this);

        myTextView = (TextView)(findViewById(R.id.MainTextView));

    }

    public void onClick(View view){

        if (view.getId() != R.id.equal && view.getId() != R.id.clear){
            if (myTextView.getText().equals("0"))
                myTextView.setText( ((Button) view).getText() );
            else
                myTextView.setText( (String)myTextView.getText() + ((Button) view).getText() );
        }
        else if (view.getId() == R.id.clear){
            myTextView.setText("0");
        }
        else{
            myTextView.setText(compute((String)myTextView.getText()));
        }


    }


    public String compute1(String input){
        StringBuffer javascript = null;
        ScriptEngine runtime = null;

        try {
            runtime = new ScriptEngineManager().getEngineByName("javascript");
            javascript = new StringBuffer();

            javascript.append("1 + 1");

            double result = (Double) runtime.eval(javascript.toString());

            System.out.println("Result: " + result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return input;
    }



    public String compute(String str){

        if (str.charAt(0) == '+' ||str.charAt(0) == '-' ||str.charAt(0) == '*' ||str.charAt(0) == '/')
            return "error";

        String[] numsS = str.split("[-+*/]");
        int[] nums = new int[numsS.length];

        for (int i=0;i<nums.length;i++) {
            if (numsS[i].equals("")) {
                return "error";
            }
            try {
                nums[i] = Integer.parseInt(numsS[i]);
            }catch(Exception e){
                return "error";
            }
        }


        ArrayList<String> opps = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                opps.add(str.charAt(i) + "");
            }
        }

        if (opps.size() >= nums.length)
            return "error";

        int total = nums[0];
        double rtotal = nums[0];
        boolean wR = false;


        for (int i=0;i<opps.size();i++){
            if (opps.get(i).equals("+")){
                total += nums[i+1];
                rtotal += nums[i+1];

            }
            if (opps.get(i).equals("-")){
                total -= nums[i+1];
                rtotal -= nums[i+1];

            }
            if (opps.get(i).equals("*")){
                total *= nums[i+1];
                rtotal *= nums[i+1];

            }
            if (opps.get(i).equals("/")){
                try {
                    total /= nums[i+1];
                    rtotal /= nums[i+1];
                    wR = true;
                }catch (Exception e){
                    return "error";
                }
            }
        }

        if (wR)
            return rtotal+"";
        else
            return total+"";

    }
}
