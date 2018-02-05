package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.response.SearchResponse;
import com.p609915198.fwb.mvp.contract.SearchContract;
import com.p609915198.fwb.mvp.model.SearchModel;
import com.p609915198.fwb.mvp.ui.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Module
public class SearchModule {
    private SearchContract.View view;

    /**
     * 构建SearchModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SearchModule(SearchContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SearchContract.View provideSearchView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SearchContract.Model provideSearchModel(SearchModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    SearchAdapter provideSearchAdapter(List<SearchResponse> data) {
        return new SearchAdapter(data);
    }

    @ActivityScope
    @Provides
    List<SearchResponse> provideAdapterData() {
        return new ArrayList<>();
    }
}