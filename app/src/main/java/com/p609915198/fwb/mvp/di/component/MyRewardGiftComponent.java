package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.ui.fragment.MyRewardGiftFragment;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.MyRewardGiftModule;

@FragmentScope
@Component(modules = MyRewardGiftModule.class, dependencies = BaseComponent.class)
public interface MyRewardGiftComponent {
    void inject(MyRewardGiftFragment fragment);
}