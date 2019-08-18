package com.example.a10014422.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsondemo);

        JSONObject schoolinfo = new JSONObject();

        try {
            schoolinfo.put("name", "Swapnil");
            schoolinfo.put("grade", 11);
            schoolinfo.put("id",10014422);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("school",schoolinfo.toString());

        JSONObject compsci = new JSONObject();
        try {
            compsci.put("grade","A");
            compsci.put("percent",95);
            schoolinfo.put("Computer Science",compsci);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("school",schoolinfo.toString());


        try {
            JSONObject findCourse = schoolinfo.getJSONObject("Computer Science");
            Log.d("school", findCourse.getString("grade"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray clubs = new JSONArray();
        clubs.put("Computer Science");
        clubs.put("FBLA");

        try {
            schoolinfo.put("clubs",clubs);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("school",schoolinfo.toString());

    }
}
