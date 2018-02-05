package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.SetPasswordContract;
import com.p609915198.fwb.mvp.model.SetPasswordModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/6.
 */
@Module
public class SetPasswordModule {
    private SetPasswordContract.View view;

    /**
     * 构建SetPasswordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SetPasswordModule(SetPasswordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SetPasswordContract.View provideSetPasswordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SetPasswordContract.Model provideSetPasswordModel(SetPasswordModel model) {
        return model;
    }
}