package com.a4direct.sample.adapter;

import android.view.ViewGroup;

import com.a4direct.blanket.Destroy;
import com.a4direct.blanket.adapter.BaseOnClickListener;
import com.a4direct.blanket.adapter.GenericRecyclerAdapter;
import com.a4direct.sample.R;
import com.a4direct.sample.viewholder.StringViewHolder;


/**
 * Created by jasapu on 11-03-2018.
 */

public class StringAdapter extends GenericRecyclerAdapter<String, BaseOnClickListener<String>, StringViewHolder>
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