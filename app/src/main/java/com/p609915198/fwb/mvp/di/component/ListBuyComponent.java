package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.ListBuyModule;
import com.p609915198.fwb.mvp.ui.activity.ListBuyActivity;

import dagger.Component;


@ActivityScope
@Component(modules = ListBuyModule.class, dependencies = BaseComponent.class)
public interface ListBuyComponent {
    void inject(ListBuyActivity activity);
}