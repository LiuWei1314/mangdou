package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.MyFileModule;
import com.p609915198.fwb.mvp.ui.activity.MyFileActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/2.
 */
@ActivityScope
@Component(modules = MyFileModule.class, dependencies = BaseComponent.class)
public interface MyFileComponent {
    void inject(MyFileActivity activity);
}