package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.MyRewardContract;
import com.p609915198.fwb.mvp.model.MyRewardModel;


@Module
public class MyRewardModule {
    private MyRewardContract.View view;

    /**
     * 构建MyRewardModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyRewardModule(MyRewardContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyRewardContract.View provideMyRewardView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MyRewardContract.Model provideMyRewardModel(MyRewardModel model) {
        return model;
    }
}