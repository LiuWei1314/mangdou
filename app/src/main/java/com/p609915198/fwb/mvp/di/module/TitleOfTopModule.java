package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.TitleOfTopContract;
import com.p609915198.fwb.mvp.model.TitleOfTopModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/4.
 */
@Module
public class TitleOfTopModule {
    private TitleOfTopContract.View view;

    /**
     * 构建TitleOfTopModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public TitleOfTopModule(TitleOfTopContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TitleOfTopContract.View provideTitleOfTopView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TitleOfTopContract.Model provideTitleOfTopModel(TitleOfTopModel model) {
        return model;
    }
}