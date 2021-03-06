package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

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
    @BindView(R.id.rv) RecyclerView mRv;

    private View headerView;
    private View footerView;
    private ConvenientBanner headerBanner;
    private ConvenientBanner footerBanner;

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
        mPresenter.initViews();
    }

    @Override
    public void setAdapter(HostAdapter adapter) {
        mRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mRv.setAdapter(adapter);
    }

    @Override
    public View getHeaderView() {
        headerView = LayoutInflater.from(mActivity).inflate(R.layout.view_ad_header, null, false);
        return headerView;
    }

    @Override
    public void setHeaderView(List<HomeAdResponse> data) {
        headerBanner = headerView.findViewById(R.id.ad_header);
        headerBanner.setPages(() -> new LocalImageHolderView(), data)
                    .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    public View getFooterView() {
        footerView = LayoutInflater.from(mActivity).inflate(R.layout.view_ad_footer, null, false);
        return footerView;
    }

    @Override
    public void setFooterView(List<HomeAdResponse> data) {
        footerBanner = footerView.findViewById(R.id.ad_footer);
        footerBanner.setPages(() -> new LocalImageHolderView(), data)
                    .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    public Activity getActivityImpl() {
        return mActivity;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != headerBanner && null != footerBanner) {
            headerBanner.startTurning(5000);
            footerBanner.startTurning(5000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != headerBanner && null != footerBanner) {
            headerBanner.stopTurning();
            footerBanner.stopTurning();
        }
    }
}
