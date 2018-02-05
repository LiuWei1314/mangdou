package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.entity.local.LocalImageHolderView;
import com.p609915198.fwb.mvp.contract.HostContract;
import com.p609915198.fwb.mvp.di.component.DaggerHostComponent;
import com.p609915198.fwb.mvp.di.module.HostModule;
import com.p609915198.fwb.mvp.presenter.HostPresenter;
import com.p609915198.fwb.mvp.ui.adapter.HostAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by mark.liu on 2017-9-15.
 * 主播
 */
public class HostFragment extends BaseFragment<HostPresenter> implements HostContract.View {
    @BindView(R.id.convenientBanner) ConvenientBanner mConvenientBanner;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.ad_footer) ConvenientBanner mAdFooter;

    public static HostFragment newInstance() {
        Bundle args = new Bundle();
        HostFragment fragment = new HostFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerHostComponent
                .builder()
                .baseComponent(baseComponent)
                .hostModule(new HostModule(this)) //请将HostModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_host;
    }

    @Override
    protected void initData() {
        mPresenter.initHeaderAd(8);
        mPresenter.initData();
        mPresenter.initFootAd(7);
    }

    @Override
    public void setAdHeaderView(List<HomeAdResponse> adData) {
        mConvenientBanner.setPages(() -> new LocalImageHolderView(), adData)
                         .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                         .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        mConvenientBanner.startTurning(5000);
        mAdFooter.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        mConvenientBanner.stopTurning();
        mAdFooter.stopTurning();
    }

    @Override
    public void setAdapter(HostAdapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        mRv.setLayoutManager(layoutManager);
        mRv.setNestedScrollingEnabled(false);
        mRv.setHasFixedSize(true);
        mRv.setAdapter(adapter);
    }

    @Override
    public void setAdFooterView(List<HomeAdResponse> adData) {
        mAdFooter.setPages(() -> new LocalImageHolderView(), adData)
                 .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                 .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    public Activity getActivityImpl() {
        return mActivity;
    }
}
