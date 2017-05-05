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
}
