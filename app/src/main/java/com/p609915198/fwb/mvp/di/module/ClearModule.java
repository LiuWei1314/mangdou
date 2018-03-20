package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.ClearContract;
import com.p609915198.fwb.mvp.model.ClearModel;


@Module
public class ClearModule {
    private ClearContract.View view;

    /**
     * 构建ClearModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ClearModule(ClearContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ClearContract.View provideClearView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ClearContract.Model provideClearModel(ClearModel model) {
        return model;
    }
}