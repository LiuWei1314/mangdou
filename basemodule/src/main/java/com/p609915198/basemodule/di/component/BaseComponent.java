package com.p609915198.basemodule.di.component;

import android.app.Application;

import com.p609915198.basemodule.di.module.ApiModule;
import com.p609915198.basemodule.di.module.BaseModule;
import com.p609915198.basemodule.net.Api;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mark on 2017/05/08.
 */
@Singleton
@Component(modules = {BaseModule.class, ApiModule.class})
public interface BaseComponent {
    Application application();

    // 网络请求
    Api api();
}
