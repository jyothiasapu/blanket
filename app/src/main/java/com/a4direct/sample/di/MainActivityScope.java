package com.a4direct.sample.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jyothi Asapu on 26-02-2018.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface MainActivityScope {
}
