package com.p609915198.fwb.mvp.di.component;

import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.scope.DialogScope;
import com.p609915198.fwb.mvp.di.module.PlayBuyModule;
import com.p609915198.fwb.mvp.ui.dialog.PlayBuyDialog;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/2.
 */
@DialogScope
@Component(modules = PlayBuyModule.class, dependencies = BaseComponent.class)
public interface PlayBuyComponent {
    void inject(PlayBuyDialog dialog);
}