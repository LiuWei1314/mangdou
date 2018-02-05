package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.AnchorMoreModule;
import com.p609915198.fwb.mvp.ui.activity.AnchorMoreActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/9.
 */
@ActivityScope
@Component(modules = AnchorMoreModule.class, dependencies = BaseComponent.class)
public interface AnchorMoreComponent {
    void inject(AnchorMoreActivity activity);
}