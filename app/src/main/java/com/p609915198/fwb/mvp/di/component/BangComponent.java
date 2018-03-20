package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.BangActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.BangModule;

@ActivityScope
@Component(modules = BangModule.class, dependencies = BaseComponent.class)
public interface BangComponent {
    void inject(BangActivity activity);
}