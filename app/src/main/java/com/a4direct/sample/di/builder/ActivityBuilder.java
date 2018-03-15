package com.a4direct.sample.di.builder;

import com.a4direct.sample.InfoActivity;
import com.a4direct.sample.MainActivity;
import com.a4direct.sample.di.module.InfoActivityModule;
import com.a4direct.sample.di.module.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Jyothi Asapu on 26-02-2018.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            MainActivityModule.class
    })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {
            InfoActivityModule.class
    })
    abstract InfoActivity bindInfoActivity();
}
