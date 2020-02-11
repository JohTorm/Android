package com.example.workoutapp;

import java.io.Serializable;

public class WorkoutClass implements Serializable {
    private int seconds;
    private String type;

   public WorkoutClass(int seconds, String type)
   {
       this.seconds = seconds;
       this.type = type;
   }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
