package com.a4direct.sample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.a4direct.sample.R;
import com.a4direct.sample.data.FeedbackDao;
import com.a4direct.sample.model.Feedback;
import com.a4direct.sample.util.DiskIOThreadExecutor;

import javax.inject.Inject;

/**
 * Created by Jyothi Asapu on 28-01-2018.
 */

public class FeedbackViewModel extends ViewModel {

    private static final String TAG = "FeedbackViewModel";

    public ObservableField<String> title;
    public ObservableField<String> feedbackBy;
    public ObservableField<String> feedback;

    private DiskIOThreadExecutor mExecutor;
    private FeedbackDao mFeedbackDao;

    @Inject
    public FeedbackViewModel(DiskIOThreadExecutor exe, FeedbackDao dao) {
        mExecutor = exe;
        mFeedbackDao = dao;

        init();
    }

    private void init() {
        title = new ObservableField<>();
        title.set("");

        feedback = new ObservableField<>();
        feedback.set("");

        feedbackBy = new ObservableField<>();
        feedbackBy.set("");
    }

    public void saveFeedback(View view) {
        if (title.get().isEmpty()) {
            Toast.makeText(view.getContext().getApplicationContext(),
                    R.string.title_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        if (feedback.get().isEmpty()) {
            Toast.makeText(view.getContext().getApplicationContext(),
                    R.string.title_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        if (feedbackBy.get().isEmpty()) {
            Toast.makeText(view.getContext().getApplicationContext(),
                    R.string.title_is_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        final Feedback fb = new Feedback(title.get(), feedback.get(), feedbackBy.get());

        if (mFeedbackDao == null) {
            Log.i(TAG, "mFeedbackDao is null");
            return;
        }

        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                mFeedbackDao.insertFeedback(fb);
            }
        };

        mExecutor.execute(saveRunnable);

        clearFields();
    }

    private void clearFields() {
        title.set("");
        feedback.set("");
        feedbackBy.set("");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
