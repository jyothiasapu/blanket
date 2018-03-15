package com.a4direct.sample;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.a4direct.blanket.indicator.PageIndicator;
import com.a4direct.blanket.viewpager.ViewPagerAdapter;
import com.a4direct.blanket.viewpager.ViewPagerItem;
import com.a4direct.sample.databinding.ActivityInfoBinding;
import com.a4direct.sample.model.ListViewObject;
import com.a4direct.sample.model.ViewObject;

import java.util.ArrayList;

/**
 * Created by Jyothi Asapu on 11-03-2018.
 */

public class InfoActivity extends AppCompatActivity {

    private ArrayList<ViewPagerItem> mObj;

    private PageIndicator mPageIndicator;
    private ViewPager mViewPager;
    private ViewPagerAdapter mPagerAdapter;

    private ActivityInfoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        setStatusBarColor();
    }

    private void init() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_info);

        mViewPager = mBinding.included.viewPager;
        mPageIndicator = mBinding.included.viewPageIndicator;
        setActionBar(mBinding.toolbar);

        initData();

        mPagerAdapter = new ViewPagerAdapter(mObj);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(mPageListener);
        mPageIndicator.setViewPager(mViewPager);
    }

    private void setStatusBarColor() {
        if (isFinishing()) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
    }

    private void initData() {
        mObj = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("Australia");
        list.add("Brazil");
        list.add("Canada");
        list.add("France");
        list.add("Germany");
        list.add("India");
        list.add("Netherlands");
        list.add("Sweden");
        list.add("United Kingdom");
        list.add("United States");

        // TODO: Create your own object
        ListViewObject v1 = new ListViewObject("Page1", list);
        mObj.add(new ViewPagerItem<ListViewObject>(R.layout.test_list_view, v1));

        // Hack for Initial view
        setTitle(v1.getTitle());

        // TODO: Create own your  object
        ViewObject v2 = new ViewObject("Page2", "This is a4Direct");
        mObj.add(new ViewPagerItem<ViewObject>(R.layout.test_view, v2));

        list = new ArrayList<>();
        list.add("Akshaya");
        list.add("Asquare");
        list.add("ClayBind");
        list.add("ShipDirect");
        list.add("4Direct");
        list.add("Jyothi");
        ListViewObject v3 = new ListViewObject("Page3", list);
        mObj.add(new ViewPagerItem<ListViewObject>(R.layout.test_list_view, v3));

        ViewObject v4 = new ViewObject("Page4", "This is ClayBind");
        mObj.add(new ViewPagerItem<ViewObject>(R.layout.test_view, v4));
    }

    private ViewPager.OnPageChangeListener mPageListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // TODO: Write your own code
        }

        @Override
        public void onPageSelected(int position) {
            setTitle(mObj.get(position).getViewObject().getTitle());
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            // TODO: write your own code
        }

    };

    @Override
    protected void onDestroy() {
        if (mPagerAdapter != null) {
            mPagerAdapter.tearDown();
        }

        if (mViewPager != null) {
            mViewPager.removeOnPageChangeListener(mPageListener);
        }

        super.onDestroy();
    }
}


