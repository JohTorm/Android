package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class workoutActivity extends AppCompatActivity implements View.OnClickListener {
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        findViewById(R.id.addButton).setOnClickListener(this);

    }
    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.pauseRadioButton:
                if(checked)
                    type = "Pause";
                break;
            case R.id.workoutRadioButton:
                if(checked)
                    type = "Workout";
                break;
        }
    }
    @Override
    public void onClick(View view) {

        EditText textEditor = findViewById(R.id.editText);

        String aika = textEditor.getText().toString();
        int seconds = Integer.parseInt(aika);
        WorkoutClass part = new WorkoutClass(seconds, type);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("NEW_PART", part);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
