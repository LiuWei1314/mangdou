package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.HistoryModule;
import com.p609915198.fwb.mvp.ui.activity.HistoryActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/2/6.
 */
@ActivityScope
@Component(modules = HistoryModule.class, dependencies = BaseComponent.class)
public interface HistoryComponent {
    void inject(HistoryActivity activity);
}