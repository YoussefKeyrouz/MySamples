package com.y2thez.samples.cookieeater;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.y2thez.samples.cookieeater.Receivers.CookieReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //iWantCookiesNow();
    }

//    private void iWantCookiesNow() {
//        IntentFilter filter = new IntentFilter("com.y2thez.action.COOKIE");
//        registerReceiver(new CookieReceiver(), filter);
//    }
}
