package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.PlayRecordModule;
import com.p609915198.fwb.mvp.ui.activity.PlayRecordActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/7.
 */
@ActivityScope
@Component(modules = PlayRecordModule.class, dependencies = BaseComponent.class)
public interface PlayRecordComponent {
    void inject(PlayRecordActivity activity);
}