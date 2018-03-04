package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.RewardModule;
import com.p609915198.fwb.mvp.ui.activity.RewardActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
@Component(modules = RewardModule.class, dependencies = BaseComponent.class)
public interface RewardComponent {
    void inject(RewardActivity activity);
}