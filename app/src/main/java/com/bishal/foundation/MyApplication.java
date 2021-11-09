package com.bishal.foundation;

import android.app.Application;

import com.onesignal.OneSignal;


public class MyApplication extends Application {
    private static final String ONESIGNAL_APP_ID = "e5340c04-6611-4e76-9662-7a2e8d76ff2a"; //bishalc4300gmail.com(ONE SIGNAL)//notification

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
