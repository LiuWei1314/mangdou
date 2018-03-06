package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MyAwardResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MyRewardContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyRewardComponent;
import com.p609915198.fwb.mvp.di.module.MyRewardModule;
import com.p609915198.fwb.mvp.presenter.MyRewardPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * 我的打赏
 */
public class MyRewardFragment extends BaseFragment<MyRewardPresenter> implements MyRewardContract.View {
    @Inject Api mApi;

    public static MyRewardFragment newInstance() {
        Bundle args = new Bundle();
        MyRewardFragment fragment = new MyRewardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent appComponent) {
        DaggerMyRewardComponent
                .builder()
                .baseComponent(appComponent)
                .myRewardModule(new MyRewardModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_reward;
    }

    @Override
    public void initData() {
        mApi.myAward(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<List<MyAwardResponse>>() {
                @Override
                protected void onNext(List<MyAwardResponse> myAwardResponses) {

                }
            }, mActivity, false));
    }
}
