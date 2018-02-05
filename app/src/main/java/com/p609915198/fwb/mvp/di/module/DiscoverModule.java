package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.DiscoverContract;
import com.p609915198.fwb.mvp.model.DownloadModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-12.
 */
@Module
public class DiscoverModule {
    private DiscoverContract.View view;

    /**
     * 构建DownloadModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DiscoverModule(DiscoverContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    DiscoverContract.View provideDownloadView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    DiscoverContract.Model provideDownloadModel(DownloadModel model) {
        return model;
    }
}