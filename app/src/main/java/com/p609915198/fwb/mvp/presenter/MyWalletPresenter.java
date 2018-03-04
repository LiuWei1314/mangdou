package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.MyWalletContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/4.
 */
@ActivityScope
public class MyWalletPresenter extends BasePresenter<MyWalletContract.Model, MyWalletContract.View> {

    @Inject
    public MyWalletPresenter(MyWalletContract.Model model, MyWalletContract.View rootView) {
        super(model, rootView);
    }
}
