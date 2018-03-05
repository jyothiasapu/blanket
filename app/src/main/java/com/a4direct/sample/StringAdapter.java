package com.a4direct.sample;

import android.view.ViewGroup;

import com.a4direct.blanket.adapter.RecyclerAdapter;
import com.a4direct.blanket.adapter.base.Destroy;
import com.a4direct.blanket.adapter.base.OnItemClickListener;

/**
 * Created by Jyothi Asapu on 5/3/18.
 */

public class StringAdapter extends RecyclerAdapter<String, OnItemClickListener<String>, StringViewHolder>
        implements Destroy {

    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StringViewHolder(inflate(R.layout.row_item, parent));
    }

    @Override
    public void tearDown() {
        super.tearDown();
    }
}
