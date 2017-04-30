package com.p2prototype.b217.moodprototype;

/**
 * Created by Anders on 30/04/2017.
 */

public class VisualObject extends moodLogging{

    public VisualObject(int mood, int anxiety, int sleepHours, int sleepMinutes, float weight,
                        String note, String eventName, int flagColor, String medicineName,
                        int pillColor/*+ medicin og begivenhed array, samt dato*/){
        this.mood = mood;
        this.anxiety = anxiety;
        this.sleepHours = sleepHours;
        this.sleepMinutes = sleepMinutes;
        this.weight = weight;
        this.note = note;
    }
    //Lav method nedenunder som laver visualisering. Kald method inde i visualiserings skærmen.
    public void VisualizeData(){

    }
}
