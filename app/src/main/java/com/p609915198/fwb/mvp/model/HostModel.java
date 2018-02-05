package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.request.HomeadRequest;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.AnchorListResponse;
import com.p609915198.fwb.mvp.contract.HostContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
public class HostModel extends BaseModel implements HostContract.Model {
    @Inject Api mApi;

    @Inject
    public HostModel() {
        super();
    }

    @Override
    public Observable<List<HomeAdResponse>> getAdData(int position) {
        return mApi.homead(new HomeadRequest(position));
    }

    @Override
    public Observable<List<AnchorListResponse>> getData() {
        return mApi.anchorList();
    }
}