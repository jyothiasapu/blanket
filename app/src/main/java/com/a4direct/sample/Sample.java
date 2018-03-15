package com.a4direct.sample;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by jasapu on 15-03-2018.
 */

public class Sample extends Application implements HasActivityInjector {

    @Inject
    public DispatchingAndroidInjector<Activity> mActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    public static Sample get(Activity act) {
        return (Sample) act.getApplication();
    }

    public static Sample get(Application app) {
        return (Sample) app;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return mActivityInjector;
    }
}
