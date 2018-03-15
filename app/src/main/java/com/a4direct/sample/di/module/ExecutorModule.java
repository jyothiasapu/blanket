package com.a4direct.sample.di.module;

import com.a4direct.sample.util.AppExecutors;
import com.a4direct.sample.util.DiskIOThreadExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jyothi Asapu on 16-02-2018.
 */

@Module
public class ExecutorModule {

    @Provides
    @Singleton
    public AppExecutors getExecutors() {
        return new AppExecutors();
    }

    @Provides
    @Singleton
    public DiskIOThreadExecutor getDiskIO(AppExecutors exe) {
        return exe.diskIO();
    }

    @Provides
    @Singleton
    public AppExecutors.MainThreadExecutor getMainThread(AppExecutors exe) {
        return exe.mainThread();
    }

    @Provides
    @Singleton
    public Executor getNetworkIO(AppExecutors exe) {
        return exe.networkIO();
    }

}
