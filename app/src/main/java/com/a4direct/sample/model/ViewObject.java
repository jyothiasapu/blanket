package com.a4direct.sample.model;


import com.a4direct.blanket.viewpager.ViewObjectInterface;

/**
 * Created by Jyothi Asapu on 12-03-2018.
 */

public class ViewObject extends ViewObjectInterface {

    public String mTitle;

    public String mName;

    public ViewObject(String title, String name) {
        mTitle = title;
        mName = name;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public String getName() {
        return mName;
    }

}
