package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.UserInfoContract;
import com.p609915198.fwb.mvp.model.UserInfoModel;


@Module
public class UserInfoModule {
    private UserInfoContract.View view;

    /**
     * 构建UserInfoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public UserInfoModule(UserInfoContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserInfoContract.View provideUserInfoView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    UserInfoContract.Model provideUserInfoModel(UserInfoModel model) {
        return model;
    }
}