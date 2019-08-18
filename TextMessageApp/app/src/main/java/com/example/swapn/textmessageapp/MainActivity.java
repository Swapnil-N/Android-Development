package com.example.swapn.textmessageapp;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver;
    SmsManager smsManager;
    TextView textView;
    TextView stateTextView;
    String greeting[]; // state1
    String food[]; //state2
    String price[]; // state2
    String ungreeting[]; //state3
    String orderQuestion = "Welcome to Taco Bell. What would u like to order?";
    String afterOrder = "Thank you for ordering from the Bell.";
    String secondOrderError = "I did not understand what you said. Please reply with Yes (and what you want) or No";
    int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.maintext);
        stateTextView = (TextView) findViewById(R.id.stateTextView);
        greeting = new String[]{"Hi", "Hey", "Hello", "Sup"};
        food = new String[]{"burrito", "taco", "quesadilla", "fiesta potatoes", "soda"};
        price = new String[]{"That will be $5","That will be $8","That will be $11","That will be $14"};
        ungreeting = new String[]{"Bye","Have a nice day", "Good bye", "Adios amigo"};


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED ){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS,Manifest.permission.SEND_SMS},1);

        }

        receiver = new broadcastReceiver();
        smsManager = SmsManager.getDefault();

        registerReceiver(receiver,new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    public class broadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");
            final SmsMessage[] smsMessage = new SmsMessage[pdus.length];
            for (int i=0;i<pdus.length;i++){
                smsMessage[i] = SmsMessage.createFromPdu((byte[]) pdus[i], bundle.getString("format"));
            }

            final String originatingAddress = smsMessage[0].getOriginatingAddress();
            final String messageBody = smsMessage[0].getMessageBody();

            textView.setText(state+"");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (messageBody.equals("reset"))
                        state = 0;

                    if (state == 0 && isInIt(messageBody, greeting)) {
                        smsManager.sendTextMessage(originatingAddress, null, greeting[rando()], null, null);
                        smsManager.sendTextMessage(originatingAddress, null, orderQuestion, null, null);
                        stateTextView.setText("Greeting State");
                        state++;
                    }
                    else if (state == 1 && isInIt(messageBody,food)){
                        smsManager.sendTextMessage(originatingAddress, null, "Would you like to order anything else?", null, null);
                        stateTextView.setText("First Order State");
                        state++;
                    }

                    else if (state == 2){
                        if ( (messageBody.toUpperCase().contains("YES") && messageBody.length() > 3 && isInIt(messageBody, food)) || messageBody.toUpperCase().contains("NO")){
                            smsManager.sendTextMessage(originatingAddress, null, price[rando()], null, null);
                            smsManager.sendTextMessage(originatingAddress, null, afterOrder, null, null);
                            state++;
                        }

                        else{
                            smsManager.sendTextMessage(originatingAddress, null,secondOrderError, null, null);
                        }
                        stateTextView.setText("Second Order State");
                    }

                    else if (state == 3 && isInIt(messageBody, ungreeting)){
                        smsManager.sendTextMessage(originatingAddress, null, ungreeting[rando()],null,null);
                        stateTextView.setText("ungreeting State");
                        state++;
                    }

                    else{
                        smsManager.sendTextMessage(originatingAddress,null, "Sorry I did not understand you",null, null);
                        //state--
                    }

                }
            },3000);

        }
    }

    public boolean isInIt(String a, String[] b) {
        for (String item : b){
            if (a.toUpperCase().contains(item.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public int rando(){
        return (int) (Math.random()*4);
    }

}