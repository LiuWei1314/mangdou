package com.p609915198.basemodule.base;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.p609915198.basemodule.BuildConfig;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.di.component.DaggerBaseComponent;
import com.p609915198.basemodule.di.module.ApiModule;
import com.p609915198.basemodule.di.module.BaseModule;

/**
 * Created by mark.liu on 2017-5-9.
 */
public class BaseApplication extends Application {
    private static BaseComponent mBaseComponent;
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        initBaseComponent();
    }

    private void initBaseComponent() {
        mBaseComponent = DaggerBaseComponent
                .builder()
                // 提供application
                .baseModule(new BaseModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public static BaseComponent getBaseComponent() {
        return mBaseComponent;
    }

    /**
     * 返回上下文
     */
    public static Context getContext() {
        return mApplication;
    }
}
