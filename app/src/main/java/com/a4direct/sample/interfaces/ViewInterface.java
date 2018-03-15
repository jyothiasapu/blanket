package com.a4direct.sample.interfaces;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jyothi Asapu on 15-12-2017.
 */

public interface ViewInterface {

	public int getTitleResource();

	public void initializeViewModel(AppCompatActivity act, ViewModelProvider.Factory factory);

	public int getFabIcon();

	public void fabAction(View view);

}
