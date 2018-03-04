package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.MyWalletModule;
import com.p609915198.fwb.mvp.ui.activity.MyWalletActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
@Component(modules = MyWalletModule.class, dependencies = BaseComponent.class)
public interface MyWalletComponent {
    void inject(MyWalletActivity activity);
}