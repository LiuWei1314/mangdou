package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.ui.fragment.MyGiftFragment;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.MyGiftModule;

@FragmentScope
@Component(modules = MyGiftModule.class, dependencies = BaseComponent.class)
public interface MyGiftComponent {
    void inject(MyGiftFragment fragment);
}