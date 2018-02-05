package com.p609915198.fwb.mvp.di.component;


import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.VoiceModule;
import com.p609915198.fwb.mvp.ui.activity.VoiceActivity;

import dagger.Component;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@ActivityScope
@Component(modules = VoiceModule.class, dependencies = BaseComponent.class)
public interface VoiceComponent {
    void inject(VoiceActivity activity);
}