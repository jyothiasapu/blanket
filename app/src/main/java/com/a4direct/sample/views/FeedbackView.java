package com.a4direct.sample.views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.a4direct.sample.R;
import com.a4direct.sample.databinding.FeedbackViewBinding;
import com.a4direct.sample.interfaces.ViewInterface;
import com.a4direct.sample.viewmodel.FeedbackViewModel;


/**
 * Created by Jyothi Asapu on 28-01-2018.
 */

public class FeedbackView extends BaseConstraintLayout implements ViewInterface {

    private FeedbackViewBinding mBinding;
    private FeedbackViewModel mViewModel;

    public FeedbackView(Context context) {
        this(context, null);
    }

    public FeedbackView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedbackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getTitleResource() {
        return R.string.add_feedback;
    }

    @Override
    public void initializeViewModel(AppCompatActivity act, ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(act, factory).get(FeedbackViewModel.class);
        mBinding.setModel(mViewModel);
    }

    @Override
    public int getFabIcon() {
        return R.drawable.ic_done_white_24dp;
    }

    @Override
    public void fabAction(View view) {
        mViewModel.saveFeedback(view);
    }

    @Override
    public void onInflateComplete() {
        mBinding = FeedbackViewBinding.bind(this);
    }

    @Override
    public void onWindowDetached() {

    }
}
