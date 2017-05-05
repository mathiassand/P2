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
    Calendar calendar = Calendar.getInstance();
    Switch notifiSwitch;
    private boolean notificationsOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        notifiSwitch = (Switch) findViewById(R.id.notifikation);
        notifiSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(notifiSwitch.isChecked()){
                calendar.set(Calendar.HOUR_OF_DAY, 10);
                calendar.set(Calendar.MINUTE, 30);
                calendar.set(Calendar.SECOND, 0);
                Intent notifyIntent = new Intent(SettingsActivity.this,AddNotification.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast
                        (SettingsActivity.this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) SettingsActivity.this.getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
                    notificationsOn=true;}
                else notificationsOn=false;


            }
        });
        if(notificationsOn){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 10);
            calendar.set(Calendar.MINUTE, 20);
            calendar.set(Calendar.SECOND, 0);
            Intent notifyIntent = new Intent(this,AddNotification.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast
                    (this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);

        }
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


