package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.AnchorMoreContract;
import com.p609915198.fwb.mvp.model.AnchorMoreModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/9.
 */
@Module
public class AnchorMoreModule {
    private AnchorMoreContract.View view;

    /**
     * 构建AnchorMoreModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AnchorMoreModule(AnchorMoreContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AnchorMoreContract.View provideAnchorMoreView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AnchorMoreContract.Model provideAnchorMoreModel(AnchorMoreModel model) {
        return model;
    }
}