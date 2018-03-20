package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.VersionActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.VersionModule;

@ActivityScope
@Component(modules = VersionModule.class, dependencies = BaseComponent.class)
public interface VersionComponent {
    void inject(VersionActivity activity);
}