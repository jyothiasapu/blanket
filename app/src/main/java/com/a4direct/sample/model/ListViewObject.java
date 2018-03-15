package com.a4direct.sample.model;

import com.a4direct.blanket.viewpager.ViewObjectInterface;

import java.util.ArrayList;

/**
 * Created by Jyothi Asapu on 10-03-2018.
 */

public class ListViewObject extends ViewObjectInterface {

    public String mTitle;

    public ArrayList<String> mList;

    public ListViewObject(String title, ArrayList<String> list) {
        mTitle = title;
        mList = list;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public ArrayList<String> getList() {
        return mList;
    }

}
