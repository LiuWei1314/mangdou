package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.ForgetPasswordModule;
import com.p609915198.fwb.mvp.ui.activity.ForgetPasswordActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
@ActivityScope
@Component(modules = ForgetPasswordModule.class, dependencies = BaseComponent.class)
public interface ForgetPasswordComponent {
    void inject(ForgetPasswordActivity activity);
}