package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.TitleModule;
import com.p609915198.fwb.mvp.ui.activity.TitleActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
@Component(modules = TitleModule.class, dependencies = BaseComponent.class)
public interface TitleComponent {
    void inject(TitleActivity activity);
}