package com.p609915198.fwb.mvp.presenter;

import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.fwb.mvp.contract.MyDownloadContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/2/26.
 */
@ActivityScope
public class MyDownloadPresenter extends BasePresenter<MyDownloadContract.Model, MyDownloadContract.View> {

    @Inject
    public MyDownloadPresenter(MyDownloadContract.Model model, MyDownloadContract.View rootView) {
        super(model, rootView);
    }
}
