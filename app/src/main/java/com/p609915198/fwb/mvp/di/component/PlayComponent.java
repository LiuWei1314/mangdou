package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.PlayModule;
import com.p609915198.fwb.mvp.ui.activity.PlayActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
@ActivityScope
@Component(modules = PlayModule.class, dependencies = BaseComponent.class)
public interface PlayComponent {
    void inject(PlayActivity activity);
}