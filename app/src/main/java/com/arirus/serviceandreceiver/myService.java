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

/**
 * Created by whd910421 on 16/10/20.
 */

public class myService extends IntentService {
    private static final String TAG = "myService";

    public myService() {
        super(TAG);
    }

    public void setAlarmTime(Context context)
    {
        Intent intent = new Intent(context, myService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(),1000*60,pendingIntent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent i = new Intent(this, MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);

        Notification notification = new NotificationCompat.Builder(this)
                                            .setTicker("XXXX")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentText("QQQQQQQQ")
                .setContentTitle("WWWWWWWW")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setVibrate(new long[]{4,5,6,8,9})
                .build();

        NotificationManagerCompat.from(this).notify(0,notification);
    }
}
