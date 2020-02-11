package com.example.workoutapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.workoutapp.R;
import com.example.workoutapp.WorkoutClass;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends ArrayAdapter<WorkoutClass> {
    private Context mContext;
    private List<WorkoutClass> workoutList = new ArrayList<>();

    public ViewAdapter(@NonNull Context context,  ArrayList<WorkoutClass> list) {
        super(context, 0 , list);
        mContext = context;
        workoutList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        WorkoutClass currentWorkout = workoutList.get(position);

        TextView type = (TextView) listItem.findViewById(R.id.workoutTypeView);
        type.setText(currentWorkout.getType());

        TextView seconds = (TextView) listItem.findViewById(R.id.workoutLengthView);
        String aika = Integer.toString(currentWorkout.getSeconds());
        type.setText(aika);

        return listItem;
    }
}
