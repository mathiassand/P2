package com.p2prototype.b217.moodprototype;

/**
 * Created by Anders on 30/04/2017.
 */

public class VisualObject extends moodLogging{

    public VisualObject(int mood, int anxiety, int sleep, float weight, String note/*+ medicin og begivenhed array, samt dato*/){
        this.mood = mood;
        this.anxiety = anxiety;
        this.sleep = sleep;
        this.weight = weight;
        this.note = note;
    }
    //Lav method nedenunder som laver visualisering. Kald method inde i visualiserings skærmen.
    public void VisualizeData(){

    }
}
