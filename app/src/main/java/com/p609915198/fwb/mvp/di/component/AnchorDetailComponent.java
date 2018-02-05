package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.AnchorDetailModule;
import com.p609915198.fwb.mvp.ui.activity.AnchorDetailActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/10.
 */
@ActivityScope
@Component(modules = AnchorDetailModule.class, dependencies = BaseComponent.class)
public interface AnchorDetailComponent {
    void inject(AnchorDetailActivity activity);
}