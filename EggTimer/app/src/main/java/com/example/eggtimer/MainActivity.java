package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            EditText textEditor = findViewById(R.id.editText);

            String aika = textEditor.getText().toString();

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("AIKA", aika);

            startActivity(intent);

        }
    }
}
