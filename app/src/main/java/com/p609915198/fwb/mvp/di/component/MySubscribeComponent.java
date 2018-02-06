package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.MySubscribeModule;
import com.p609915198.fwb.mvp.ui.activity.MySubscribeActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/2/6.
 */
@ActivityScope
@Component(modules = MySubscribeModule.class, dependencies = BaseComponent.class)
public interface MySubscribeComponent {
    void inject(MySubscribeActivity activity);
}