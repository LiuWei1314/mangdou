package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.VersionContract;
import com.p609915198.fwb.mvp.model.VersionModel;


@Module
public class VersionModule {
    private VersionContract.View view;

    /**
     * 构建VersionModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public VersionModule(VersionContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    VersionContract.View provideVersionView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    VersionContract.Model provideVersionModel(VersionModel model) {
        return model;
    }
}