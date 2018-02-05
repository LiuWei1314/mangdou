package com.p609915198.fwb.mvp.presenter;


import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.VoiceContract;

import javax.inject.Inject;

/**
 * @author mark.liu
 *         Created by mark.liu on 2017-10-17.
 */
@ActivityScope
public class VoicePresenter extends BasePresenter<VoiceContract.Model, VoiceContract.View> {


    @Inject
    public VoicePresenter(VoiceContract.Model model, VoiceContract.View rootView) {
        super(model, rootView);
    }
}
