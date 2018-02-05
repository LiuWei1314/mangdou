package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ForgetPassword2Contract;
import com.p609915198.fwb.mvp.model.ForgetPassword2Model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/6.
 */
@Module
public class ForgetPassword2Module {
    private ForgetPassword2Contract.View view;

    /**
     * 构建ForgetPassword2Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ForgetPassword2Module(ForgetPassword2Contract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ForgetPassword2Contract.View provideForgetPassword2View() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ForgetPassword2Contract.Model provideForgetPassword2Model(ForgetPassword2Model model) {
        return model;
    }
}