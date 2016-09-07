package com.food.yummy.onlinekitchen.app;

import android.app.Application;

/**
 * Created by harry on 9/6/16.
 */
public class OnlineKitchen extends Application {

    private AppInitializer appInitializer;

    @Override
    public void onCreate() {
        super.onCreate();
        appInitializer = AppInitializer.initInstance(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        appInitializer.terminate();
    }
}
