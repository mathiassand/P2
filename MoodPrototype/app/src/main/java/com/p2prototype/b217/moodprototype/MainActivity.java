package com.p2prototype.b217.moodprototype;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;






public class MainActivity extends AppCompatActivity {



    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/dataFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File dir = new File(path);
        dir.mkdirs();
        }

    ///Save and Load for MainActivity.java:
    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                if (!(file.equals(""))){
                    for (int i = 0; i < data.length; i++) {
                        fos.write(data[i].getBytes(),(int)file.length(),data.length);
                        if (i < data.length - 1) {
                            fos.write("\n".getBytes());
                        }
                    }
                }
                else {
                    for (int i = 0; i < data.length; i++) {
                        fos.write(data[i].getBytes());
                        if (i < data.length - 1) {
                            fos.write("\n".getBytes());
                        }
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }


    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
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
        Context context = this;

        alarmMngr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, SettingsActivity.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 48);
        cal.set(Calendar.SECOND, 0);

        alarmMngr.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);


    }
}
