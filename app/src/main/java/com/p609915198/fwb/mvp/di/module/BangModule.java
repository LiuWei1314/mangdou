package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.BangContract;
import com.p609915198.fwb.mvp.model.BangModel;


@Module
public class BangModule {
    private BangContract.View view;

    /**
     * 构建BangModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BangModule(BangContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BangContract.View provideBangView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BangContract.Model provideBangModel(BangModel model) {
        return model;
    }
}