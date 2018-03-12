package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.TestActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.TestModule;

@ActivityScope
@Component(modules = TestModule.class, dependencies = BaseComponent.class)
public interface TestComponent {
    void inject(TestActivity activity);
}