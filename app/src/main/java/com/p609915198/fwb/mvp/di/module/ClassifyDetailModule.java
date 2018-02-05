package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.ClassifyDetailContract;
import com.p609915198.fwb.mvp.model.ClassifyDetailModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/14.
 */
@Module
public class ClassifyDetailModule {
    private ClassifyDetailContract.View view;

    /**
     * 构建ClassifyDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ClassifyDetailModule(ClassifyDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ClassifyDetailContract.View provideClassifyDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ClassifyDetailContract.Model provideClassifyDetailModel(ClassifyDetailModel model) {
        return model;
    }
}