package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WorkoutStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_started);
        final TextView textView = findViewById(R.id.textView);
        final ArrayList<String> WorkoutType = new ArrayList<>();
        Intent intent = getIntent();
        ArrayList<WorkoutClass> list = (ArrayList<WorkoutClass>) intent.getSerializableExtra("NEW_PART");

        final String workoutType = list.get(1).getType();
        final int aika = list.get(1).getSeconds()*1000;

        CountDownTimer timer = new CountDownTimer(aika, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                textView.setText(workoutType+ " " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                textView.setText("done!");
                finish();
            }
        }.start();

    }
}
