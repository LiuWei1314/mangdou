package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.SplashModule;
import com.p609915198.fwb.mvp.ui.activity.SplashActivity;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-12.
 */
@ActivityScope
@Component(modules = SplashModule.class, dependencies = BaseComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}