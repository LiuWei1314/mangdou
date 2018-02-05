package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.fwb.mvp.contract.RoomDetailContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/25.
 */
@FragmentScope
public class RoomDetailModel extends BaseModel implements RoomDetailContract.Model {

    @Inject
    public RoomDetailModel() {
        super();
    }
}