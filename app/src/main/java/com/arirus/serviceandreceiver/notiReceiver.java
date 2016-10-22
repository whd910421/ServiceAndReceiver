package com.arirus.serviceandreceiver;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by whd910421 on 16/10/21.
 */

public class notiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("notiReceiver","XXXXXXXXX");
        if (getResultCode() != Activity.RESULT_CANCELED)
        {
            Intent i = new Intent(context, MainActivity.class);
            PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0);

            Notification notification = new NotificationCompat.Builder(context)
                    .setTicker("XXXX")
                    .setSmallIcon(android.R.drawable.ic_menu_report_image)
                    .setContentText("QQQQQQQQ")
                    .setContentTitle("WWWWWWWW")
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .setVibrate(new long[]{4,5,6,8,9})
                    .build();

            NotificationManagerCompat.from(context).notify(0,notification);
        }
    }
}
