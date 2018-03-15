package com.a4direct.sample.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.a4direct.blanket.adapter.BaseHolder;
import com.a4direct.blanket.adapter.BaseOnClickListener;
import com.a4direct.sample.R;


/**
 * Created by Jyothi Asapu on 11-03-2018.
 */

public class StringViewHolder extends BaseHolder<String, BaseOnClickListener<String>> {

    private TextView mTextView;

    public StringViewHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.text_view);
    }

    @Override
    public void bindItem(final String item, @Nullable final BaseOnClickListener<String> listener) {
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
    }

    @Override
    public void clear() {

    }
}
