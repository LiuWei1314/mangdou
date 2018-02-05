package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.HomePageContract;
import com.p609915198.fwb.mvp.model.HomePageModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-12.
 */
@Module
public class HomePageModule {
    private HomePageContract.View view;

    /**
     * 构建HomePageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HomePageModule(HomePageContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HomePageContract.View provideHomePageView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HomePageContract.Model provideHomePageModel(HomePageModel model) {
        return model;
    }
}