package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ListBuyContract;
import com.p609915198.fwb.mvp.model.ListBuyModel;

import dagger.Module;
import dagger.Provides;


@Module
public class ListBuyModule {
    private ListBuyContract.View view;

    /**
     * 构建ListBuyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ListBuyModule(ListBuyContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ListBuyContract.View provideListBuyView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ListBuyContract.Model provideListBuyModel(ListBuyModel model) {
        return model;
    }
}