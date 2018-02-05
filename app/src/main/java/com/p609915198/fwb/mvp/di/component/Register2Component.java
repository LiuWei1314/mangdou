package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.Register2Module;
import com.p609915198.fwb.mvp.ui.activity.Register2Activity;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
@Component(modules = Register2Module.class, dependencies = BaseComponent.class)
public interface Register2Component {
    void inject(Register2Activity activity);
}