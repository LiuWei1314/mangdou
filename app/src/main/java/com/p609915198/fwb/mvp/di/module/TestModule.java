package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.TestContract;
import com.p609915198.fwb.mvp.model.TestModel;


@Module
public class TestModule {
    private TestContract.View view;

    /**
     * 构建TestModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public TestModule(TestContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TestContract.View provideTestView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TestContract.Model provideTestModel(TestModel model) {
        return model;
    }
}