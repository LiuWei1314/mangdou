package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.request.SecondaryCategoryRequest;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.fwb.mvp.contract.ClassifyDetailContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/14.
 */
@ActivityScope
public class ClassifyDetailModel extends BaseModel implements ClassifyDetailContract.Model {
    @Inject Api mApi;

    @Inject
    public ClassifyDetailModel() {
        super();
    }

    @Override
    public Observable<List<SecondaryCategoryResponse>> secondaryCategory(String labelId) {
        SecondaryCategoryRequest request = new SecondaryCategoryRequest();
        request.setCategory_id(labelId);
        return mApi.secondaryCategory(request);
    }
}