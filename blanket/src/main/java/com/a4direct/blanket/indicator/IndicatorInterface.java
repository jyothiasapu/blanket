package com.a4direct.blanket.indicator;

import android.support.v4.view.ViewPager;

/**
 * Created by Jyothi Asapu on 24-03-2016.
 */
public interface IndicatorInterface extends ViewPager.OnPageChangeListener {

    public void setViewPager(ViewPager view);

    public void setViewPager(ViewPager view, int initialPosition);

    public void notifyDataSetChanged();

    public void setCurrentItem(int item);

}
