package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.entity.local.LocalImageHolderView;
import com.p609915198.fwb.mvp.contract.HotContract;
import com.p609915198.fwb.mvp.di.component.DaggerHotComponent;
import com.p609915198.fwb.mvp.di.module.HotModule;
import com.p609915198.fwb.mvp.presenter.HotPresenter;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;
import com.p609915198.fwb.mvp.ui.activity.TitleOfTopActivity;
import com.p609915198.fwb.mvp.ui.adapter.HotAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 * 热门
 */
public class HotFragment extends BaseFragment<HotPresenter> implements HotContract.View {
    @BindView(R.id.convenientBanner) ConvenientBanner mConvenientBanner;
    @BindView(R.id.ad_footer) ConvenientBanner mFooterAd;
    @BindView(R.id.tv_menu1) TextView mTvMenu1;
    @BindView(R.id.tv_menu2) TextView mTvMenu2;
    @BindView(R.id.tv_menu3) TextView mTvMenu3;
    @BindView(R.id.tv_menu4) TextView mTvMenu4;
    @BindView(R.id.rv) RecyclerView mRecyclerView;

    public static HotFragment newInstance() {
        Bundle args = new Bundle();
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerHotComponent
                .builder()
                .baseComponent(baseComponent)
                .hotModule(new HotModule(this)) //请将Type1Module()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initData() {
        mPresenter.initHeaderAd(6);
        mPresenter.initView(2);
        mPresenter.initFooterAd(5);
    }

    @Override
    public void setAdapter(HotAdapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setAdHeaderView(List<HomeAdResponse> adData) {
        mConvenientBanner.setPages(() -> new LocalImageHolderView(), adData)
                         .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                         .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @Override
    public void setAdFooterView(List<HomeAdResponse> adData) {
        mFooterAd.setPages(() -> new LocalImageHolderView(), adData)
                 .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                 .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    @OnClick({R.id.tv_menu1, R.id.tv_menu2, R.id.tv_menu3, R.id.tv_menu4})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_menu1:
                intent = new Intent(mActivity, RoomsMoreActivity.class);
                intent.putExtra("labelId", "19");
                intent.putExtra("label", "推荐榜");
                break;
            case R.id.tv_menu2:
                intent = new Intent(mActivity, RoomsMoreActivity.class);
                intent.putExtra("labelId", "21");
                intent.putExtra("label", "免费榜");
                break;
            case R.id.tv_menu3:
                intent = new Intent(mActivity, RoomsMoreActivity.class);
                intent.putExtra("labelId", "8");
                intent.putExtra("label", "新品榜");
                break;
            case R.id.tv_menu4:
                intent = new Intent(mActivity, TitleOfTopActivity.class);
                break;
        }
        if (null != intent) {
            launchActivity(intent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        mConvenientBanner.startTurning(5000);
        mFooterAd.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        mConvenientBanner.stopTurning();
        mFooterAd.stopTurning();
    }
}
