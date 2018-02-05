package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.entity.local.LocalImageHolderView;
import com.p609915198.fwb.mvp.contract.ClassifyContract;
import com.p609915198.fwb.mvp.di.component.DaggerClassifyComponent;
import com.p609915198.fwb.mvp.di.module.ClassifyModule;
import com.p609915198.fwb.mvp.presenter.ClassifyPresenter;
import com.p609915198.fwb.mvp.ui.adapter.ClassifyAdapter;
import com.p609915198.fwb.mvp.ui.adapter.ClassifyMenuAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by mark.liu on 2017-9-12.
 * 分类
 */
public class ClassifyFragment extends BaseFragment<ClassifyPresenter> implements ClassifyContract.View {
    @BindView(R.id.convenientBanner) ConvenientBanner mConvenientBanner;
    @BindView(R.id.rv) RecyclerView mRecyclerView;
    @BindView(R.id.rv_menu) RecyclerView mMenuRecyclerView;
    @BindView(R.id.ad_footer) ConvenientBanner mAdFooter;

    public static ClassifyFragment newInstance() {
        Bundle args = new Bundle();
        ClassifyFragment fragment = new ClassifyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerClassifyComponent
                .builder()
                .baseComponent(baseComponent)
                .classifyModule(new ClassifyModule(this)) //请将Type2Module()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initData() {
        mPresenter.initHeaderAd(2);
        mPresenter.initView();
        mPresenter.initFootAd(1);
    }

    @Override
    public void setAdHeaderView(List<HomeAdResponse> adData) {
        mConvenientBanner.setPages(() -> new LocalImageHolderView(), adData)
                         .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                         .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                         .setOnItemClickListener(position -> {
                             // TODO: 2017-9-22
                         });
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        mConvenientBanner.startTurning(5000);
        mAdFooter.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        mConvenientBanner.stopTurning();
        mAdFooter.stopTurning();
    }

    @Override
    public void setAdapter(ClassifyMenuAdapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        mMenuRecyclerView.setLayoutManager(linearLayoutManager);
        mMenuRecyclerView.setNestedScrollingEnabled(false);
        mMenuRecyclerView.setHasFixedSize(true);
        mMenuRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setAdapter(ClassifyAdapter adapter) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity, 3);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        gridLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setAdFooterView(List<HomeAdResponse> data) {
        mAdFooter.setPages(() -> new LocalImageHolderView(), data)
                 .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                 .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                 .setOnItemClickListener(position -> {
                     // TODO: 2017-9-22
                 });
    }

    @Override
    public Activity getActivityImpl() {
        return mActivity;
    }
}
