package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.MyRewardGiftContract;
import com.p609915198.fwb.mvp.model.MyRewardGiftModel;


@Module
public class MyRewardGiftModule {
    private MyRewardGiftContract.View view;

    /**
     * 构建MyRewardGiftModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyRewardGiftModule(MyRewardGiftContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyRewardGiftContract.View provideMyRewardGiftView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MyRewardGiftContract.Model provideMyRewardGiftModel(MyRewardGiftModel model) {
        return model;
    }
}