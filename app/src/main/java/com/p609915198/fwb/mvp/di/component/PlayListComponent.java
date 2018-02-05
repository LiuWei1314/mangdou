package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.PlayListModule;
import com.p609915198.fwb.mvp.ui.fragment.PlayListFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/25.
 */
@FragmentScope
@Component(modules = PlayListModule.class, dependencies = BaseComponent.class)
public interface PlayListComponent {
    void inject(PlayListFragment fragment);
}