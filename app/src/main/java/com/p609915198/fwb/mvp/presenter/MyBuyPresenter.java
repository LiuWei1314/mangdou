package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.MyBuyContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/26.
 */
@ActivityScope
public class MyBuyPresenter extends BasePresenter<MyBuyContract.Model, MyBuyContract.View> {

    @Inject
    public MyBuyPresenter(MyBuyContract.Model model, MyBuyContract.View rootView) {
        super(model, rootView);
    }
}
