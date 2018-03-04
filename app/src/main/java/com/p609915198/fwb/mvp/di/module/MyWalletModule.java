package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.MyWalletContract;
import com.p609915198.fwb.mvp.model.MyWalletModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/4.
 */
@Module
public class MyWalletModule {
    private MyWalletContract.View view;

    /**
     * 构建MyWalletModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyWalletModule(MyWalletContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MyWalletContract.View provideMyWalletView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MyWalletContract.Model provideMyWalletModel(MyWalletModel model) {
        return model;
    }
}