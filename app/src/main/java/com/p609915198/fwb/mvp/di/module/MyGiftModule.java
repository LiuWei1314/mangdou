package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.MyGiftContract;
import com.p609915198.fwb.mvp.model.MyGiftModel;


@Module
public class MyGiftModule {
    private MyGiftContract.View view;

    /**
     * 构建MyGiftModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyGiftModule(MyGiftContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyGiftContract.View provideMyGiftView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MyGiftContract.Model provideMyGiftModel(MyGiftModel model) {
        return model;
    }
}