package com.a4direct.blanket.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jyothi Asapu on 20-12-2017.
 */

public abstract class GenericRecyclerAdapter<E, L extends BaseListener, VH extends BaseHolder<E, L>>
        extends RecyclerView.Adapter<VH> {

    private List<E> mItems;
    private L mListener;

    public GenericRecyclerAdapter() {
        mItems = new ArrayList<>();
    }

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        E item = mItems.get(position);
        holder.bindItem(item, mListener);
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    public void setItems(List<E> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot set `null` item to the Recycler adapter");
        }

        this.mItems.clear();
        this.mItems.addAll(items);
        notifyItemRangeChanged(0, mItems.size());
    }

    public List<E> getItems() {
        return mItems;
    }

    public E getItem(int position) {
        return mItems.get(position);
    }

    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to the Recycler adapter");
        }
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    public void addAll(List<E> items) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot add `null` mItems to the Recycler adapter");
        }

        this.mItems.addAll(items);
        notifyItemRangeInserted(this.mItems.size() - items.size(), items.size());
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public void remove(E item) {
        int position = mItems.indexOf(item);
        if (position > -1) {
            mItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void setListener(L listener) {
        this.mListener = listener;
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

    protected void tearDown() {
        mListener = null;
    }
}
