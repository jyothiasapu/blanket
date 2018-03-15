package com.a4direct.sample.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.a4direct.blanket.adapter.BaseOnClickListener;
import com.a4direct.sample.R;
import com.a4direct.sample.adapter.FeedbackAdapter;
import com.a4direct.sample.databinding.FeedbackListViewBinding;
import com.a4direct.sample.interfaces.ViewInterface;
import com.a4direct.sample.model.Feedback;
import com.a4direct.sample.viewmodel.FeedbackListViewModel;


/**
 * Created by Jyothi Asapu on 25-01-2018.
 */

public class FeedbackListView extends BaseConstraintLayout implements ViewInterface,
        BaseOnClickListener<Feedback> {

    private FeedbackAdapter mAdapter;
    private FeedbackListViewBinding mBinding;
    private FeedbackListViewModel mViewModel;

    public FeedbackListView(Context context) {
        this(context, null);
    }

    public FeedbackListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedbackListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onInflateComplete() {
        mBinding = FeedbackListViewBinding.bind(this);

        setupItemAdapter(mBinding.recyclerView);
    }

    public void setupItemAdapter(RecyclerView view) {
        mAdapter = new FeedbackAdapter();
        mAdapter.setListener(this);
        view.setAdapter(mAdapter);
        view.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onWindowDetached() {
        if (mAdapter != null) {
            mAdapter.tearDown();
        }
    }

    @Override
    public int getTitleResource() {
        return R.string.feedback_list;
    }

    @Override
    public void initializeViewModel(AppCompatActivity act, ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(act, factory).get(FeedbackListViewModel.class);
        mBinding.setModel(mViewModel);

        mViewModel.getFeedbackList().observe(act, new Observer<PagedList<Feedback>>() {
            @Override
            public void onChanged(@Nullable PagedList<Feedback> feedbacks) {
                if (feedbacks == null || feedbacks.size() == 0) {
                    return;
                }

                mAdapter.submitList(feedbacks);
            }
        });
    }

    @Override
    public int getFabIcon() {
        return R.drawable.ic_add_white_24dp;
    }

    @Override
    public void fabAction(View view) {
        return;
    }

    @Override
    public void onItemClicked(Feedback item) {
        Toast.makeText(getContext().getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    }

}
