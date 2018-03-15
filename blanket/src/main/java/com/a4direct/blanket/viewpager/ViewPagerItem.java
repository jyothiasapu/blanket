package com.a4direct.blanket.viewpager;

/**
 * Created by Jyothi Asapu on 10-03-2018.
 */

public class ViewPagerItem<T extends ViewObjectInterface> extends PagerItem {

    private int mLayoutId;

    private T mObj;

    public ViewPagerItem(int layoutId, T obj) {
        mLayoutId = layoutId;
        mObj = obj;
    }

    @Override
    public int getLayoutId() {
        return mLayoutId;
    }

    public T getViewObject() {
        return mObj;
    }
}
