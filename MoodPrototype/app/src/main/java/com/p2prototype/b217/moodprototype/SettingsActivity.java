package com.p2prototype.b217.moodprototype;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;


public class SettingsActivity extends MainActivity {
    Switch notifiSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        notifiSwitch = (Switch) findViewById(R.id.notifikation);
        notifiSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(notifiSwitch.isChecked())
                    addTimeNotification();
               // addNotification();

            }
        });
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


