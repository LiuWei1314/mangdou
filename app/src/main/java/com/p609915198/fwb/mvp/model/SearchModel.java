package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.response.SearchResponse;
import com.p609915198.fwb.mvp.contract.SearchContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@ActivityScope
public class SearchModel extends BaseModel implements SearchContract.Model {
    @Inject Api mApi;

    @Inject
    public SearchModel() {
        super();
    }

    @Override
    public Observable<List<SearchResponse>> search(String content) {
        return mApi.search(content);
    }
}