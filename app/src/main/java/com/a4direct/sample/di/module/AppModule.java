package com.a4direct.sample.di.module;

import com.a4direct.sample.di.builder.ViewModelBuilder;

import dagger.Module;

/**
 * Created by Jyothi Asapu on 26-02-2018.
 */

@Module(includes = {ContextModule.class, DatabaseModule.class,
        ExecutorModule.class, ViewModelBuilder.class,
        MainActivityModule.class, InfoActivityModule.class})
public class AppModule {

}
