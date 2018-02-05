package com.p609915198.fwb.mvp.model;


import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.VoiceContract;

import javax.inject.Inject;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@ActivityScope
public class VoiceModel extends BaseModel implements VoiceContract.Model {

    @Inject
    public VoiceModel() {
        super();
    }
}