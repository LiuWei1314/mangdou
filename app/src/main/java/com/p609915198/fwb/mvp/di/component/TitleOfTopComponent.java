package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.TitleOfTopModule;
import com.p609915198.fwb.mvp.ui.activity.TitleOfTopActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/4.
 */
@ActivityScope
@Component(modules = TitleOfTopModule.class, dependencies = BaseComponent.class)
public interface TitleOfTopComponent {
    void inject(TitleOfTopActivity activity);
}