package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.AlreadyBuyModule;
import com.p609915198.fwb.mvp.ui.activity.AlreadyBuyActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/14.
 */
@ActivityScope
@Component(modules = AlreadyBuyModule.class, dependencies = BaseComponent.class)
public interface AlreadyBuyComponent {
    void inject(AlreadyBuyActivity activity);
}