package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.FeedBackActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.FeedBackModule;

@ActivityScope
@Component(modules = FeedBackModule.class, dependencies = BaseComponent.class)
public interface FeedBackComponent {
    void inject(FeedBackActivity activity);
}