package com.y2thez.samples.backgroundservices;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.y2thez.samples.backgroundservices.Services.CountingService;
import com.y2thez.samples.backgroundservices.Services.ForegroundCountingService;
import com.y2thez.samples.backgroundservices.Services.JobCountingService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View v) {
        count();
    }

    public void startForeground(View v) {
        countForeground();
    }
    public void startJob(View v) {
        countJob();
    }

    public void stopCounting(View v) {
        stopService(new Intent(this, CountingService.class));
        cancelJob();
    }

    private void count() {
        startService(new Intent(this, CountingService.class));
    }

    private void countForeground() {
        if (VERSION.SDK_INT >= VERSION_CODES.O) {
            startForegroundService(new Intent(this, ForegroundCountingService.class));

        }
    }

    private void cancelJob() {
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.cancelAll();
    }

    private void countJob() {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this, JobCountingService.class));

        builder.setMinimumLatency(0);

        //builder.setOverrideDeadline(60 * 1000);
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        //builder.setRequiresDeviceIdle(true);
        //builder.setRequiresCharging(true);

        // Extras
//        PersistableBundle extras = new PersistableBundle();
//        builder.setExtras(extras);

        // Schedule job
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.schedule(builder.build());
    }
}

