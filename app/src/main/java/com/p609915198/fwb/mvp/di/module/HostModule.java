package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.HostContract;
import com.p609915198.fwb.mvp.model.HostModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-15.
 */
@Module
public class HostModule {
    private HostContract.View view;

    /**
     * 构建HostModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HostModule(HostContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HostContract.View provideHostView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HostContract.Model provideHostModel(HostModel model) {
        return model;
    }
}