package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ForgetPasswordContract;
import com.p609915198.fwb.mvp.model.ForgetPasswordModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
@Module
public class ForgetPasswordModule {
    private ForgetPasswordContract.View view;

    /**
     * 构建FrogetPasswordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ForgetPasswordModule(ForgetPasswordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ForgetPasswordContract.View provideFrogetPasswordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ForgetPasswordContract.Model provideFrogetPasswordModel(ForgetPasswordModel model) {
        return model;
    }
}