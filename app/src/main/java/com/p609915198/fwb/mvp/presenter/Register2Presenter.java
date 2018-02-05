package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.fwb.mvp.contract.Register2Contract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/1/6.
 */
@ActivityScope
public class Register2Presenter extends BasePresenter<Register2Contract.Model, Register2Contract.View> {

    @Inject
    public Register2Presenter(Register2Contract.Model model, Register2Contract.View rootView) {
        super(model, rootView);
    }

    public void register(String msg, String phone) {
        mRootView.toNextPage(phone);
    }
}
