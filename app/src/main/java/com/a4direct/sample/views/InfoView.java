package com.a4direct.sample.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.a4direct.blanket.viewpager.ViewPagerInterface;
import com.a4direct.blanket.viewpager.ViewPagerItem;
import com.a4direct.sample.databinding.TestViewBinding;
import com.a4direct.sample.model.ViewObject;

/**
 * Created by Jyothi Asapu on 12-03-2018.
 */

public class InfoView extends RelativeLayout implements ViewPagerInterface<ViewPagerItem<ViewObject>> {

    private TestViewBinding mBinding;

    public InfoView(Context context) {
        super(context, null);
    }

    public InfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setObject(ViewPagerItem<ViewObject> item) {
        mBinding.infoView.setText(item.getViewObject().getName());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mBinding = TestViewBinding.bind(this);
    }

}
