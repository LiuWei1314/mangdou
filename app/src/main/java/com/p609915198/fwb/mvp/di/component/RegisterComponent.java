package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.RegisterModule;
import com.p609915198.fwb.mvp.ui.activity.RegisterActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/30.
 */
@ActivityScope
@Component(modules = RegisterModule.class, dependencies = BaseComponent.class)
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}