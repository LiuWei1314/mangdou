package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.HistoryContract;
import com.p609915198.fwb.mvp.model.HistoryModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/2/6.
 */
@Module
public class HistoryModule {
    private HistoryContract.View view;

    /**
     * 构建HistoryModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HistoryModule(HistoryContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HistoryContract.View provideHistoryView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HistoryContract.Model provideHistoryModel(HistoryModel model) {
        return model;
    }
}