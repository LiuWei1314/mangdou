package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.MyDownloadContract;
import com.p609915198.fwb.mvp.model.MyDownloadModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/2/26.
 */
@Module
public class MyDownloadModule {
    private MyDownloadContract.View view;

    /**
     * 构建MyDownloadModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyDownloadModule(MyDownloadContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MyDownloadContract.View provideMyDownloadView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MyDownloadContract.Model provideMyDownloadModel(MyDownloadModel model) {
        return model;
    }
}