package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.MineModule;
import com.p609915198.fwb.mvp.ui.fragment.MineFragment;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
@Component(modules = MineModule.class, dependencies = BaseComponent.class)
public interface MineComponent {
    void inject(MineFragment fragment);
}