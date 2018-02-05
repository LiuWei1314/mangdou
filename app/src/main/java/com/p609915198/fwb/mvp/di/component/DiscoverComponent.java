package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.DiscoverModule;
import com.p609915198.fwb.mvp.ui.fragment.DiscoverFragment;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
@Component(modules = DiscoverModule.class, dependencies = BaseComponent.class)
public interface DiscoverComponent {
    void inject(DiscoverFragment fragment);
}