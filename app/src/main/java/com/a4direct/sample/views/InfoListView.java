package com.a4direct.sample.views;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.a4direct.blanket.viewpager.ViewPagerInterface;
import com.a4direct.blanket.viewpager.ViewPagerItem;
import com.a4direct.sample.adapter.StringAdapter;
import com.a4direct.sample.databinding.TestListViewBinding;
import com.a4direct.sample.model.ListViewObject;


/**
 * Created by Jyothi Asapu on 11-03-2018.
 */

public class InfoListView extends BaseConstraintLayout implements ViewPagerInterface<ViewPagerItem<ListViewObject>> {

    private TestListViewBinding mBinding;
    private StringAdapter mAdapter;

    public InfoListView(Context context) {
        this(context, null);
    }

    public InfoListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InfoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onInflateComplete() {
        mBinding = TestListViewBinding.bind(this);

        setupItemAdapter(mBinding.recyclerView);
    }

    public void setupItemAdapter(RecyclerView view) {
        mAdapter = new StringAdapter();
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
    public void setObject(ViewPagerItem<ListViewObject> item) {
        mAdapter.setItems(item.getViewObject().getList());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }

        return null;
    }
}
