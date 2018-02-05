package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.PlayListContract;
import com.p609915198.fwb.mvp.model.PlayListModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/25.
 */
@Module
public class PlayListModule {
    private PlayListContract.View view;

    /**
     * 构建PlayListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PlayListModule(PlayListContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    PlayListContract.View providePlayListView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    PlayListContract.Model providePlayListModel(PlayListModel model) {
        return model;
    }
}