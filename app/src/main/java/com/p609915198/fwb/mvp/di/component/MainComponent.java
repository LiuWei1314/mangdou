package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.MainModule;
import com.p609915198.fwb.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by mark.liu on 2017-8-22.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = BaseComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}