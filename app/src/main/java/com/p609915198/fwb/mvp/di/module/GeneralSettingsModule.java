package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.GeneralSettingsContract;
import com.p609915198.fwb.mvp.model.GeneralSettingsModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/4 0004.
 */
@Module
public class GeneralSettingsModule {
    private GeneralSettingsContract.View view;

    /**
     * 构建GeneralSettingsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public GeneralSettingsModule(GeneralSettingsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    GeneralSettingsContract.View provideGeneralSettingsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    GeneralSettingsContract.Model provideGeneralSettingsModel(GeneralSettingsModel model) {
        return model;
    }
}