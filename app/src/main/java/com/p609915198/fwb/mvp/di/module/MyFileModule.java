package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.MyFileContract;
import com.p609915198.fwb.mvp.model.MyFileModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/2.
 */
@Module
public class MyFileModule {
    private MyFileContract.View view;

    /**
     * 构建MyFileModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyFileModule(MyFileContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MyFileContract.View provideMyFileView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MyFileContract.Model provideMyFileModel(MyFileModel model) {
        return model;
    }
}