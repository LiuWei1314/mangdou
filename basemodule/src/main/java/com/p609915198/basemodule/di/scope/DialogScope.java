package com.p609915198.basemodule.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by mark.liu on 2017-8-8.
 */
@Scope
@Retention(RUNTIME)
public @interface DialogScope {}
