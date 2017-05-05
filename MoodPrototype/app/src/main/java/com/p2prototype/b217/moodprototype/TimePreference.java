package com.p2prototype.b217.moodprototype;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimePreference extends DialogPreference implements TimePicker.OnTimeChangedListener {
    private Calendar mCalendar;
    private TimePicker picker = null;
    private long mHour;
    private long mMinutes;

    public TimePreference(Context ctxt) {
        this(ctxt, null);
    }

    public TimePreference(Context ctxt, AttributeSet attrs) {
        this(ctxt, attrs, android.R.attr.dialogPreferenceStyle);
    }

    public TimePreference(Context ctxt, AttributeSet attrs, int defStyle) {
        super(ctxt, attrs, defStyle);

        setPositiveButtonText("Sæt");
        setNegativeButtonText("Annuller");
        mCalendar = new GregorianCalendar();
    }

    public long getHour() {
        return mHour;
    }

    public long getMinutes() {
        return mMinutes;
    }

    @Override
    protected View onCreateDialogView() {
        picker = new TimePicker(getContext());
        picker.setOnTimeChangedListener(this);
        picker.setIs24HourView(DateFormat.is24HourFormat(getContext()));
        return (picker);
    }

    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        picker.setCurrentHour(mCalendar.get(Calendar.HOUR_OF_DAY));
        picker.setCurrentMinute(mCalendar.get(Calendar.MINUTE));
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (positiveResult) {
            mCalendar.set(Calendar.HOUR_OF_DAY, picker.getCurrentHour());
            mCalendar.set(Calendar.MINUTE, picker.getCurrentMinute());

            setSummary(getSummary());
            if (callChangeListener(mCalendar.getTimeInMillis())) {
                persistLong(mCalendar.getTimeInMillis());
                notifyChanged();
            }
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return (a.getString(index));
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        if (restoreValue) {
            long persistedValue;
            try {
                persistedValue = getPersistedLong(System.currentTimeMillis());
            } catch (Exception e) {
                //Stale persisted data may be the wrong type
                persistedValue = System.currentTimeMillis();
            }
            mCalendar.setTimeInMillis(persistedValue);
        } else if (defaultValue != null) {
            mCalendar.setTimeInMillis(Long.parseLong((String) defaultValue));
        } else {
            //!restoreValue, defaultValue == null
            mCalendar.setTimeInMillis(System.currentTimeMillis());
        }

        setSummary(getSummary());
    }

    @Override
    public CharSequence getSummary() {
        if (mCalendar == null) {
            return null;
        }
        return DateFormat.getTimeFormat(getContext()).format(new Date(mCalendar.getTimeInMillis()));
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        mHour = hourOfDay;
        mMinutes = minute;
    }
}