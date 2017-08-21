package com.y2thez.samples.backgroundservices.Services;

import android.app.Notification;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Y on 8/19/2017.
 * Will run for 10 minutes
 */

public class JobCountingService extends JobService {

    private static final String TAG = "COUNTING JOB";
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
        //initialization
        Log.d(TAG, "Job Queued");

        return START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d(TAG, "Task Removed");
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Log.d(TAG, "IT'S ALIIIVE");

        mHandler = new Handler();
        mHandler.post(runnableService);
        // Return true as there's more work to be done with this job.
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        mHandler.removeCallbacks(runnableService);
        Log.d(TAG, "Job Stopped");
        // Return false to drop the job.
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "it's dead jim");
    }
}
