package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.ui.fragment.HostBangFragment;

import dagger.Component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.fwb.mvp.di.module.HostBangModule;

@FragmentScope
@Component(modules = HostBangModule.class, dependencies = BaseComponent.class)
public interface HostBangComponent {
    void inject(HostBangFragment fragment);
}