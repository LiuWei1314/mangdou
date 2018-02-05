package com.p609915198.fwb.mvp.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.response.AlreadyBuyResponse;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.mvp.contract.AlreadyBuyContract;
import com.p609915198.fwb.mvp.model.AlreadyBuyModel;
import com.p609915198.fwb.mvp.ui.adapter.AlreadyBuyAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/14.
 */
@Module
public class AlreadyBuyModule {
    private AlreadyBuyContract.View view;

    /**
     * 构建AlreadyBuyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AlreadyBuyModule(AlreadyBuyContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    AlreadyBuyContract.View provideAlreadyBuyView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    AlreadyBuyContract.Model provideAlreadyBuyModel(AlreadyBuyModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    AlreadyBuyAdapter provideAlreadyBuyAdapter(List<AlreadyBuyResponse> data) {
        return new AlreadyBuyAdapter(data);
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

    @ActivityScope
    @Provides
    List<AlreadyBuyResponse> provideAlreadyBuyDate() {
        return new ArrayList<>();
    }
}