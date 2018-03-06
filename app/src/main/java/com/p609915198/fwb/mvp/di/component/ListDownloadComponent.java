package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.ui.activity.ListDownloadActivity;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.ListDownloadModule;

@ActivityScope
@Component(modules = ListDownloadModule.class, dependencies = BaseComponent.class)
public interface ListDownloadComponent {
    void inject(ListDownloadActivity activity);
}