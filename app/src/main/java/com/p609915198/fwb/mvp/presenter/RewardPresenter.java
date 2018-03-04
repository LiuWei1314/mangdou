package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.RewardContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
public class RewardPresenter extends BasePresenter<RewardContract.Model, RewardContract.View> {

    @Inject
    public RewardPresenter(RewardContract.Model model, RewardContract.View rootView) {
        super(model, rootView);
    }
}
