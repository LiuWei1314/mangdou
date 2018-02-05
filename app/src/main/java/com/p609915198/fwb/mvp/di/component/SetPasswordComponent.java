package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.SetPasswordModule;
import com.p609915198.fwb.mvp.ui.activity.SetPasswordActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
@Component(modules = SetPasswordModule.class, dependencies = BaseComponent.class)
public interface SetPasswordComponent {
    void inject(SetPasswordActivity activity);
}