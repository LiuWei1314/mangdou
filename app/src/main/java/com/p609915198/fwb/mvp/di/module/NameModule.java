package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.NameContract;
import com.p609915198.fwb.mvp.model.NameModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/6.
 */
@Module
public class NameModule {
    private NameContract.View view;

    /**
     * 构建NameModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NameModule(NameContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    NameContract.View provideNameView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    NameContract.Model provideNameModel(NameModel model) {
        return model;
    }
}