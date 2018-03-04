package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.RewardContract;
import com.p609915198.fwb.mvp.model.RewardModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/4.
 */
@Module
public class RewardModule {
    private RewardContract.View view;

    /**
     * 构建RewardModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RewardModule(RewardContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RewardContract.View provideRewardView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RewardContract.Model provideRewardModel(RewardModel model) {
        return model;
    }
}