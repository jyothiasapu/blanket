package com.a4direct.blanket.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a4direct.blanket.adapter.base.BaseHolder;
import com.a4direct.blanket.adapter.base.BaseListener;
import com.a4direct.blanket.adapter.base.BaseObject;
import com.a4direct.blanket.adapter.base.Destroy;

/**
 * Created by Jyothi Asapu on 25-01-2018.
 */

public abstract class GenericAdapter<E extends BaseObject, L extends BaseListener, VH extends BaseHolder<E, L>>
        extends PagedListAdapter<E, VH> implements Destroy {

    private L mListener;

    public GenericAdapter() {
        super(new Callback<E>());
    }

    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        E item = getItem(position);
        if (item != null) {
            holder.bindItem(item, mListener);
        } else {
            holder.clear();
        }
    }

    public void setListener(L listener) {
        this.mListener = listener;
    }

    public static final class Callback<E extends BaseObject> extends DiffCallback<E> {

        @Override
        public boolean areItemsTheSame(@NonNull E oldItem, @NonNull E newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull E oldItem, @NonNull E newItem) {
            return oldItem.equals(newItem);
        }
    }

    @Override
    public void tearDown() {
        mListener = null;
    }

    @NonNull
    protected View inflate(@LayoutRes final int layout, @Nullable final ViewGroup parent,
                           final boolean attachToRoot) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, attachToRoot);
    }

    @NonNull
    protected View inflate(@LayoutRes final int layout, final @Nullable ViewGroup parent) {
        return inflate(layout, parent, false);
    }
}
