package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.DialogScope;
import com.p609915198.fwb.mvp.contract.PlayBuyContract;
import com.p609915198.fwb.mvp.model.PlayBuyModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/2.
 */
@Module
public class PlayBuyModule {
    private PlayBuyContract.View view;

    /**
     * 构建PlayBuyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PlayBuyModule(PlayBuyContract.View view) {
        this.view = view;
    }

    @DialogScope
    @Provides
    PlayBuyContract.View providePlayBuyView() {
        return this.view;
    }

    @DialogScope
    @Provides
    PlayBuyContract.Model providePlayBuyModel(PlayBuyModel model) {
        return model;
    }
}