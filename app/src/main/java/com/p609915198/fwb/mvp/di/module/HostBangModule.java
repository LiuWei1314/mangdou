package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.HostBangContract;
import com.p609915198.fwb.mvp.model.HostBangModel;


@Module
public class HostBangModule {
    private HostBangContract.View view;

    /**
     * 构建HostBangModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HostBangModule(HostBangContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HostBangContract.View provideHostBangView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HostBangContract.Model provideHostBangModel(HostBangModel model) {
        return model;
    }
}