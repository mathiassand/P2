package com.p2prototype.b217.moodprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class moodLogging extends AppCompatActivity {
    //Til VisualObject
    int mood;
    int anxiety;
    int sleepHours;
    int sleepMinutes;
    float weight;
    String note;
    Event[] eventList = new Event[0];
    Medicine[] medicineList = new Medicine[0];
    VisualObject[] visualisation = new VisualObject[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_logging);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void registerButton(){
        //visualisation[] = new VisualObject(mood, anxiety, sleepHours, sleepMinutes, weight, note,
        //eventList[].getEventName, eventList[].getFlagColor, medicineList[].getMedicineName, medicineList[].getPillColor)
    }
}
