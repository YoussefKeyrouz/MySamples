package com.y2thez.samples.backgroundservices.Services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Y on 8/12/2017.
 * Foreground service example. Will run forever
 */

public class ForegroundCountingService extends Service {

    private static final String TAG = "FOREGROUND BOT";
    private int count = 0;
    private Handler mHandler;

    private Runnable runnableService = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Counting Forever: " + (count++) + " seconds");
            mHandler.postDelayed(runnableService, 1000);
            if(count == 90) {
                stopSelf();
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "IT'S ALIIIVE");

        //IMPORTANT: APP WILL CRASH IN 5 SECONDS WITHOUT THIS
        startForeground(42, new Notification());

        mHandler = new Handler();
        mHandler.post(runnableService);
        return START_STICKY;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(runnableService);
        Log.d(TAG, "it's dead jim");

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
