package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.LoginModule;
import com.p609915198.fwb.mvp.ui.activity.LoginActivity;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-12.
 */
@ActivityScope
@Component(modules = LoginModule.class, dependencies = BaseComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}