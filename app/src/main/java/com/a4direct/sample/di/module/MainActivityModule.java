package com.a4direct.sample.di.module;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.a4direct.sample.data.FeedbackDao;
import com.a4direct.sample.model.Feedback;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jyothi Asapu on 26-02-2018.
 */

@Module
public class MainActivityModule {

    @Provides
    LiveData<PagedList<Feedback>> getPagedList(FeedbackDao dao, PagedList.Config config) {
        return new LivePagedListBuilder<Integer, Feedback>(dao.getFeedbackList(),
                config).build();
    }

    @Provides
    PagedList.Config getPagedConfig() {
        return (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                .setPrefetchDistance(10)
                .setPageSize(20).build();
    }

}
