package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.BulkBuyContract;
import com.p609915198.fwb.mvp.model.BulkBuyModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/2.
 */
@Module
public class BulkBuyModule {
    private BulkBuyContract.View view;

    /**
     * 构建BulkBuyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BulkBuyModule(BulkBuyContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BulkBuyContract.View provideBulkBuyView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BulkBuyContract.Model provideBulkBuyModel(BulkBuyModel model) {
        return model;
    }
}