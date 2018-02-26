package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.MyBuyContract;
import com.p609915198.fwb.mvp.model.MyBuyModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/2/26.
 */
@Module
public class MyBuyModule {
    private MyBuyContract.View view;

    /**
     * 构建MyBuyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyBuyModule(MyBuyContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MyBuyContract.View provideMyBuyView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MyBuyContract.Model provideMyBuyModel(MyBuyModel model) {
        return model;
    }
}