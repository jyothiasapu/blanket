package com.a4direct.blanket.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jyothi Asapu on 20-12-2017.
 */

public abstract class BaseHolder<E, L extends BaseListener> extends RecyclerView.ViewHolder {

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindItem(E item, @Nullable L listener);

    public abstract void clear();

}

