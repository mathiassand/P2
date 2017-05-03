package com.p2prototype.b217.moodprototype;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Calendar;






public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }








    public void moodButtonPressed(View view)
    {
        Intent openMoodScreen = new Intent(this,MoodLogging.class);
        startActivity(openMoodScreen);
    }
    public void InfoButtonPressed(View view){


        Intent openInfoScreen = new Intent(this,InfoActivity.class);
        startActivity(openInfoScreen);
    }

    public void SettingsButtonPressed(View view) {

        Intent openSettingScreen = new Intent(this,SettingsActivity.class);
        startActivity(openSettingScreen);
    }
    public void HistorikButtonPressed (View view){
        Intent openHistorikScreen = new Intent(this, HistorikActivity.class);
        startActivity(openHistorikScreen);

    }
    public void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.bell)
                        //.setContentTitle("God stemning")
                        .setContentText("Hej, har du glemt mig i dag?");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }



    public void addTimeNotification(){

        //time on notification
        AlarmManager alarmMngr;
        PendingIntent alarmIntent;

        alarmMngr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NotificationView.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 50);
        cal.set(Calendar.SECOND, 0);

        alarmMngr.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);


    }












        //This will hopefully make an .csv-file










}
