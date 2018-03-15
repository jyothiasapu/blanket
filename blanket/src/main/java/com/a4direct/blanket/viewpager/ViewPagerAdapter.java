package com.a4direct.blanket.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a4direct.blanket.Destroy;

import java.util.ArrayList;

/**
 * This class is for rendering views with pager adapter.
 *
 * Created by Jyothi Asapu on 10-03-2018.
 */

public class ViewPagerAdapter<T extends PagerItem> extends PagerAdapter implements Destroy {

    private ArrayList<T> mList;

    public ViewPagerAdapter(ArrayList<T> list) {
        mList = list;
    }

    @Override
    public Object instantiateItem(ViewGroup group, int position) {
        T item = mList.get(position);
        LayoutInflater inflater = LayoutInflater.from(group.getContext());
        View view = inflater.inflate(item.getLayoutId(), group, false);
        group.addView(view);

        if (view instanceof ViewPagerInterface) {
            ((ViewPagerInterface) view).setObject(item);
        } else {
            throw new IllegalArgumentException("View is not a instance of ViewPagerInterface");
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup group, int position, Object view) {
        group.removeView((View) view);
    }

    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        }

        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void tearDown() {
        mList = null;
    }
}
