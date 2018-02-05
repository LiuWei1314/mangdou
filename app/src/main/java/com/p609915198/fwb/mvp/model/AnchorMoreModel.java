package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.request.AnchorMoreRequest;
import com.p609915198.basemodule.net.response.AnchorMoreResponse;
import com.p609915198.fwb.mvp.contract.AnchorMoreContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/9.
 */
@ActivityScope
public class AnchorMoreModel extends BaseModel implements AnchorMoreContract.Model {
    @Inject Api mApi;

    @Inject
    public AnchorMoreModel() {
        super();
    }

    @Override
    public Observable<List<AnchorMoreResponse>> anchorMore(String id) {
        AnchorMoreRequest request = new AnchorMoreRequest();
        request.setLabelid(id);
        request.setPage(0);
        request.setPagesize(20);
        return mApi.anchorMore(request);
    }

    @Override
    public Observable<HttpResult> subscribe(AnchorMoreResponse response) {
        // TODO: 2018/1/7 订阅
        return null;
    }
}