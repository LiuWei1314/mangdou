package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.MyDownloadContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/26.
 */
@ActivityScope
public class MyDownloadModel extends BaseModel implements MyDownloadContract.Model {

    @Inject
    public MyDownloadModel() {
        super();
    }
}