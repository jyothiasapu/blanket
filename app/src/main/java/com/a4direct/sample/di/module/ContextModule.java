package com.a4direct.sample.di.module;

import android.app.Application;
import android.content.Context;

import com.a4direct.sample.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jyothi Asapu on 16-02-2018.
 */

@Module
public class ContextModule {

    @Provides
    @ApplicationContext
    public Context getApplicationContext(Application app ) {
        return app;
    }

}
