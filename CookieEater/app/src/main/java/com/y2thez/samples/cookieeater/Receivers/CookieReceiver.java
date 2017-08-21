package com.y2thez.samples.cookieeater.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.y2thez.samples.cookieeater.MainActivity;

/**
 * Created by Y on 8/20/2017.
 */

public class CookieReceiver extends BroadcastReceiver {
    private static String TAG = "CookieReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "Eating Cookie");
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
