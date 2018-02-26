package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.MyBuyModule;
import com.p609915198.fwb.mvp.ui.activity.MyBuyActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/2/26.
 */
@ActivityScope
@Component(modules = MyBuyModule.class, dependencies = BaseComponent.class)
public interface MyBuyComponent {
    void inject(MyBuyActivity activity);
}