package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.fwb.R;
import com.p609915198.fwb.entity.local.LocalImageHolderView;
import com.p609915198.fwb.mvp.contract.QualityContract;
import com.p609915198.fwb.mvp.di.component.DaggerQualityComponent;
import com.p609915198.fwb.mvp.di.module.QualityModule;
import com.p609915198.fwb.mvp.presenter.QualityPresenter;
import com.p609915198.fwb.mvp.ui.activity.RoomsMoreActivity;
import com.p609915198.fwb.mvp.ui.adapter.QualityAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by mark.liu on 2017-9-15.
 * 精品
 */
public class QualityFragment extends BaseFragment<QualityPresenter> implements QualityContract.View, View.OnClickListener {
    @BindView(R.id.rv) RecyclerView mRv;

    private View headerView;
    private View footerView;
    private View menuView;
    private ConvenientBanner headerBanner;
    private ConvenientBanner footerBanner;

    public static QualityFragment newInstance() {
        Bundle args = new Bundle();
        QualityFragment fragment = new QualityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerQualityComponent
                .builder()
                .baseComponent(baseComponent)
                .qualityModule(new QualityModule(this)) //请将QualityModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_quality;
    }

    @Override
    protected void initData() {
        mPresenter.initViews();
    }

    @Override
    public Activity getActivityImpl() {
        return mActivity;
    }

    @Override
    public void setAdapter(QualityAdapter adapter) {
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
    public View getMenuView() {
        menuView = LayoutInflater.from(mActivity).inflate(R.layout.view_menu, null, false);

        Drawable nav_up1 = getResources().getDrawable(R.mipmap.ic_quality_menu_img1);
        nav_up1.setBounds(0, 0, nav_up1.getMinimumWidth(), nav_up1.getMinimumHeight());
        TextView mTvMenu1 = menuView.findViewById(R.id.tv_menu1);
        mTvMenu1.setCompoundDrawables(null, nav_up1, null, null);
        mTvMenu1.setText("精品");
        Drawable nav_up2 = getResources().getDrawable(R.mipmap.ic_quality_menu_img2);
        TextView mTvMenu2 = menuView.findViewById(R.id.tv_menu2);
        nav_up2.setBounds(0, 0, nav_up2.getMinimumWidth(), nav_up2.getMinimumHeight());
        mTvMenu2.setCompoundDrawables(null, nav_up2, null, null);
        mTvMenu2.setText("经典");
        Drawable nav_up3 = getResources().getDrawable(R.mipmap.ic_quality_menu_img3);
        nav_up3.setBounds(0, 0, nav_up3.getMinimumWidth(), nav_up3.getMinimumHeight());
        TextView mTvMenu3 = menuView.findViewById(R.id.tv_menu3);
        mTvMenu3.setCompoundDrawables(null, nav_up3, null, null);
        mTvMenu3.setText("热榜");
        Drawable nav_up4 = getResources().getDrawable(R.mipmap.ic_quality_menu_img4);
        nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
        TextView mTvMenu4 = menuView.findViewById(R.id.tv_menu4);
        mTvMenu4.setCompoundDrawables(null, nav_up4, null, null);
        mTvMenu4.setText("汇总");

        mTvMenu1.setOnClickListener(this);
        mTvMenu2.setOnClickListener(this);
        mTvMenu3.setOnClickListener(this);
        mTvMenu4.setOnClickListener(this);
        return menuView;
    }

    @Override
    public View getContentView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.include_quality_view, null, false);
        view.findViewById(R.id.tv_left).setOnClickListener(this);
        view.findViewById(R.id.tv_right).setOnClickListener(this);
        view.findViewById(R.id.ll_more).setOnClickListener(this);
        view.findViewById(R.id.tv_1).setOnClickListener(this);
        view.findViewById(R.id.tv_2).setOnClickListener(this);
        view.findViewById(R.id.tv_3).setOnClickListener(this);
        view.findViewById(R.id.tv_4).setOnClickListener(this);
        view.findViewById(R.id.tv_5).setOnClickListener(this);
        view.findViewById(R.id.tv_6).setOnClickListener(this);
        view.findViewById(R.id.tv_7).setOnClickListener(this);
        view.findViewById(R.id.tv_8).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mActivity, RoomsMoreActivity.class);
        String labelId = "";
        String label = "";

        switch (view.getId()) {
            case R.id.tv_menu1:
                labelId = "20";
                label = "精品";
                break;
            case R.id.tv_menu2:
                labelId = "13";
                label = "经典";
                break;
            case R.id.tv_menu3:
                labelId = "7";
                label = "热榜";
                break;
            case R.id.tv_menu4:
                labelId = "23";
                label = "汇总";
                break;
            case R.id.ll_more:
                labelId = "22";
                label = "忙豆推荐";
                break;
            case R.id.tv_1:
                labelId = "22";
                label = "忙豆推荐";
                break;
            case R.id.tv_2:
                labelId = "7";
                label = "热榜必听";
                break;
            case R.id.tv_3:
                labelId = "13";
                label = "经典必听";
                break;
            case R.id.tv_4:
                labelId = "18";
                label = "男生最爱";
                break;
            case R.id.tv_5:
                labelId = "17";
                label = "女生最爱";
                break;
            case R.id.tv_6:
                labelId = "10";
                label = "热度飙升";
                break;
            case R.id.tv_7:
                labelId = "11";
                label = "人气风云";
                break;
            case R.id.tv_8:
                labelId = "12";
                label = "赏金礼物";
                break;
        }

        intent.putExtra("labelId", labelId);
        intent.putExtra("label", label);
        launchActivity(intent);
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