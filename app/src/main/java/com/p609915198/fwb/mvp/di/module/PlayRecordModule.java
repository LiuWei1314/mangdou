package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.PlayRecordContract;
import com.p609915198.fwb.mvp.model.PlayRecordModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/7.
 */
@Module
public class PlayRecordModule {
    private PlayRecordContract.View view;

    /**
     * 构建PlayRecordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PlayRecordModule(PlayRecordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PlayRecordContract.View providePlayRecordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PlayRecordContract.Model providePlayRecordModel(PlayRecordModel model) {
        return model;
    }
}