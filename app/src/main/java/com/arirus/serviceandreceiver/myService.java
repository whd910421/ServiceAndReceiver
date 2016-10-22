package com.arirus.serviceandreceiver;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by whd910421 on 16/10/20.
 */

public class myService extends IntentService {
    private static final String TAG = "myService";
    public static final String ACTION_SHOW_NOTI = "com.arirus.serviceandreceiver.SHOW_NOTI";
    public static final String PERM_PRIVATE = "com.arirus.serviceandreceiver.PRIVATE";

    public myService() {
        super(TAG);
    }

    public static void setAlarmTime(Context context)
    {
        Intent intent = new Intent(context, myService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(),1000*60,pendingIntent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        sendBroadcast(new Intent(ACTION_SHOW_NOTI));
        sendOrderedBroadcast(new Intent(ACTION_SHOW_NOTI),PERM_PRIVATE );
    }
}
