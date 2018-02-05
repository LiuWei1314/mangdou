package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.GeneralSettingsModule;
import com.p609915198.fwb.mvp.ui.activity.GeneralSettingsActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/4 0004.
 */
@ActivityScope
@Component(modules = GeneralSettingsModule.class, dependencies = BaseComponent.class)
public interface GeneralSettingsComponent {
    void inject(GeneralSettingsActivity activity);
}