package com.p2prototype.b217.moodprototype;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;

import java.sql.Time;
import java.util.Calendar;
import java.util.StringTokenizer;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import static java.util.Calendar.MINUTE;


public class SettingsActivity extends PreferenceActivity {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TimePreference timePreference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        sharedPref = this.getSharedPreferences(
                getString(R.string.PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
        editor =sharedPref.edit();
        /*getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PrefsFragment())
                .commit();*/
        CheckBoxPreference checkBoxPreference =(CheckBoxPreference)findPreference("pref_noti");
        timePreference =(TimePreference)findPreference("time_noti_key");
        checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    editor.putBoolean("noti_on",true);
                } else {
                    editor.putBoolean("noti_on",false);
                }
                return true;
            }
        });
                /*calendar.set(Calendar.HOUR_OF_DAY, 10);
                calendar.set(Calendar.MINUTE, 30);
                calendar.set(Calendar.SECOND, 0);
                Intent notifyIntent = new Intent(SettingsActivity.this,AddNotification.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast
                        (SettingsActivity.this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) SettingsActivity.this.getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
                    notificationsOn=true;

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

        }*/
    }

@Override
    public void onStop(){
    super.onStop();
    long hour=timePreference.getHour();
    long minutes=timePreference.getMinutes();
    editor.putLong("time_hour",hour);
    editor.putLong("time_minutes",minutes);
    editor.commit();
    AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
    Intent notifyIntent = new Intent(this, AddNotification.class);
    PendingIntent pendingIntent = PendingIntent.getBroadcast
            (this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    Calendar calendar = Calendar.getInstance();
    int currentHour=calendar.get(Calendar.HOUR_OF_DAY);
    int currentMinute=calendar.get(Calendar.MINUTE);
    if (currentHour>hour){
        calendar.add(Calendar.DATE,1);
    } else if(currentHour==hour&&currentMinute>minutes){
        calendar.add(Calendar.DATE,1);
    }
    calendar.set(Calendar.HOUR_OF_DAY,(int) hour);
    calendar.set(Calendar.MINUTE,(int) minutes);
    alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(),
            1000*60*60*24, pendingIntent);
    sharedPref=this.getSharedPreferences(getString(R.string.PREFERENCE_FILE_KEY),Context.MODE_PRIVATE);
    if (!sharedPref.getBoolean("noti_on",true)) alarmManager.cancel(pendingIntent);
}
    /*public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}


