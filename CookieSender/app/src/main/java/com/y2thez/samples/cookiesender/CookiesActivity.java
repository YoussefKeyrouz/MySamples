package com.y2thez.samples.cookiesender;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CookiesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookies);
    }

    public void gimmeCookie(View v) {
        Intent in = new Intent();
//        in.setPackage("com.y2thez.samples.cookieeater");
        in.setAction("com.y2thez.action.COOKIE");
        sendBroadcast(in);
    }
}
