package com.a4direct.sample.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.a4direct.blanket.adapter.BaseHolder;
import com.a4direct.blanket.adapter.BaseOnClickListener;
import com.a4direct.sample.R;
import com.a4direct.sample.model.Feedback;


/**
 * Created by Jyothi Asapu on 28-01-2018.
 */

public class FeedbackViewHolder extends BaseHolder<Feedback, BaseOnClickListener<Feedback>> {

    public TextView mFeedbackTitle;
    public TextView mFeedbackBy;
    public TextView mFeedbackDescription;

    public FeedbackViewHolder(View itemView) {
        super(itemView);

        mFeedbackTitle = (TextView) itemView.findViewById(R.id.feedback_title);
        mFeedbackBy = (TextView) itemView.findViewById(R.id.feedback_provided_by);
        mFeedbackDescription = (TextView) itemView.findViewById(R.id.feedback_description);
    }

    @Override
    public void bindItem(final Feedback item, final @Nullable BaseOnClickListener<Feedback> listener) {
        mFeedbackTitle.setText(item.getTitle());
        mFeedbackBy.setText(item.getFeedback_by());
        mFeedbackDescription.setText(item.getDescription());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener == null) {
                    return;
                }

                listener.onItemClicked(item);
            }
        });
    }

    @Override
    public void clear() {
        mFeedbackTitle.setText("");
        mFeedbackBy.setText("");
        mFeedbackDescription.setText("");
    }
}
