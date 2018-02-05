package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.RadioContract;
import com.p609915198.fwb.mvp.model.RadioModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mark.liu on 2017-9-15.
 */
@Module
public class RadioModule {
    private RadioContract.View view;

    /**
     * 构建RadioModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RadioModule(RadioContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    RadioContract.View provideRadioView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    RadioContract.Model provideRadioModel(RadioModel model) {
        return model;
    }
}