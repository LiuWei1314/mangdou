package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.HomePageModule;
import com.p609915198.fwb.mvp.ui.fragment.HomePageFragment;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
@Component(modules = HomePageModule.class, dependencies = BaseComponent.class)
public interface HomePageComponent {
    void inject(HomePageFragment fragment);
}