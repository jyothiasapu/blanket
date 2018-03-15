package com.a4direct.sample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.a4direct.sample.model.Feedback;

import javax.inject.Inject;

/**
 * Created by Jyothi Asapu on 25-01-2018.
 */

public class FeedbackListViewModel extends ViewModel {

    private LiveData<PagedList<Feedback>> mFeedbackList;

    @Inject
    public FeedbackListViewModel(LiveData<PagedList<Feedback>> list) {
        mFeedbackList = list;
    }

    public LiveData<PagedList<Feedback>> getFeedbackList() {
        return mFeedbackList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
