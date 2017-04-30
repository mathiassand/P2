package com.p2prototype.b217.moodprototype;

/**
 * Created by Anders on 30/04/2017.
 */

public class Medicine {
    String medicineName;
    int pillColor;
    public Medicine(String medicineName, int pillColor){
        this.medicineName = medicineName;
        this.pillColor = pillColor;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getPillColor() {
        return pillColor;
    }
}
