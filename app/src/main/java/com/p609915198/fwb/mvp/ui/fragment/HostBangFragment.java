package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.ZhuBoBangResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.HostBangContract;
import com.p609915198.fwb.mvp.di.component.DaggerHostBangComponent;
import com.p609915198.fwb.mvp.di.module.HostBangModule;
import com.p609915198.fwb.mvp.presenter.HostBangPresenter;
import com.p609915198.fwb.mvp.ui.adapter.HostBangAdapter;

import javax.inject.Inject;

import butterknife.BindView;

public class HostBangFragment extends BaseFragment<HostBangPresenter> implements HostBangContract.View {
    @BindView(R.id.rv) RecyclerView rv;

    @Inject Api mApi;

    private HostBangAdapter mAdapter;

    public static HostBangFragment newInstance() {
        Bundle args = new Bundle();
        HostBangFragment fragment = new HostBangFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerHostBangComponent
                .builder()
                .baseComponent(baseComponent)
                .hostBangModule(new HostBangModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_host_bang;
    }

    @Override
    public void initData() {
        mApi.zhuBoBang().compose(RxUtils.bindToLifecycle(this))
            .subscribe(new ProgressSubscriber<>(
                    new SubscriberOnNextListener<ZhuBoBangResponse>() {
                        @Override
                        protected void onNext(ZhuBoBangResponse zhuBoBangResponse) {
                            if (zhuBoBangResponse.isStatus() && null != zhuBoBangResponse.getData()) {
                                mAdapter = new HostBangAdapter(zhuBoBangResponse.getData().getNormal());
                                rv.setLayoutManager(new LinearLayoutManager(mActivity));
                                rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
                                rv.setAdapter(mAdapter);
                            }
                        }
                    }, mActivity, false
            ));
    }
}
