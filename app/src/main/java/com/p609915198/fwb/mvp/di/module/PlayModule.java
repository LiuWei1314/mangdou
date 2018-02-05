package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.PlayContract;
import com.p609915198.fwb.mvp.model.PlayModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
@Module
public class PlayModule {
    private PlayContract.View view;

    /**
     * 构建PlayModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PlayModule(PlayContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PlayContract.View providePlayView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PlayContract.Model providePlayModel(PlayModel model) {
        return model;
    }
}