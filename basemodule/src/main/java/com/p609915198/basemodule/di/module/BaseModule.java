package com.p609915198.basemodule.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 基础Module
 * Created by mark.liu on 2017-5-8.
 */
@Module
public class BaseModule {
    private Application mApplication;

    public BaseModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }
}
