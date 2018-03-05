package com.a4direct.sample;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.a4direct.blanket.adapter.base.BaseHolder;
import com.a4direct.blanket.adapter.base.OnItemClickListener;

/**
 * Created by Jyothi Asapu on 5/3/18.
 */

public class StringViewHolder extends BaseHolder<String, OnItemClickListener<String>> {

    private TextView mTextView;

    public StringViewHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.text_view);
    }

    @Override
    public void bindItem(final String item, @Nullable final OnItemClickListener<String> listener) {
        mTextView.setText(item);

        if (listener == null) {
            return;
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClicked(item);
                }
            }
        });

        // TODO: add long click listener

    }

    @Override
    public void clear() {

    }
}
