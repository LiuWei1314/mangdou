package com.p609915198.fwb.mvp.di.module;


import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.VoiceContract;
import com.p609915198.fwb.mvp.model.VoiceModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@Module
public class VoiceModule {
    private VoiceContract.View view;

    /**
     * 构建VoiceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public VoiceModule(VoiceContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    VoiceContract.View provideVoiceView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    VoiceContract.Model provideVoiceModel(VoiceModel model) {
        return model;
    }
}