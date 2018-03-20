package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.ClearActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.ClearModule;

@ActivityScope
@Component(modules = ClearModule.class, dependencies = BaseComponent.class)
public interface ClearComponent {
    void inject(ClearActivity activity);
}