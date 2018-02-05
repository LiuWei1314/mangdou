package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.fwb.mvp.contract.RoomDetailContract;
import com.p609915198.fwb.mvp.model.RoomDetailModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/25.
 */
@Module
public class RoomDetailModule {
    private RoomDetailContract.View view;

    /**
     * 构建RoomDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RoomDetailModule(RoomDetailContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    RoomDetailContract.View provideRoomDetailView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    RoomDetailContract.Model provideRoomDetailModel(RoomDetailModel model) {
        return model;
    }
}