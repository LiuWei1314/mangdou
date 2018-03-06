package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.MyRewardModule;
import com.p609915198.fwb.mvp.ui.fragment.MyRewardFragment;

import dagger.Component;

@FragmentScope
@Component(modules = MyRewardModule.class, dependencies = BaseComponent.class)
public interface MyRewardComponent {
    void inject(MyRewardFragment fragment);
}