package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final TextView textView = findViewById(R.id.textView);
        final String aika =getIntent().getStringExtra("AIKA");
        int a = Integer.parseInt(aika) *1000;

        CountDownTimer timer = new CountDownTimer(a, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                textView.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                textView.setText("done!");
                finish();
            }
        }.start();
    }
}
