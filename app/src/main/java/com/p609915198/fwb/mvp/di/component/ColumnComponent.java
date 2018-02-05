package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.ColumnModule;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;

import dagger.Component;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@ActivityScope
@Component(modules = ColumnModule.class, dependencies = BaseComponent.class)
public interface ColumnComponent {
    void inject(ColumnActivity activity);
}