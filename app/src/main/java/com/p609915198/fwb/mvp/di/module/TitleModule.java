package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.TitleContract;
import com.p609915198.fwb.mvp.model.TitleModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/4.
 */
@Module
public class TitleModule {
    private TitleContract.View view;

    /**
     * 构建TitleModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public TitleModule(TitleContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TitleContract.View provideTitleView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TitleContract.Model provideTitleModel(TitleModel model) {
        return model;
    }
}