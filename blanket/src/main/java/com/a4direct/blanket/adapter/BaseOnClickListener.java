package com.a4direct.blanket.adapter;

/**
 * Created by Jyothi Asapu on 20-12-2017.
 */

public interface BaseOnClickListener<T> extends BaseListener {

    void onItemClicked(T item);

}
