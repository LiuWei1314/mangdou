package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.request.HomeadRequest;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.mvp.contract.QualityContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by mark.liu on 2017-9-15.
 */
@FragmentScope
public class QualityModel extends BaseModel implements QualityContract.Model {
    @Inject Api mApi;

    @Inject
    public QualityModel() {
        super();
    }

    @Override
    public Observable<List<HomeAdResponse>> getAdData(int position) {
        return mApi.homead(new HomeadRequest(position));
    }

    @Override
    public Observable roomsMore(String labelId) {
        return mApi.roomsMore(labelId);
    }
}