package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.MyReceiveRewardContract;
import com.p609915198.fwb.mvp.model.MyReceiveRewardModel;


@Module
public class MyReceiveRewardModule {
    private MyReceiveRewardContract.View view;

    /**
     * 构建MyReceiveRewardModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyReceiveRewardModule(MyReceiveRewardContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyReceiveRewardContract.View provideMyReceiveRewardView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MyReceiveRewardContract.Model provideMyReceiveRewardModel(MyReceiveRewardModel model) {
        return model;
    }
}