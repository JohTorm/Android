package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkoutStartedActivity extends AppCompatActivity implements  TextToSpeech.OnInitListener{
    int index = 0;


    TextToSpeech tts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_started);




        Intent intent = getIntent();
        ArrayList<WorkoutClass> list = (ArrayList<WorkoutClass>) intent.getSerializableExtra("LIST_TYPE");

        tts = new TextToSpeech(this,this);





        startTimer(list.get(index).getType(), list.get(index).getSeconds() * 1000);



    }

    public void startTimer(final String workout, int aika){
        final TextView textView = findViewById(R.id.textView);

        CountDownTimer timer = new CountDownTimer(aika, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textView.setText(workout+ " " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Done");
                index++;
                this.start();

            }
        }.start();



    }

    @Override
    public void onInit(int i) {
        tts.speak("Activity started",TextToSpeech.QUEUE_FLUSH,null);
    }
}
