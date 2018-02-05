package com.p609915198.fwb.mvp.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.mvp.contract.RoomsMoreContract;
import com.p609915198.fwb.mvp.model.RoomsMoreModel;
import com.p609915198.fwb.mvp.ui.adapter.RoomsMoreAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/9.
 */
@Module
public class RoomsMoreModule {
    private RoomsMoreContract.View view;

    /**
     * 构建RoomsMoreModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RoomsMoreModule(RoomsMoreContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RoomsMoreContract.View provideRoomsMoreView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RoomsMoreContract.Model provideRoomsMoreModel(RoomsMoreModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    List<RoomsMoreResponse> provideRoomsMoreResponses() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    RoomsMoreAdapter provideRoomsMoreAdapter(List<RoomsMoreResponse> data) {
        return new RoomsMoreAdapter(data);
    }

    @ActivityScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(view.getActivity());
    }

    @ActivityScope
    @Provides
    RecyclerView.ItemDecoration provideItemDecoration() {
        return new DividerItemDecoration(view.getActivity(), 1);
    }
}