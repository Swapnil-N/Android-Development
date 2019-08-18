package com.example.swapn.asyncdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AsyncDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_demo);
        //UI thread
        AsyncThread weatherThread = new AsyncThread();
        weatherThread.execute();

        for (int i=0;i<1000;i++)
            Log.d("TAG", "UI Thread " +i);
    }

    public class AsyncThread extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            //Background Thread - Used to download weather info

            for (int i=0;i<1000;i++)
                Log.d("TAG", "Background Thread " +i);

            return null;
        }
    }
}
