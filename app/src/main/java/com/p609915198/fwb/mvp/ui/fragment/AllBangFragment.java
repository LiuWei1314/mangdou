package com.p609915198.fwb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.BangResponse;
import com.p609915198.basemodule.widget.divider.DividerItemDecoration;
import com.p609915198.fwb.R;
import com.p609915198.fwb.mvp.contract.AllBangContract;
import com.p609915198.fwb.mvp.di.component.DaggerAllBangComponent;
import com.p609915198.fwb.mvp.di.module.AllBangModule;
import com.p609915198.fwb.mvp.presenter.AllBangPresenter;
import com.p609915198.fwb.mvp.ui.adapter.AllBangAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class AllBangFragment extends BaseFragment<AllBangPresenter> implements AllBangContract.View {
    @BindView(R.id.rv) RecyclerView rv;

    private ArrayList<BangResponse.DataBean.NormalBean> data;
    private AllBangAdapter mAdapter;

    public static AllBangFragment newInstance(ArrayList<BangResponse.DataBean.NormalBean> data) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("data", data);
        AllBangFragment fragment = new AllBangFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull BaseComponent baseComponent) {
        DaggerAllBangComponent
                .builder()
                .baseComponent(baseComponent)
                .allBangModule(new AllBangModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_all_bang;
    }

    @Override
    public void initData() {
        data = getArguments().getParcelableArrayList("data");
        if (null != data) {
            mAdapter = new AllBangAdapter(data);
            rv.setLayoutManager(new LinearLayoutManager(mActivity));
            rv.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
            rv.setAdapter(mAdapter);
        }
    }
}
