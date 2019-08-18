package com.example.a10014422.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = (EditText) findViewById(R.id.editText);
        closeButton = (Button) findViewById(R.id.button2);

        Toast.makeText(this, getIntent().getStringExtra("TEST"),Toast.LENGTH_LONG).show();

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra(MainActivity.INTENT_CODE, editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
