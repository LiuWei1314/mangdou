package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.NameModule;
import com.p609915198.fwb.mvp.ui.activity.NameActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
@Component(modules = NameModule.class, dependencies = BaseComponent.class)
public interface NameComponent {
    void inject(NameActivity activity);
}