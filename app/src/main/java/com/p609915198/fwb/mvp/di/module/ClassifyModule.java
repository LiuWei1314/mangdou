package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.ClassifyContract;
import com.p609915198.fwb.mvp.model.ClassifyModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-12.
 */
@Module
public class ClassifyModule {
    private ClassifyContract.View view;

    /**
     * 构建Type2Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ClassifyModule(ClassifyContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    ClassifyContract.View provideType2View() {
        return this.view;
    }

    @FragmentScope
    @Provides
    ClassifyContract.Model provideType2Model(ClassifyModel model) {
        return model;
    }
}