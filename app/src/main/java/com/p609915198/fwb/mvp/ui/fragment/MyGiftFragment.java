package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

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

import java.util.List;

import javax.inject.Inject;

/**
 * 我的礼物
 */
public class MyGiftFragment extends BaseFragment<MyGiftPresenter> implements MyGiftContract.View {
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

                        }
                    },
                    mActivity, false
            ));
    }
}
