package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.di.module.MyDownloadModule;
import com.p609915198.fwb.mvp.ui.activity.MyDownloadActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/2/26.
 */
@ActivityScope
@Component(modules = MyDownloadModule.class, dependencies = BaseComponent.class)
public interface MyDownloadComponent {
    void inject(MyDownloadActivity activity);
}