package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.ListDownloadContract;
import com.p609915198.fwb.mvp.model.ListDownloadModel;


@Module
public class ListDownloadModule {
    private ListDownloadContract.View view;

    /**
     * 构建ListDownloadModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ListDownloadModule(ListDownloadContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ListDownloadContract.View provideListDownloadView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ListDownloadContract.Model provideListDownloadModel(ListDownloadModel model) {
        return model;
    }
}