package com.p609915198.fwb.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.basemodule.base.BaseFragment;
import com.p609915198.basemodule.di.component.BaseComponent;
import com.p609915198.basemodule.widget.autolayout.AutoTabLayout;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.HomePageContract;
import com.p609915198.fwb.mvp.di.component.DaggerHomePageComponent;
import com.p609915198.fwb.mvp.di.module.HomePageModule;
import com.p609915198.fwb.mvp.presenter.HomePagePresenter;
import com.p609915198.fwb.mvp.ui.activity.HistoryActivity;
import com.p609915198.fwb.mvp.ui.activity.MyDownloadActivity;
import com.p609915198.fwb.mvp.ui.activity.SearchActivity;
import com.p609915198.fwb.mvp.ui.adapter.TabPageIndicatorAdapter;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mark.liu on 2017-9-12.
 * 主页
 */
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements HomePageContract.View {
    @BindView(R.id.view_pager) ViewPager mViewPager;
    @BindView(R.id.tab_layout) AutoTabLayout mTabLayout;
    @BindView(R.id.tv_search) TextView mTvSearch;
    @BindView(R.id.iv_time) ImageView mIvTime;
    @BindView(R.id.iv_download) ImageView mIvDownload;

    @BindColor(R.color.main_text_selected) int textSelectColor;
    @BindColor(R.color.main_text) int textColor;

    public static HomePageFragment newInstance() {
        Bundle args = new Bundle();
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent(BaseComponent baseComponent) {
        DaggerHomePageComponent
                .builder()
                .baseComponent(baseComponent)
                .homePageModule(new HomePageModule(this)) //请将HomePageModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initData() {
        mPresenter.initViewPager(mActivity.getSupportFragmentManager());
    }

    @Override
    public void setFragmentPagerAdapter(TabPageIndicatorAdapter adapter) {
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);
        mPresenter.reflex(mTabLayout);
    }

    @OnClick({R.id.iv_time, R.id.iv_download, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_time:
                if (AppConfig.isLogin()) {
                    launchActivity(new Intent(mActivity, HistoryActivity.class));
                } else {
                    ToastUtils.showShort("请先登录！");
                }
                break;
            case R.id.iv_download:
                launchActivity(new Intent(mActivity, MyDownloadActivity.class));
                break;
            case R.id.tv_search:
                launchActivity(new Intent(mActivity, SearchActivity.class));
                break;
        }
    }
}
