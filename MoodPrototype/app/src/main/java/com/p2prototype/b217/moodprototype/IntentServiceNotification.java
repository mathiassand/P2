package com.p2prototype.b217.moodprototype;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v4.app.NotificationManagerCompat;

/**
 * Created by peter on 05-05-2017.
 */

public class IntentServiceNotification extends IntentService {
    private static final int NOTIFICATION_ID=3;
    public IntentServiceNotification(){
        super("IntentServiceNotification");
    }
    @Override
    protected void onHandleIntent(Intent intent){
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("God Stemning");
        builder.setContentText("Har du glemt mig i dag?");
        builder.setSmallIcon(R.drawable.bell);
        Intent notifyIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,2,notifyIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat=builder.build();
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID,notificationCompat);
    }
}
