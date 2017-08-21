package com.y2thez.samples.backgroundservices.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Y on 8/12/2017.
 * Background service example. Will run for 1 minute only
 */

public class CountingService extends Service {

    private static final String TAG = "COUNTING BOT";
    private int count = 0;
    private Handler mHandler;

    private Runnable runnableService = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Counting: " + (count++) + " seconds");
            mHandler.postDelayed(runnableService, 1000);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "IT'S ALIIIVE");
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
