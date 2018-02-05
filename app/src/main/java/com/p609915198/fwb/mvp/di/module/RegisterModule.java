package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.RegisterContract;
import com.p609915198.fwb.mvp.model.RegisterModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/30.
 */
@Module
public class RegisterModule {
    private RegisterContract.View view;

    /**
     * 构建RegisterModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RegisterModule(RegisterContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RegisterContract.View provideRegisterView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RegisterContract.Model provideRegisterModel(RegisterModel model) {
        return model;
    }
}