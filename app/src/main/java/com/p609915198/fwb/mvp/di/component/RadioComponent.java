package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.di.module.RadioModule;
import com.p609915198.fwb.mvp.ui.fragment.RadioFragment;

import dagger.Component;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
@Component(modules = RadioModule.class, dependencies = BaseComponent.class)
public interface RadioComponent {
    void inject(RadioFragment fragment);
}