package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.HotContract;
import com.p609915198.fwb.mvp.model.HotModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-12.
 */
@Module
public class HotModule {
    private HotContract.View view;

    /**
     * 构建Type1Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HotModule(HotContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HotContract.View provideType1View() {
        return this.view;
    }

    @FragmentScope
    @Provides
    HotContract.Model provideType1Model(HotModel model) {
        return model;
    }
}