package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.AboutUsActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.AboutUsModule;

@ActivityScope
@Component(modules = AboutUsModule.class, dependencies = BaseComponent.class)
public interface AboutUsComponent {
    void inject(AboutUsActivity activity);
}