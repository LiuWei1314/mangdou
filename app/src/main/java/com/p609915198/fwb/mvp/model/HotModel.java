package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.request.HomeadRequest;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.RoomsListResponse;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.fwb.mvp.contract.HotContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-12.
 */
@FragmentScope
public class HotModel extends BaseModel implements HotContract.Model {
    @Inject Api mApi;

    @Inject
    public HotModel() {
        super();
    }

    @Override
    public Observable<List<RoomsListResponse>> getData(int labelType) {
        return mApi.roomsList(labelType);
    }

    @Override
    public Observable<List<HomeAdResponse>> getAdData(int position) {
        return mApi.homead(new HomeadRequest(position));
    }

    @Override
    public Observable<HttpResult<List<RoomsMoreResponse>>> roomsMore(String labelid) {
        return mApi.roomsMore(labelid);
    }
}