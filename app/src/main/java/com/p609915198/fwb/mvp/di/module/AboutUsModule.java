package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.AboutUsContract;
import com.p609915198.fwb.mvp.model.AboutUsModel;


@Module
public class AboutUsModule {
    private AboutUsContract.View view;

    /**
     * 构建AboutUsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AboutUsModule(AboutUsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AboutUsContract.View provideAboutUsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AboutUsContract.Model provideAboutUsModel(AboutUsModel model) {
        return model;
    }
}