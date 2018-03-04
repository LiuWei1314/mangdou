package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.GiftModule;
import com.p609915198.fwb.mvp.ui.activity.GiftActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
@Component(modules = GiftModule.class, dependencies = BaseComponent.class)
public interface GiftComponent {
    void inject(GiftActivity activity);
}