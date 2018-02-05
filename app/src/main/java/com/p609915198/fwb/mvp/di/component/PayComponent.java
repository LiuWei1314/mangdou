package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.PayModule;
import com.p609915198.fwb.mvp.ui.activity.PayActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/30.
 */
@ActivityScope
@Component(modules = PayModule.class, dependencies = BaseComponent.class)
public interface PayComponent {
    void inject(PayActivity activity);
}