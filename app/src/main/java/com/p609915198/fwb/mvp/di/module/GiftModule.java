package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.GiftContract;
import com.p609915198.fwb.mvp.model.GiftModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/4.
 */
@Module
public class GiftModule {
    private GiftContract.View view;

    /**
     * 构建GiftModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public GiftModule(GiftContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    GiftContract.View provideGiftView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    GiftContract.Model provideGiftModel(GiftModel model) {
        return model;
    }
}