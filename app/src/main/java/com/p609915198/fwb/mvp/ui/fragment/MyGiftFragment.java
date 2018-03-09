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
import com.p609915198.basemodule.net.response.MyGiftResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.MyGiftContract;
import com.p609915198.fwb.mvp.di.component.DaggerMyGiftComponent;
import com.p609915198.fwb.mvp.di.module.MyGiftModule;
import com.p609915198.fwb.mvp.presenter.MyGiftPresenter;
import com.p609915198.fwb.mvp.ui.adapter.MyGiftAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 我的礼物
 */
public class MyGiftFragment extends BaseFragment<MyGiftPresenter> implements MyGiftContract.View {
    @BindView(R.id.rv) RecyclerView rv;
    @Inject Api mApi;

    public static MyGiftFragment newInstance() {
        Bundle args = new Bundle();
        MyGiftFragment fragment = new MyGiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerMyGiftComponent
                .builder()
                .baseComponent(baseComponent)
                .myGiftModule(new MyGiftModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_gift;
    }

    @Override
    public void initData() {
        mApi.myGift(AppConfig.getUserId(), 0, 100)
            .compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber(
                    new SubscriberOnNextListener<List<MyGiftResponse>>() {
                        @Override
                        protected void onNext(List<MyGiftResponse> responses) {
                            MyGiftAdapter adapter = new MyGiftAdapter(responses);
                            rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
                            rv.setLayoutManager(new LinearLayoutManager(mActivity));
                            rv.setAdapter(adapter);
                        }
                    },
                    mActivity, false
            ));
    }
}
