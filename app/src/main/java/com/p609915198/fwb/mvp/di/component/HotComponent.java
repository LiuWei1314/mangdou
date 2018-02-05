package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.HotModule;
import com.p609915198.fwb.mvp.ui.fragment.HotFragment;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
@Component(modules = HotModule.class, dependencies = BaseComponent.class)
public interface HotComponent {
    void inject(HotFragment fragment);
}