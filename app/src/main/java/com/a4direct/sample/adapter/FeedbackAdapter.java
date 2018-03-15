package com.a4direct.sample.adapter;

import android.view.ViewGroup;

import com.a4direct.blanket.adapter.BaseOnClickListener;
import com.a4direct.blanket.adapter.GenericPagedAdapter;
import com.a4direct.sample.R;
import com.a4direct.sample.model.Feedback;
import com.a4direct.sample.viewholder.FeedbackViewHolder;


/**
 * Created by Jyothi Asapu on 28-01-2018.
 */

public class FeedbackAdapter extends GenericPagedAdapter<Feedback, BaseOnClickListener<Feedback>, FeedbackViewHolder> {

    @Override
    public FeedbackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeedbackViewHolder(inflate(R.layout.feedback_list_item, parent));
    }

}
