package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.DowloadAllBuyContract;
import com.p609915198.fwb.mvp.model.DowloadAllBuyModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/2.
 */
@Module
public class DowloadAllBuyModule {
    private DowloadAllBuyContract.View view;

    /**
     * 构建DowloadAllBuyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DowloadAllBuyModule(DowloadAllBuyContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DowloadAllBuyContract.View provideDowloadAllBuyView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DowloadAllBuyContract.Model provideDowloadAllBuyModel(DowloadAllBuyModel model) {
        return model;
    }
}