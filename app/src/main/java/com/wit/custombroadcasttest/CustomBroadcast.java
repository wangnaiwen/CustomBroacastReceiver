package com.wit.custombroadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wnw on 2016/8/29.
 */

public class CustomBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //you can get the data from intent
        String data = intent.getStringExtra("data");
        Log.d("wnw", "Receiver +　"+data);
    }
}
