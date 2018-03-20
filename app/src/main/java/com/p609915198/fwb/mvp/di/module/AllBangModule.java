package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.p609915198.fwb.mvp.contract.AllBangContract;
import com.p609915198.fwb.mvp.model.AllBangModel;


@Module
public class AllBangModule {
    private AllBangContract.View view;

    /**
     * 构建AllBangModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AllBangModule(AllBangContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    AllBangContract.View provideAllBangView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    AllBangContract.Model provideAllBangModel(AllBangModel model) {
        return model;
    }
}