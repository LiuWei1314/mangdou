package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.AnchorDetailContract;
import com.p609915198.fwb.mvp.model.AnchorDetailModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/10.
 */
@Module
public class AnchorDetailModule {
    private AnchorDetailContract.View view;

    /**
     * 构建AnchorDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AnchorDetailModule(AnchorDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AnchorDetailContract.View provideAnchorDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AnchorDetailContract.Model provideAnchorDetailModel(AnchorDetailModel model) {
        return model;
    }
}