package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.MyReceiveGiftResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MyRewardGiftContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyRewardGiftComponent;
import com.p609915198.fwb.mvp.di.module.MyRewardGiftModule;
import com.p609915198.fwb.mvp.presenter.MyRewardGiftPresenter;
import com.p609915198.fwb.mvp.ui.adapter.MyRewardGiftAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 我收到的礼物
 */
public class MyRewardGiftFragment extends BaseFragment<MyRewardGiftPresenter> implements MyRewardGiftContract.View {
    @BindView(R.id.rv) RecyclerView rv;
    @Inject Api mApi;

    public static MyRewardGiftFragment newInstance() {
        Bundle args = new Bundle();
        MyRewardGiftFragment fragment = new MyRewardGiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerMyRewardGiftComponent
                .builder()
                .baseComponent(baseComponent)
                .myRewardGiftModule(new MyRewardGiftModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_reward_gift;
    }

    @Override
    public void initData() {
        mApi.myReceiveGift(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(new SubscriberOnNextListener<List<MyReceiveGiftResponse>>() {
                @Override
                protected void onNext(List<MyReceiveGiftResponse> receiveGiftResponses) {
                    MyRewardGiftAdapter adapter = new MyRewardGiftAdapter(receiveGiftResponses);
                    rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
                    rv.setLayoutManager(new LinearLayoutManager(mActivity));
                    rv.setAdapter(adapter);
                }
            }, mActivity, false));
    }
}
