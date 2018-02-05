package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.ClassifyDetailModule;
import com.p609915198.fwb.mvp.ui.activity.ClassifyDetailActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/14.
 */
@ActivityScope
@Component(modules = ClassifyDetailModule.class, dependencies = BaseComponent.class)
public interface ClassifyDetailComponent {
    void inject(ClassifyDetailActivity activity);
}