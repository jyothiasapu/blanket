package com.a4direct.sample.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

/**
 * Created by Jyothi Asapu on 19-12-2017.
 */

public abstract class BaseConstraintLayout extends ConstraintLayout {

    public BaseConstraintLayout(Context context) {
        this(context, null);
    }

    public BaseConstraintLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void onInflateComplete();

    public abstract void onWindowDetached();

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        onInflateComplete();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        onWindowDetached();
    }

}
