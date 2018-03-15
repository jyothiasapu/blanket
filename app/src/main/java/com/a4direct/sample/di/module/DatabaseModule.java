package com.a4direct.sample.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.a4direct.sample.data.FeedbackDao;
import com.a4direct.sample.data.TemplateDatabase;
import com.a4direct.sample.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jyothi Asapu on 16-02-2018.
 */

@Module(includes = {ExecutorModule.class, ContextModule.class})
public class DatabaseModule {

    @Provides
    @Singleton
    public TemplateDatabase getDatabase(@ApplicationContext Context ctx) {
        return Room.databaseBuilder(ctx, TemplateDatabase.class, "Ergast.db").build();
    }

    @Provides
    @Singleton
    public FeedbackDao getDriversDao(TemplateDatabase database) {
        return database.feedbackDao();
    }

}
