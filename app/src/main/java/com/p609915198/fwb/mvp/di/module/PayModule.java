package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.PayContract;
import com.p609915198.fwb.mvp.model.PayModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/30.
 */
@Module
public class PayModule {
    private PayContract.View view;

    /**
     * 构建PayModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PayModule(PayContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PayContract.View providePayView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PayContract.Model providePayModel(PayModel model) {
        return model;
    }
}