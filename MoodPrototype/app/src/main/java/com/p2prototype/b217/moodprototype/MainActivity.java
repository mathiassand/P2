package com.p2prototype.b217.moodprototype;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    

    Switch notifiSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        notifiSwitch = (Switch) findViewById(R.id.notifikation);
        notifiSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onSwitch(View view){
                    addNotification();
                }
            });
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











        //This will hopefully make an .csv-file









}
