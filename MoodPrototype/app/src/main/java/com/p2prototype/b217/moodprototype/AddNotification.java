package com.p2prototype.b217.moodprototype;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AddNotification extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, IntentServiceNotification.class);
        context.startService(intent1);
    }
}
