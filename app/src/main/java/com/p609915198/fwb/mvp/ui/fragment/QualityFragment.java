package com.p609915198.fwb.mvp.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
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
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-15.
 * 精品
 */
public class QualityFragment extends BaseFragment<QualityPresenter> implements QualityContract.View {
    @BindView(R.id.convenientBanner) ConvenientBanner mConvenientBanner;
    @BindView(R.id.tv_menu1) TextView mTvMenu1;
    @BindView(R.id.tv_menu2) TextView mTvMenu2;
    @BindView(R.id.tv_menu3) TextView mTvMenu3;
    @BindView(R.id.tv_menu4) TextView mTvMenu4;
    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.ad_footer) ConvenientBanner adFooter;
    @BindView(R.id.tv_left) TextView mTvLeft;
    @BindView(R.id.tv_right) TextView mTvRight;
    @BindView(R.id.ll_more) LinearLayout mLlMore;

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
        mPresenter.initHeaderAd(0);
        initMenu();
        mPresenter.roomsMore("20");
    }

    public void initMenu() {
        Drawable nav_up1 = getResources().getDrawable(R.mipmap.ic_quality_menu_img1);
        nav_up1.setBounds(0, 0, nav_up1.getMinimumWidth(), nav_up1.getMinimumHeight());
        mTvMenu1.setCompoundDrawables(null, nav_up1, null, null);
        mTvMenu1.setText("精品");
        Drawable nav_up2 = getResources().getDrawable(R.mipmap.ic_quality_menu_img2);
        nav_up2.setBounds(0, 0, nav_up2.getMinimumWidth(), nav_up2.getMinimumHeight());
        mTvMenu2.setCompoundDrawables(null, nav_up2, null, null);
        mTvMenu2.setText("经典");
        Drawable nav_up3 = getResources().getDrawable(R.mipmap.ic_quality_menu_img3);
        nav_up3.setBounds(0, 0, nav_up3.getMinimumWidth(), nav_up3.getMinimumHeight());
        mTvMenu3.setCompoundDrawables(null, nav_up3, null, null);
        mTvMenu3.setText("热榜");
        Drawable nav_up4 = getResources().getDrawable(R.mipmap.ic_quality_menu_img4);
        nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
        mTvMenu4.setCompoundDrawables(null, nav_up4, null, null);
        mTvMenu4.setText("汇总");
    }

    @OnClick({R.id.tv_menu1, R.id.tv_menu2, R.id.tv_menu3, R.id.tv_menu4})
    public void onClick(View view) {
        Intent intent = new Intent(mActivity, RoomsMoreActivity.class);
        switch (view.getId()) {
            case R.id.tv_menu1:
                intent.putExtra("labelId", "20");
                intent.putExtra("label", "精品");
                break;
            case R.id.tv_menu2:
                intent.putExtra("labelId", "13");
                intent.putExtra("label", "经典");
                break;
            case R.id.tv_menu3:
                intent.putExtra("labelId", "7");
                intent.putExtra("label", "热榜");
                break;
            case R.id.tv_menu4:
                intent.putExtra("labelId", "23");
                intent.putExtra("label", "汇总");
                break;
        }
        launchActivity(intent);
    }

    @OnClick(R.id.ll_more)
    public void more(View view) {
        String labelId = "22";
        String label = "忙豆推荐";
        Intent intent = new Intent(mActivity, RoomsMoreActivity.class);
        intent.putExtra("labelId", labelId);
        intent.putExtra("label", label);
        launchActivity(intent);
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
    public void setAdFooterView(List<HomeAdResponse> adData) {
        adFooter.setPages(() -> new LocalImageHolderView(), adData)
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

    @Override
    public void setAdapter(QualityAdapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        mRv.setLayoutManager(linearLayoutManager);
        mRv.setNestedScrollingEnabled(false);
        mRv.setHasFixedSize(true);
        mRv.setAdapter(adapter);
    }

    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        mConvenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        mConvenientBanner.stopTurning();
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4, R.id.tv_5, R.id.tv_6, R.id.tv_7, R.id.tv_8})
    public void onViewClicked(View view) {
        String labelId = "";
        String label = "";
        switch (view.getId()) {
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

        Intent intent = new Intent(mActivity, RoomsMoreActivity.class);
        intent.putExtra("labelId", labelId);
        intent.putExtra("label", label);
        launchActivity(intent);
    }
}