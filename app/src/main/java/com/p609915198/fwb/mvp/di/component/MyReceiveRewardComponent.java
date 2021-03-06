package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.ui.fragment.MyReceiveRewardFragment;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.MyReceiveRewardModule;

@FragmentScope
@Component(modules = MyReceiveRewardModule.class, dependencies = BaseComponent.class)
public interface MyReceiveRewardComponent {
    void inject(MyReceiveRewardFragment fragment);
}