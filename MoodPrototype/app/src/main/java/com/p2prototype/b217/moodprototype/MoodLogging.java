package com.p2prototype.b217.moodprototype;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MoodLogging extends AppCompatActivity {
    int mood;
    int anxiety;
    int sleep;
    float weight;
    String note;
    Event[] eventList = new Event[0];
    Medicine[] medicineList = new Medicine[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_logging);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        EditText notes=(EditText)findViewById(R.id.notes_edit);
        notes.setOnFocusChangeListener(keyboardAwayListener);
        NumberPicker hoursSleptNp= (NumberPicker)findViewById(R.id.sleep_picker_1);
        NumberPicker minutesSleptNp=(NumberPicker)findViewById(R.id.sleep_picker_2);
        NumberPicker weightKg= (NumberPicker)findViewById(R.id.weight_picker_1);
        NumberPicker weightComma=(NumberPicker)findViewById(R.id.weight_picker_2);
        hoursSleptNp.setMaxValue(24);
        hoursSleptNp.setMinValue(0);
        minutesSleptNp.setMinValue(0);
        minutesSleptNp.setMaxValue(59);
        weightKg.setMinValue(0);
        weightKg.setMaxValue(200);
        weightComma.setMaxValue(9);
        weightComma.setMinValue(0);
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
    private View.OnFocusChangeListener keyboardAwayListener = new View.OnFocusChangeListener(){
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                hideKeyboard(v);
            }
        }
    };
}

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class moodLogging extends AppCompatActivity {
    int mood;
    int anxiety;
    int sleep;
    float weight;
    String note;
    Event[] eventList = new Event[0];
    Medicine[] medicineList = new Medicine[0];

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
}

    int sleepMinutes;
    int sleepHours;
