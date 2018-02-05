package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.ListenContract;
import com.p609915198.fwb.mvp.model.ListenModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-12.
 */
@Module
public class ListenModule {
    private ListenContract.View view;

    /**
     * 构建ListenModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ListenModule(ListenContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    ListenContract.View provideListenView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    ListenContract.Model provideListenModel(ListenModel model) {
        return model;
    }
}