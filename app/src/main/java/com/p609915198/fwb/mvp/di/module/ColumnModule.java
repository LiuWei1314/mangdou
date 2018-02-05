package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ColumnContract;
import com.p609915198.fwb.mvp.model.ColumnModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@Module
public class ColumnModule {
    private ColumnContract.View view;

    /**
     * 构建ColumnModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ColumnModule(ColumnContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ColumnContract.View provideColumnView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ColumnContract.Model provideColumnModel(ColumnModel model) {
        return model;
    }
}