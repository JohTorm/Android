package com.example.workoutapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int ADD_NEW_PART_INTENT_ID = 8976;

    private ListView listView;

    ArrayList<WorkoutClass> fullWorkout = new ArrayList<>();
    ArrayList<String>  workoutType = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addNewButton).setOnClickListener(this);

        findViewById(R.id.startButton).setOnClickListener(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NEW_PART_INTENT_ID && resultCode == Activity.RESULT_OK)
        {
            WorkoutClass newPart = (WorkoutClass) data.getSerializableExtra("NEW_PART");
            fullWorkout.add(newPart);
            String seconds = Integer.toString(newPart.getSeconds());
            String workout = newPart.getType() + " " + seconds;
            workoutType.add(workout);



            listView = (ListView) findViewById(R.id.listView);


            final ArrayAdapter<String> aa;
            aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, workoutType);
            listView.setAdapter(aa);


        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.addNewButton)
        {
            Intent intent =new Intent(this, workoutActivity.class);
            startActivityForResult(intent,ADD_NEW_PART_INTENT_ID);


        }
        else if(view.getId()== R.id.startButton)
        {
            Intent intent =new Intent(this, WorkoutStartedActivity.class);

            intent.putExtra("LIST_TYPE", fullWorkout);
            startActivity(intent);



        }


    }
}
