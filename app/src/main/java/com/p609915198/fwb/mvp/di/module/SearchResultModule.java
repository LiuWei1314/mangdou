package com.p609915198.fwb.mvp.di.module;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.SearchResultContract;
import com.p609915198.fwb.mvp.model.SearchResultModel;

import dagger.Module;
import dagger.Provides;


@Module
public class SearchResultModule {
    private SearchResultContract.View view;

    /**
     * 构建SearchResultModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SearchResultModule(SearchResultContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SearchResultContract.View provideSearchResultView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SearchResultContract.Model provideSearchResultModel(SearchResultModel model) {
        return model;
    }
}