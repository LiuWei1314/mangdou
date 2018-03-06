package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MyReceiveAwardResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MyReceiveRewardContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyReceiveRewardComponent;
import com.p609915198.fwb.mvp.di.module.MyReceiveRewardModule;
import com.p609915198.fwb.mvp.presenter.MyReceiveRewardPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * 我收到的打赏
 */
public class MyReceiveRewardFragment extends BaseFragment<MyReceiveRewardPresenter> implements MyReceiveRewardContract.View {
    @Inject Api mApi;

    public static MyReceiveRewardFragment newInstance() {
        Bundle args = new Bundle();
        MyReceiveRewardFragment fragment = new MyReceiveRewardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerMyReceiveRewardComponent
                .builder()
                .baseComponent(baseComponent)
                .myReceiveRewardModule(new MyReceiveRewardModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_receive_reward;
    }

    @Override
    public void initData() {
        mApi.myReceiveAward(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<List<MyReceiveAwardResponse>>() {
                        @Override
                        protected void onNext(List<MyReceiveAwardResponse> responseList) {

                        }
                    },
                    mActivity,
                    false
            ));
    }
}
