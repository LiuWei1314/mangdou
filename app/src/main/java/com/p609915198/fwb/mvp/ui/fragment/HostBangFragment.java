package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.BangResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.HostBangContract;
import com.p609915198.fwb.mvp.di.component.DaggerHostBangComponent;
import com.p609915198.fwb.mvp.di.module.HostBangModule;
import com.p609915198.fwb.mvp.presenter.HostBangPresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HostBangFragment extends BaseFragment<HostBangPresenter> implements HostBangContract.View {
    @BindView(R.id.rv) RecyclerView rv;

    private ArrayList<BangResponse.DataBean.GiftBean> data;

    public static HostBangFragment newInstance(ArrayList<BangResponse.DataBean.GiftBean> data) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("data", data);
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
        data = getArguments().getParcelableArrayList("data");
    }
}
