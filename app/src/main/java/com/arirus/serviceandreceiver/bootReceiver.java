package com.arirus.serviceandreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by whd910421 on 16/10/21.
 */

public class bootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"开机权限",Toast.LENGTH_LONG).show();
        myService.setAlarmTime(context);
    }
}
