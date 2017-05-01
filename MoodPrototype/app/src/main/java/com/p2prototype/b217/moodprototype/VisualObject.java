package com.p2prototype.b217.moodprototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Anders on 30/04/2017.
 */

public class VisualObject extends MoodLogging{

    public VisualObject(int mood, int anxiety, int sleepHours, int sleepMinutes, int weightK, int weightG,
                        String note, ArrayList<Event> events, ArrayList<Medicine> meds, Date date/*+ medicin og begivenhed array, samt dato*/){
        this.mood = mood;
        this.anxiety = anxiety;
        this.sleepHours = sleepHours;
        this.sleepMinutes = sleepMinutes;
        this.weightK = weightK;
        this.weightG = weightG;
        this.note = note;
    }

    //Lav method nedenunder som laver visualisering. Kald method inde i visualiserings skærmen.
    public void VisualizeData(){

    }
}
