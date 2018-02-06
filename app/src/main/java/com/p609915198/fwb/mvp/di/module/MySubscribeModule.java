package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.MySubscribeContract;
import com.p609915198.fwb.mvp.model.MySubscribeModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/2/6.
 */
@Module
public class MySubscribeModule {
    private MySubscribeContract.View view;

    /**
     * 构建MySubscribeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MySubscribeModule(MySubscribeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MySubscribeContract.View provideMySubscribeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MySubscribeContract.Model provideMySubscribeModel(MySubscribeModel model) {
        return model;
    }
}