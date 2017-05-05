package com.p2prototype.b217.moodprototype;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Calendar;

import static java.util.Calendar.MINUTE;

/**
 * Created by peter on 05-05-2017.
 */

public class PrefsFragment extends PreferenceFragment {
    Boolean noti=true;
    SharedPreferences sharedPref;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

    }
    @Override
    public void onStop(){

        //Toast.makeText(getActivity(),sharedPref.getString("time_noti_key",""), Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        TimePreference timepref=(TimePreference)findPreference("time_noti_key");
        CheckBoxPreference noti=(CheckBoxPreference)findPreference("pref_noti");
        editor.putString("time_noti_key",timepref.getSummary().toString());
        editor.putBoolean("pref_noti",noti.isChecked());
        editor.apply();
        String time=sharedPref.getString("noti_time_key","");
        String[] pieces=time.split(":");
        int hour=Integer.parseInt(pieces[0]);
        int minute=Integer.parseInt(pieces[1]);
        if (sharedPref.getBoolean("pref_noti",true)) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            Intent notifyIntent = new Intent(this, AddNotification.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast
                    (this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);
        }
        super.onStop();
    }
}
