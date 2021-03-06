package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.RoomsMoreModule;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/9.
 */
@ActivityScope
@Component(modules = RoomsMoreModule.class, dependencies = BaseComponent.class)
public interface RoomsMoreComponent {
    void inject(RoomsMoreActivity activity);
}