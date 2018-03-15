package com.a4direct.sample.di.builder;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.a4direct.sample.di.ViewModelKey;
import com.a4direct.sample.viewmodel.FeedbackListViewModel;
import com.a4direct.sample.viewmodel.FeedbackViewModel;
import com.a4direct.sample.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Jyothi Asapu on 10-03-2018.
 */

@Module
public abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(FeedbackListViewModel.class)
    abstract ViewModel bindFeedbackListViewModel(FeedbackListViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FeedbackViewModel.class)
    abstract ViewModel bindFeedbackViewModel(FeedbackViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
