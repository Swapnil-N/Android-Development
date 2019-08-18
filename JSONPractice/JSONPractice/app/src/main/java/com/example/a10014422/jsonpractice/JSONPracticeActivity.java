package com.example.a10014422.jsonpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class JSONPracticeActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonpractice);

        textView = (TextView) findViewById(R.id.id_text);

        JSONObject VideoGame = new JSONObject();

        try {
            VideoGame.put("Ram", 10);
            VideoGame.put("Color", "red");
            VideoGame.put("asdf", "hi");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("VideoGame", VideoGame.toString());

        JSONObject Systems = new JSONObject();

        try {
            Systems.put("Option 1", "PS4");
            Systems.put("Option 2", "XB1");
            Systems.put("Option 3", "Wii U");
            VideoGame.put("Consoles", Systems);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("VideoGame", VideoGame.toString());

        JSONArray Space  = new JSONArray();
        Space.put("250 GB");
        Space.put("500 GB");
        Space.put("1 TB");

        try {
            VideoGame.put("Storage",Space);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("VideoGame", VideoGame.toString());

        try {
            textView.setText(VideoGame.getString("Storage"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
