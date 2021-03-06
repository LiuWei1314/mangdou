package com.p609915198.fwb.mvp.di.module;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ChargeFlowContract;
import com.p609915198.fwb.mvp.model.ChargeFlowModel;

import dagger.Module;
import dagger.Provides;


@Module
public class ChargeFlowModule {
    private ChargeFlowContract.View view;

    /**
     * 构建ChargeFlowModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ChargeFlowModule(ChargeFlowContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ChargeFlowContract.View provideChargeFlowView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ChargeFlowContract.Model provideChargeFlowModel(ChargeFlowModel model) {
        return model;
    }
}