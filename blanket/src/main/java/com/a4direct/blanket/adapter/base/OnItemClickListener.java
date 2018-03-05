package com.a4direct.blanket.adapter.base;

/**
 * Created by Jyothi Asapu on 20-12-2017.
 */

public interface OnItemClickListener<T> extends BaseListener {

    void onItemClicked(T item);

    void onItemLongPress(T item);

}
