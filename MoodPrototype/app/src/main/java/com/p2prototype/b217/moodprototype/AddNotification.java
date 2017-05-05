package com.p2prototype.b217.moodprototype;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by peter on 05-05-2017.
 */

public class AddNotification extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Received!",Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, IntentServiceNotification.class);
        context.startService(intent1);
        /*NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.bell)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());*/
    }
}
